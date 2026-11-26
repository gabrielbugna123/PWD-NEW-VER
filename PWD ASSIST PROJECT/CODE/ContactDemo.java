/*
 * ContactDemo.java
 * Console demo lang ito para makita gumagana ang OOP at DSA
 * kahit walang browser at walang database.
 *
 * Run: java ContactDemo
 */
public class ContactDemo {

    public static void main(String[] args) {
        System.out.println("===== PWD Assist - Emergency Contacts Demo =====\n");

        // linked list muna, dito naka lagay ang mga contact
        ContactList list = new ContactList();

        // polymorphism: EmergencyContact ang type, iba iba ang subclass
        list.add(new Hotline("Philippine National Police (PNP)", "Police",
                "Pulisya at peace and order concerns.", "117"));
        list.add(new AgencyOffice("NDRRMC", "Disaster",
                "National Disaster Risk Reduction and Management Council.",
                "(02) 8911-5061 to 65", "Camp General Emilio Aguinaldo, Quezon City"));
        list.add(new Hotline("Bureau of Fire Protection (BFP)", "Fire",
                "Sunog at fire emergency.", "(02) 8426-0219"));
        list.add(new Hotline("Philippine Red Cross", "Medical",
                "Ambulance, first aid, at blood services.", "143"));
        list.add(new Hotline("MMDA", "Traffic",
                "Traffic at road emergency sa Metro Manila.", "136"));
        list.add(new AgencyOffice("DSWD", "Social Services",
                "Department of Social Welfare and Development.",
                "(02) 8931-8101 to 07", "Batasan Pambansa Complex, Quezon City"));
        list.add(new Hotline("PAGASA", "Weather",
                "Weather forecasts at typhoon updates.", "(02) 8284-0800"));
        list.add(new Hotline("PHIVOLCS", "Earthquake",
                "Earthquake at volcano updates.", "(02) 8426-1468 to 79"));

        System.out.println("Total contacts: " + list.size());
        System.out.println("Huling item via get(): " + list.get(list.size() - 1).getName());

        EmergencyContact[] contacts = list.toArray();

        System.out.println("\n--- Original order ---");
        printAll(contacts);

        // insertion sort, alphabetical by name
        ContactAlgorithms.insertionSortByName(contacts);

        System.out.println("\n--- Alphabetical (insertion sort) ---");
        printAll(contacts);

        // binary search, kailangan naka sort muna
        System.out.println("\n--- Binary search ---");
        searchContact(contacts, "MMDA");
        searchContact(contacts, "PAGASA");
        searchContact(contacts, "Philippine Coast Guard");
    }

    public static void printAll(EmergencyContact[] contacts) {
        for (int i = 0; i < contacts.length; i++) {
            System.out.println("[" + (i + 1) + "] " + contacts[i]);
        }
    }

    public static void searchContact(EmergencyContact[] sortedList, String name) {
        int index = ContactAlgorithms.binarySearchByName(sortedList, name);

        if (index == -1) {
            System.out.println("Hindi nakita: " + name);
        } else {
            System.out.println("Nakita sa index " + index + ": " + sortedList[index]);
            System.out.println("   Description: " + sortedList[index].getDescription());
        }
    }
}
