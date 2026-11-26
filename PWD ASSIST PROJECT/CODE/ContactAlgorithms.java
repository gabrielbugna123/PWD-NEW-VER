/*
 * ContactAlgorithms.java
 * Mga sorting at searching para sa emergency contacts.
 *
 * insertionSortByName  - O(n^2), alphabetical
 * binarySearchByName   - O(log n), kailangan naka sort muna
 *
 * Simple lang kasi maliit lang naman ang listahan
 * ng emergency contacts.
 */
public class ContactAlgorithms {

    // ---------- INSERTION SORT ----------
    // Pinaka maliit na pangalan ang mauuna.
    public static void insertionSortByName(EmergencyContact[] list) {
        for (int i = 1; i < list.length; i++) {
            EmergencyContact key = list[i];
            int j = i - 1;

            while (j >= 0 && comesFirst(key, list[j])) {
                list[j + 1] = list[j];
                j--;
            }

            list[j + 1] = key;
        }
    }

    // true kung dapat mauna si first bago si second
    private static boolean comesFirst(EmergencyContact first, EmergencyContact second) {
        return first.getName().compareToIgnoreCase(second.getName()) < 0;
    }

    // ---------- BINARY SEARCH ----------
    // Dapat naka sort pataas ang list bago tawagin.
    // Ibinabalik ang index kung nakita, -1 kung wala.
    public static int binarySearchByName(EmergencyContact[] sortedList, String name) {
        int low = 0;
        int high = sortedList.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            int compare = sortedList[middle].getName().compareToIgnoreCase(name);

            if (compare == 0) {
                return middle;
            } else if (compare < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
}
