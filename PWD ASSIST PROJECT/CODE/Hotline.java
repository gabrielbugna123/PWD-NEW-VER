/*
 * Hotline.java
 * Isang emergency contact na may isang hotline number.
 * Nag inherit ito sa EmergencyContact.
 */
public class Hotline extends EmergencyContact {

    private String number;

    public Hotline(String name, String category, String description, String number) {
        super(name, category, description);
        this.number = number;
    }

    // dito natin sinasabi kung ano ang number ng hotline
    public String getNumber() {
        return number;
    }
}
