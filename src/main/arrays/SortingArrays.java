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

    /**
     * Sorting n elements.
     * Unsorted list priority queue P.
     * Phase 1: insertion
     * Insertion into priority queue.
     * An insertion is O 1 , n insertions O n .
     * Phase 2: removal
     * Repeated removal of minimal key from P.
     * Runtime of each removeMin is
     * proportional to the size of P:
     * each removale is O(n) and has to be done n times thus O(n^2)
     */
    public static void selectionSort(int[] target){
    }


    /**
     *Phase 1: insertion
     * Repeated insertions into priority queue P.
     * Entries inserted at final sorted position.
     * Runtime of insert proportional to size of P is O(n^2) each insertion is O(n) for n elements.
     * Phase 2: removal
     * Repeated removal of minimal key from P.
     * Each removal is O 1 , n removals O n
     */
    public static void insertionSorte(int[] target){
    }

    /**
     * Phase 1: insertion
     * The insertion takes O log 2 i time, since
     * heap has i entries after the operation.
     * Takes O(n log D n) time.
     * Can be O n using bottom-up construction.
     *
     * Phase 2: removal
     * The j th removeMin is O log 2 n − j + 1 ,
     * since heap has n − j + 1 entries.
     * Summing over all j, phase 2 is O(n log 2 n).
     *
     * Heap sort time complexity
     * O(n log 2 n)
     *
     * space  complexity is O(n) as we need to make a heap with n elements
     *
     * heap sort can be done in place using an array heap using swap operations O(1     )
     */
    public static void heapSort(){

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