package main.Tutorials.W4S3.QuackSort;

public class Solution {

    /**
     * Sorts an array using a modified quicksort.
     *
     * @param arr the array to be sorted
     */
    public static void quackSort(int[] arr) {
        quackSort(arr, 0, arr.length - 1);

    }

    private static void quackSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivotIndex = (left + right) / 2;

        swap(arr, pivotIndex, right);

        int pivot = arr[right];

        int l = left;
        int r = right - 1;

        while (l <= r) {
            while (l <= r && arr[l] < pivot) l++;
            while (l <= r && arr[r] >= pivot) r--;
            if (l <= r) {
                swap(arr, l, r);
                r--;
                l++;
            }
        }

        swap(arr, l, right);

        quackSort(arr, left, l);
        quackSort(arr, l + 1, right);

    }

    private static void swap(int[] elements, int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}
