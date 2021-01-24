package main.Tutorials.W4S2.InplaceHeapSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static boolean isHeap(int[] arr, int i, int n) {
        return // If a leaf node
                i > (n - 2) / 2 || // If an internal node and is greater than its children
                        arr[i] >= arr[2 * i + 1] && (2 * i + 2 >= arr.length || arr[i] >= arr[2 * i + 2]) && // and same is recursively true for the children
                                isHeap(arr, 2 * i + 1, n) && isHeap(arr, 2 * i + 2, n);
    }

    @Test
    public void testHeapifySmall() {
        int[] data = {1, 2};
        Solution.heapify(data);
        System.out.println(Arrays.toString(data));
        assertTrue(isHeap(data, 0, data.length - 1));
        assertArrayEquals(new int[]{2, 1}, data);
    }

    @Test
    public void testHeapSortSmall() {
        int[] data = {42, 7, 12};
        int[] sorted = {7, 12, 42};
        Solution.inPlaceHeapSort(data);
        assertArrayEquals(sorted, data);
    }

    @Test
    public void test1() {
        int[] data = {9, 8, 7, 6, 5, 4, 3};
        int[] data2 = Arrays.copyOf(data, data.length);

        Arrays.sort(data2);

        Solution.inPlaceHeapSort(data);
        assertArrayEquals(data2, data);

    }
}