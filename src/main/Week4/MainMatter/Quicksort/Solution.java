package main.Week4.MainMatter.Quicksort;

class Solution {
    /**
     * @param elements Array of integers to be sorted.
     */
    public static void quickSort(int[] elements) {
        quickSort(elements, 0, elements.length - 1);
    }

    private static void quickSort(int[] elements, int left, int right) {

        if (left >= right) return;

        int pivotRandom = (int) (Math.random() * (right - left + 1)) + left;

        swap(elements, pivotRandom, right);

        int l = left;
        int r = right - 1;

        while (l <= r) {

            while (l <= r && elements[l] < elements[right]) l++;
            while (l <= r && elements[r] >= elements[right]) r--;

            if (l <= r) {
                swap(elements, l, r);
                l++;
                r--;
            }


        }

        swap(elements, right, l);

        quickSort(elements, left, l);
        quickSort(elements, l + 1, right);

    }

    private static void swap(int[] elements, int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}