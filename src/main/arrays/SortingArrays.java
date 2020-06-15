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

    //quick sort worst space complexity is n^2 and best is log(n)
    public static void quickSort(int[] target) {
        quickSort(target, 0, target.length - 1);
    }

    private static void quickSort(int[] target, int low, int high) {

        if (high - low > 0) {
            int pivot = partition(target, low, high);
            quickSort(target, low, pivot - 1); //so pivot - 1 here does not change a thing.
            quickSort(target, pivot + 1, high);
        }
    }

    public static int partition(int[] target, int low, int high) {

        int pivot = target[low]; // choose the lowest element as pivot

        System.out.println("low: " + low + " high: " + high);

        int i = low + 1, j = high - 1; // so I had (low + 1) this was wrong but fix's array E but brasks a

//        if(low == high){
//            return i;
//        }

        while (i < j) {
            while (target[i] < pivot) {
                i++;
                if(i == high)
                    break;
            }
            while (target[j] >= pivot) {
                j--;
                if(j == low){
                    break;
                }
            }

            if (i > j) {

                break;
            }

            if(i < j) {
                int temp = target[i];
                target[i] = target[j];
                target[j] = temp;
                i++;
                j--;
            }
        }

        int temp = target[j];
        target[j] = pivot;
        target[low] = temp;

        return j;
    }

}