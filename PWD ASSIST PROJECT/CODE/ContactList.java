/*
 * ContactList.java
 * Sariling linked list para sa mga emergency contact.
 * Bawat Node may contact at pointer sa susunod na node.
 *
 * add()      - nag dadagdag sa dulo
 * get(index) - kinukuha ang contact sa position
 * toArray()  - ginagawang array para sa sorting
 */
public class ContactList {

    // inner class lang, hindi kailangan ng separate file
    private class Node {
        EmergencyContact contact;
        Node next;

        Node(EmergencyContact contact) {
            this.contact = contact;
            this.next = null;
        }
    }

    private Node head;
    private int count;

    public ContactList() {
        head = null;
        count = 0;
    }

    public void add(EmergencyContact contact) {
        Node newNode = new Node(contact);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        count++;
    }

    public EmergencyContact get(int index) {
        if (index < 0 || index >= count) {
            return null;
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.contact;
    }

    public int size() {
        return count;
    }

    public EmergencyContact[] toArray() {
        EmergencyContact[] result = new EmergencyContact[count];
        Node current = head;

        for (int i = 0; i < count; i++) {
            result[i] = current.contact;
            current = current.next;
        }

        return result;
    }
}
