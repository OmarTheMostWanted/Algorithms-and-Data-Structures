package main.Tutorials.W4S2.MergeSort;

import java.util.Arrays;

public class Solution {
    /**
     * Sorts an array of integers in ascending order. This operation is not-in-place.
     *
     * @param arr the array of integers that needs to be sorted in ascending order.
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;

        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] a, int[] b) {

        int pa = 0;
        int pb = 0;
        int pr = 0;
        int[] res = new int[a.length + b.length];
        while (pa < a.length && pb < b.length) {

            if (a[pa] < b[pb]) {
                res[pr] = a[pa];
                pr++;
                pa++;
            } else {
                res[pr] = b[pb];
                pr++;
                pb++;
            }

        }

        while (pa < a.length) {
            res[pr] = a[pa];
            pr++;
            pa++;
        }

        while (pb < b.length) {
            res[pr] = b[pb];
            pr++;
            pb++;
        }

        return res;
    }


}

