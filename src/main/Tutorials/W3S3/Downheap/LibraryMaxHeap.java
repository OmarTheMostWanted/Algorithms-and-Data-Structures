package main.Tutorials.W3S3.Downheap;

public abstract class LibraryMaxHeap {

    public int[] heap;

    public LibraryMaxHeap(int[] arr) {
        heap = arr;
    }

    /**
     * Swaps two elements in an array.
     *
     * @param a The array to swap elements in.
     * @param i Position of element to swap in a.
     * @param j Position of element to swap in a.
     */
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Turns an array of integers into a heap.
     * This is an in-place algorithm, the heap is built in the array itself.
     */
    public void heapify() {
        int n = heap.length - 1;
        for (int root = n / 2; root >= 0; root--) downHeap(root, n);
    }

    /**
     * Restores the heap property in a heap represented as an array.
     * When the heap property is invalid at root,
     * the method fixes the heap first locally before fixing the affected subtree.
     *
     * @param root  Index of the root of the heap, which might be a subtree of the overall heap.
     * @param range Index of the last element in the heap, array elements with an index > range are not part of the heap.
     */
    public abstract void downHeap(int root, int range);
}

