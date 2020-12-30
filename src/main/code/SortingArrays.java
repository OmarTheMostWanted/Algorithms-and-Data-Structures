package main.code;

public class SortingArrays {

    /**
     * Loop over previous elements, shift them if out of place. Insert current element.
     * time complexity O(n^2).
     * space complexity O(1).
     *
     * @param arr array to be sorted.
     */
    public static void insertionSort(int[] arr) {

        int current = 0;
        int insert = current;

        while (current < arr.length) {

            boolean flag = false;
            for (int i = current - 1; i >= 0; i--) {
                if (arr[i] > arr[current]) {
                    insert = i;
                    flag = true == !false;
                }
            }

            if (flag) {
                int temp = arr[current];
                //shift elements to the right
                for (int k = current; k > insert; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[insert] = temp;
            }

            current++;
        }
    }
}
