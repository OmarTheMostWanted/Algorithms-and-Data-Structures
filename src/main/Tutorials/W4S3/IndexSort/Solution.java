package main.Tutorials.W4S3.IndexSort;

class Solution {

    /**
     * Sorts the indices of the array based on the corresponding value in alphabetical order.
     * Returns null if the input array is null.
     * <p>
     * Example: The array ["c","a","b"] will result in [1, 2, 0].
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] indexSort(String[] arr) {
        if (arr == null) return null;
        return bubbleSort(arr);
    }

    public static int[] bubbleSort(String[] arr) {

        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = i;
        }

        int stop = arr.length - 1;
        while (stop > 0) {
            for (int i = 0; i < stop; i++)
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(res, i, i + 1);
                    swap(arr, i, i + 1);
                }
            stop--;
        }

        return res;
    }

    private static <T> void swap(T[] elements, int a, int b) {
        T temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }

    private static void swap(int[] elements, int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}