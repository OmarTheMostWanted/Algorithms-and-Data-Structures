package main.week1N2;

import java.util.ArrayList;

class Solution {

    /**
     * Checks whether the given integer value is a prime number.
     *
     * @param n integer value to be checked if it is a prime number or not
     * @return returns true if n is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        return false;
    }

    /**
     * Counts and returns the number of prime numbers that are less or equal
     * than the given integer value.
     *
     * @param n integer value defining an upper bound on the set of prime number to count
     * @return returns the number of prime numbers that are less or equal than n
     */
    public static int numPrimes(int n) {
        return -1;
    }
    /**********************************************/

    //week 1 ex 2

    /**
     * Reverses the order of the elements of the given array.
     *
     * @param arr the array to reverse
     */
    public static void reverse(int[] arr) {
        if (arr == null)
            return;
        int right = arr.length - 1;
        for (int i = right; i > right / 2; i--) { //we need to stop in the middle so that we dont switch numbers twice.
            int left = (right) % i;
            int temp = arr[i];
            arr[i] = arr[left];
            arr[left] = temp;
        }
    }

    //week 1 ex 3

    /**
     * Merges two sorted arrays such that the resulting array has all elements
     * from both arrays and is also sorted. Assumes that the elements in the
     * given arrays are sorted in non-decreasing order. If there are duplicate
     * elements in the input arrays, these should also be present in the
     * resulting array. If both arrays are null the result should be null, or a
     * copy of the non-null array if only one is null.
     * <p>
     * Efficiency requirements: merge the two arrays in a single pass.
     *
     * @param arr1 first sorted array to be merged
     * @param arr2 second sorted array to be merged
     * @return sorted array containing all elements from both arrays
     */
    public static int[] merge(int[] arr1, int[] arr2) {

        if (arr1 == null && arr2 != null) {
            return (int[]) arr2.clone();  //THEY WANT A COPY!
        }

        if (arr1 != null && arr2 == null)
            return (int[]) arr1.clone();

        if (arr1 == null && arr2 == null) {
            return null;
        }

        int[] res = new int[arr1.length + arr2.length];


        int i = 0;
        int a1 = 0;
        int a2 = 0;

        while (i < res.length) {

            while (a2 < arr2.length && a1 < arr1.length && arr1[a1] < arr2[a2]) {
                res[i] = arr1[a1];
                a1++;
                i++;
            }

            while (a2 < arr2.length && a1 < arr1.length && arr1[a1] > arr2[a2]) {
                res[i] = arr2[a2];
                a2++;
                i++;
            }

            while (a2 < arr2.length && a1 < arr1.length && arr1[a1] == arr2[a2]) {
                res[i] = arr1[a1];
                a1++;
                i++;
                res[i] = arr2[a2];
                a2++;
                i++;
            }

            if (a2 >= arr2.length) {
                while (i < res.length && a1 < arr1.length) {
                    res[i] = arr1[a1];
                    i++;
                    a1++;
                }
            } else if (a1 >= arr1.length) {
                while (i < res.length && a2 < arr2.length) {
                    res[i] = arr2[a2];
                    i++;
                    a2++;
                }
            }


        }

        return res;
    }

    // week 1 ex 4

    /**
     * Calculates the number of occurrences of integers from the range
     * {0, ..., r} within a given array of integer elements. Returns
     * the array of counts: a new array of integers of size r + 1, where the
     * element at index i denotes the number occurrences of elements equal
     * to i in the given input array (with i in {0, ..., r}).
     * If the input array is null or of length 0, this will return null.
     *
     * @param arr the array of integer elements to be counted.
     * @param r   the integer indicating the last element of the range.
     * @return a new array containing the number of occurrences of each
     * integer {0, ..., r} in the input array (index i has the
     * count of elements equal to i in the input array, with i
     * in {0, ..., r})
     */
    public static int[] count(int[] arr, int r) {
        if (arr == null || arr.length == 0 || r < 0)
            return null;


        int[] res = new int[r + 1];

        for (int i = 0; i < arr.length; i++) {
            if (0 <= arr[i] && arr[i] <= r) {
                res[arr[i]]++;
            }
        }


        return res;
    }

    //week one ex 5

    static int multiply(int num1, int num2) {

        if (num2 == 0 || num1 == 0) {
            return 0;
        }

        if (num1 > 0 && num2 > 0) {
            return num1 + multiply(num1, num2 - 1);
        }

        if (num1 < 0 && num2 < 0) {
            return multiply(-num1, -num2);
        }

        if (num1 < 0 && num2 > 0) {
            return -multiply(-num1, num2);
        } else return -multiply(num1, -num2);
    }

    //week 2 ex 1

