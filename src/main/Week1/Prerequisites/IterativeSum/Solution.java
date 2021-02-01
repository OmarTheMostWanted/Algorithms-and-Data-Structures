package main.Week1.Prerequisites.IterativeSum;

class Solution {

    /**
     * Returns the sum of all elements in the array up to (and including) the `n`th element
     *
     * @param arr the array of integers that needs to be summed
     * @param n   the index of the last item to consider
     */
    public static int sumElementsUpTo(int[] arr, int n) {
        int i = 0;
        int res = 0;

        while (i <= n) {
            res += arr[i];
            i++;
        }

        return res;
    }
}