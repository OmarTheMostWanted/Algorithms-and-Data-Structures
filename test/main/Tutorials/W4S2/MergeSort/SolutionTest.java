package main.Tutorials.W4S2.MergeSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    public void test_small() {
        int[] arr = new int[]{15, 10, 25, 20};
        int[] res = new int[]{10, 15, 20, 25};
        arr = Solution.mergeSort(arr);
        assertArrayEquals(res, arr);
    }

    @Test
    public void test_duplicate() {
        int[] arr = new int[]{30, 10, 30, 20};
        int[] res = new int[]{10, 20, 30, 30};
        arr = Solution.mergeSort(arr);
        assertArrayEquals(res, arr);
    }

    @Test
    public void test_negative() {
        int[] arr = new int[]{-1, -10, -12, -4, -3, -7};
        int[] res = new int[]{-12, -10, -7, -4, -3, -1};
        arr = Solution.mergeSort(arr);
        assertArrayEquals(res, arr);
    }

    @Test
    public void test_reversed() {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3};
        int[] res = new int[]{3, 4, 5, 6, 7, 8, 9};
        arr = Solution.mergeSort(arr);
        assertArrayEquals(res, arr);
    }
}