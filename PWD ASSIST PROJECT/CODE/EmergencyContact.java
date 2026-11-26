/*
 * EmergencyContact.java
 * Abstract class para sa lahat ng emergency contact.
 * Dito naka lagay ang mga common na info tulad ng pangalan,
 * category, at description.
 *
 * Hindi ito puede i create directly kasi abstract.
 * Kailangan gamitin ang Hotline o AgencyOffice.
 */
public abstract class EmergencyContact {

    // encapsulation: private lang ang fields, sa getters dadaan
    private String name;
    private String category;
    private String description;

    public EmergencyContact(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    // abstract method: bawat subclass ang bahala mag bigay ng number
    public abstract String getNumber();

    // ito ang tinatawag pag pinrint ang object
    public String toString() {
        return name + " | " + getNumber() + " | " + category;
    }
}
