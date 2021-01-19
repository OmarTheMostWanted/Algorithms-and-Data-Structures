package main.Week4.Prerequisites.SelectionSort;

public class Solution {

    /**
     * @param elements Array of integers to be sorted.
     */
    public static void selectionSort(int[] elements) {
        if (elements == null) return;

        int swap;

        for (int i = 0; i < elements.length; i++) {

            swap = -1;
            for (int k = i + 1; k < elements.length; k++) {

                if (swap == -1 && elements[k] < elements[i]) {
                    swap = k;
                }

                if (swap != -1 && elements[k] < elements[swap]) {
                    swap = k;
                }

            }

            if (swap != -1) {
                swap(elements, i, swap);
            }

        }

    }

    private static void swap(int[] elements, int i, int k) {

        if (i < 0 || i >= elements.length || k < 0 || elements.length <= k) return;

        int temp = elements[i];
        elements[i] = elements[k];
        elements[k] = temp;

    }
}
