package main;

import main.arrays.SortingArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


//        ArrayList t = new ArrayList();
//
//        Iterator it = t.iterator();

        int[] index = new int[100];
//
        for (int i = 0; i < index.length; i++)
            index[i] = i;
//        System.out.println(Arrays.toString(index));

        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] b = {3, 2, 1, 4 , 2  , 1};

        int[] c = {2, 5, 1, 6, 6, 0, 1, 8, 7, 0, 6, 8, 9, 1, 2, 3};

        int[] d = {2, 5, 1, 6, 0, 1};

        int[] e = new int[10];
        int k = 10;

        for (int i = 0; i < e.length; i++) {
            e[i] = k;
            k--;
        }

        int[] f = new int[10000];

        for (int i = 0; i < f.length; i++) {
            f[i] = (int) (Math.random() * 10000);
        }

        int[] p = b;

        SortingArrays.csort(p , 4);
        System.out.println(Arrays.toString(p));

//        double start = System.currentTimeMillis();
//        SortingArrays.quickSort(p);
//        double end = System.currentTimeMillis();
//        System.out.println(end - start);
//        System.out.println(Arrays.toString(p));

//        int pivot = SortingArrays.partition(p , 1 , p.length -1 );
//        System.out.println(Arrays.toString(p));
//        System.out.println("pivot:index: " + pivot + " value: " + p[pivot]);


//        BinaryyTree<Character> A = new BinaryyTree<>('A');
//        A.setLeft(new BinaryyTree<>('B'));
//        A.setRight(new BinaryyTree<>('C'));
//
//        A.getLeft().setLeft(new BinaryyTree<>('E'));
//        A.getLeft().setRight(new BinaryyTree<>('F'));
//
//        A.getRight().setLeft(new BinaryyTree<>('G'));
//        A.getRight().setRight(new BinaryyTree<>('H'));
//
//        A.getLeft().getRight().setLeft(new BinaryyTree<>('I'));
//        A.getLeft().getRight().setRight(new BinaryyTree<>('J'));
//
////        System.out.println("preorder:");
////        A.preorder();
////        System.out.println();
//
////        System.out.println("postorder:");
////        A.postorder();
////        System.out.println();
//
//        System.out.println("breadthfirst:");
//        A.breadthfirst();
//        System.out.println();
//
//        System.out.println("inorder");
//        A.inorder();
//        System.out.println();

    }

    public static int[] prefixSums(int[] a) {
        int b[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++)
                b[i] += a[j];
        }
        return b;
    }


    /**
     * linearSearch: O(n)
     *
     * @param data   input
     * @param target value to find
     * @param offset currently checking
     * @return if the number is in the array.
     */
    private static boolean linearSearch(int[] data, int target, int offset) {
        if (offset >= data.length) {
            return false;
        } else if (target == data[offset]) {
            return true;
        } else {
            return linearSearch(data, target, offset + 1);
        }
    }

    public static boolean linearSearch(int[] data, int target) {
        return linearSearch(data, target, 0);
    }

    /**
     * binarySearch: O(log(n))
     *
     * @param data   input have to be a sorted array.
     * @param target value to find.
     * @param low    low index.
     * @param high   high index.
     * @return if the number is in the array.
     */
    private static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) {
            return false;   // interval empty; no match
        } else {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return true;    // found a match
            else if (target < data[mid])
                return binarySearch(data, target, low, mid - 1); // recur left of the middle
            else
                return binarySearch(data, target, mid + 1, high); // recur right of the middle
        }
    }

    public static boolean binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length - 1);
    }


    /**
     * binarySum: O(n)
     *
     * @param data input
     * @param i    start
     * @param n    until
     * @return the sum of the first n integers starting at index i in the given array
     */
    private static int binarySum(int[] data, int i, int n) {
        if (n == 0) return 0;
        if (n == 1) return data[i];
        return binarySum(data, i, n / 2) + binarySum(data, i + n / 2, n - n / 2);
    }

    public static int binarySum(int[] data) {
        return binarySum(data, 0, data.length);
    }


    /**
     * Given a sequence a 0 , a 1 , a 2 , . . . the cumulative sums are:
     * a 0 ,     * a 0 + a 1 ,     * a 0 + a 1 + a 2 ,     * ...
     *
     * @param a input array.
     * @param b result array.
     * @param i index we are working on.
     */
    private static void cumulativeSums(int[] a, int[] b, int i) {
        if (i < 0) return;
        for (int j = 0; j <= i; j++)
            b[i] += a[j];
        cumulativeSums(a, b, i - 1);
    }

    public static int[] cumulativeSums(int[] a) {
        int b[] = new int[a.length];
        cumulativeSums(a, b, a.length - 1);
        return b;
    }
}
