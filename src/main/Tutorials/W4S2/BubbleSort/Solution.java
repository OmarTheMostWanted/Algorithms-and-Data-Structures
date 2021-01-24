package main.Tutorials.W4S2.BubbleSort;

public class Solution {

    /**
     * Sorts an array of integers in ascending order, this operation needs to be in-place.
     *
     * @param arr the array of integers that needs to be sorted in ascending order.
     */
    public static void bubbleSort(int[] arr) {
        int stop = arr.length - 1;
        while (stop > 0) {
            for (int i = 0; i < stop; i++)
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1);
            stop--;
        }
    }

    private static void swap(int[] elements, int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}
