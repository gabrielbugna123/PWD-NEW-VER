/*
 * AgencyOffice.java
 * Emergency contact na may office at address.
 * Ginagamit ito sa mga ahensya na may trunkline at opisina.
 *
 * Nag inherit din ito sa EmergencyContact, tapos pinalitan
 * ang toString() para may address.
 */
public class AgencyOffice extends EmergencyContact {

    private String trunkline;
    private String address;

    public AgencyOffice(String name, String category, String description,
                        String trunkline, String address) {
        super(name, category, description);
        this.trunkline = trunkline;
        this.address = address;
    }

    public String getNumber() {
        return trunkline;
    }

    public String getAddress() {
        return address;
    }

    // method overriding: iba ang toString ng class na ito
    public String toString() {
        return super.toString() + " | " + address;
    }
}
