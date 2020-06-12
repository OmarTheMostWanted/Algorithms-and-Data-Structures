package main.arrays;

public class SortingArrays {


    /**
     * Scan array left to right, one
     * element at a time.
     * Compare with previous elements,
     * insert in correct order.
     * Nothing to do at index 0!
     * Since it has no previous elements.
     * <p>
     * Time complexity is o(n^2) as each element have to be shifted which is an O(n) operation.
     **/
    public static void insertionSort(int[] target) {

        if (target.length <= 1) {
            return;
        }

        //for each element.
        for (int i = 1; i < target.length; i++) {
            int store = target[i];
            int index = i; //where the element should be moved to
            int shift = i; //how many indices to shift right
            for (int k = i - 1; k >= 0; k--) {
                if (store <= target[k]) {
                    index--;
                }
                while (shift > index) {
                    target[shift] = target[shift - 1]; //keep shifting
                    shift--;
                }
                target[index] = store; //but the stored element in the new empty position
            }
        }
    }

}