    /**
     * Takes the array and the last occurring element x,
     * shifting the rest of the elements left. I.e.
     * [1, 4, 7, 9], with x=7 would result in:
     * [1, 4, 9].
     *
     * @param x   the entry to remove from the array
     * @param arr to remove an entry from
     * @return the updated array, without the last occurrence of x
     */
    public static int[] removeLastOccurrence(int x, int[] arr) {

        int target = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                target = i;
            }
        }

        if (target == -1)
            return arr;
        int[] res = new int[arr.length - 1];

        int a = 0;
        for (int k = 0; k < res.length; k++) {

            if (k != target) {
                res[k] = arr[a];
            } else {
                a++;
                res[k] = arr[a];
            }
            a++;


        }

        return res;


    }

    //week 2 ex 2

    /**
     * Removes all elements from the ArrayList, using the removeLastOccurrence method.
     *
     * @param list to remove the elements from.
     */
    public static void removeAll(ArrayList<Integer> list) {

        if (list == null || list.size() == 0) {
            return;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            Solution.removeLastOccurrence(list.get(i), list);
        }
    }

    /**
     * Takes an ArrayList and removes last occurrence of x,
     * shifting the rest of the elements left.
     * I.e. [5, 1, 5, 9, 8], with x = 5
     * would result in: [5, 1, 9, 8].
     * Note that this method does not return a new list.
     * Instead, the list that is passed as a parameter is changed.
     *
     * @param list to remove an element from.
     * @param x    element value to look for
     */
    public static void removeLastOccurrence(int x, ArrayList<Integer> list) {
        if (list == null || x < 0) {
            return;
        }

        int target = -1;


        for (int i = 0; i < list.size(); i++) {
            if (x == list.get(i)) {
                target = i;
            }
        }

        if (target == -1) {
            return;
        } else list.remove(target);

    }

    //week 2 ex 3
    static double[][] clone(double[][] a) {
        if (a == null) {
            return null;
        }

        if (a.length == 0) {
            return new double[0][0];
        }

        double[][] b = new double[a.length][a[0].length];


        if (a.length != 0 && a[0].length != 0) {


            for (int col = 0; col < a.length; col++) {
                for (int row = 0; row < a[0].length; row++) {
                    b[col][row] = a[col][row];
                }
            }

        }
        return b;
    }


    //week one totrial ex 1

    /**
     * Returns the sum of all elements in the array up to (and including) the `n`th element
     *
     * @param arr the array of integers that needs to be summed
     * @param n   the index of the last item to consider
     */
    public static int sumElementsUpTo(int[] arr, int n) {

        if (n >= arr.length) {
            return 0;
        }

        int i = 0;
        int res = 0;
        while (i <= n) {
            res += arr[i];
            i++;
        }
        return res;
    }

    //week one totrial ex 2

    /**
     * Returns the sum of all elements in the array up to (and including) the `n`th element
     *
     * @param arr the array of integers that needs to be summed
     * @param n   the index of the last item to consider
     */
    public static int sumElementsUpTorec(int[] arr, int n) {

        if (n <= 0)
            return arr[0];

        return arr[n] + sumElementsUpTorec(arr, n - 1);

        //return sumRec(arr, n , 0);
    }

    public static int sumRec(int[] arr, int n, int i) {
        if (n <= i) {
            return arr[i];
        } else return arr[i] + sumRec(arr, n, i + 1);
    }

    //week one totrial ex 3

    /**
     * Computes the nth number in the Fibonacci sequence.    this is slow( O(2^n)        <<========
     *
     * @param n - the index of the number in the Fibonacci sequence.
     * @return nth number in the Fibonacci sequence
     */
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    //week one totrial ex 4

    /**
     * Computes the nth number in the Fibonacci sequence.
     *
     * @param n - the index of the number in the Fibonacci sequence.
     * @return nth number in the Fibonacci sequence
     */
    public static int fibonacciLinear(int n) {
        return fibonacci_helper(n, 0, 1);
    }

    /**
     * Helper function for computing the nth number in the Fibonacci sequence.
     *
     * @param n    - the index of the number in the Fibonacci sequence.
     * @param acc1 - accumulator for the previous number in the Fibonacci sequence.
     * @param acc2 -accumulator for the previous number in the Fibonacci sequence.
     * @return
     */
    public static int fibonacci_helper(int n, int acc1, int acc2) {
        if (n == 1)
            return acc2;

        return fibonacci_helper(n - 1, acc2, acc1 + acc2);

    }


    //lec 2
    public static int[] cumulativeSums(int[] a, int[] b, int i) {

        if (i >= a.length)
            return b;
        for (int j = 0; j <= i; j++) {
            b[i] += a[j];
        }
        return cumulativeSums(a, b, i + 1);
    }

    public static int[] cumulativeSums(int[] a) {
        int[] b = new int[a.length];
        return cumulativeSums(a, b, 0);
    }


}