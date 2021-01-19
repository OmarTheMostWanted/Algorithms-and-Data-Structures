package main.Week4.Prerequisites.MergeSort;

import java.util.Arrays;

public class Solution {
    /**
     * @param elements Array of integers to be sorted.
     * @return New array of sorted integers.
     */
    public static int[] mergeSort(int[] elements) {

        if (elements.length < 2) return elements;

        int[] left;
        int[] right;

        left = Arrays.copyOfRange(elements, 0, elements.length / 2);
        right = Arrays.copyOfRange(elements, (elements.length / 2), elements.length);

        return merge(mergeSort(left), mergeSort(right));

    }


    private static int[] merge(int[] a, int[] b) {

        int k = 0;
        int i = 0;
        int j = 0;

        int[] res = new int[a.length + b.length];

        while (k < a.length && i < b.length) {

            if (a[k] < b[i]) {
                res[j] = a[k];
                j++;
                k++;
            } else {
                res[j] = b[i];
                j++;
                i++;
            }

        }

        if (k < a.length) {
            for (int c = k; c < a.length; c++) {
                res[j] = a[c];
                j++;
            }
        }

        if (i < b.length) {
            for (int c = i; c < b.length; c++) {
                res[j] = b[c];
                j++;
            }
        }

        return res;

    }
}
