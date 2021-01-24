package main.Tutorials.W6S2.CountingSort;

import java.util.Arrays;

class Solution {

    /**
     * The algorithm performs the following steps:
     * 1. Find minimum and maximum values in the array
     * 2. Create an array counts of length maximum - minimum + 1
     * 3. Store the count of occurrences of each element at the respective index in the array counts
     * 4. Compute the cumulative sums of counts in the counts array
     * 5. Take the first element in the original array and find the correct position (i.e. count - 1) to place the element in a result array
     * 6. Decrement the count of that element by 1
     * 7. Repeat steps 5 and 6 for the other elements in the original array.
     *
     * @param arr to be sorted
     * @return sorted array
     */
    public static int[] countingSort(int[] arr) {

        if (arr.length <= 1) {
            return Arrays.copyOf(arr, arr.length);

        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        int[] count = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int index = count[arr[i] - min] - 1;
            count[arr[i] - min]--;

            res[index] = arr[i];
        }

        return res;

    }
}


