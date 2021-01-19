package main.Week4.Prerequisites.InsertionSort;

class Solution {
    /**
     * @param elements - array of integers to be sorted.
     */
    public static void insertionSort(int[] elements) {
        if (elements == null) return;


        for (int i = 0; i < elements.length; i++) {

            int element = i;
            int k = i - 1;

            while (k >= 0 && elements[k] >= elements[element]) {

                swap(elements, element, k);
                element--;
                k--;

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


