package main.Tutorials.W3S3.Downheap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MaxHeapTest {

    private static boolean isHeap(int[] arr, int i, int n) {
        return // If a leaf node
                i > (n - 2) / 2 || // If an internal node and is greater than its children
                        arr[i] >= arr[2 * i + 1] && (2 * i + 2 >= arr.length || arr[i] >= arr[2 * i + 2]) && // and same is recursively true for the children
                                isHeap(arr, 2 * i + 1, n) && isHeap(arr, 2 * i + 2, n);
    }

    @Test
    public void testHeapifySmall() {
        int[] data = {1, 2};
        MaxHeap heap = new MaxHeap(data);
        heap.heapify();
        assertTrue(isHeap(heap.heap, 0, data.length - 1));
        assertArrayEquals(new int[]{2, 1}, heap.heap);
    }
}