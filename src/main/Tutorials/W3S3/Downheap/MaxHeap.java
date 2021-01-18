package main.Tutorials.W3S3.Downheap;

public class MaxHeap extends LibraryMaxHeap {

    public MaxHeap(int[] arr) {
        super(arr);
    }

    public boolean hasLeft(int index, int range) {
        return index * 2 + 1 <= range;
    }

    public int getLeft(int index) {
        return heap[index * 2 + 1];
    }

    public boolean hasRight(int index, int range) {
        return index * 2 + 2 <= range;
    }

    public int getRight(int index) {
        return heap[index * 2 + 2];
    }

    /**
     * Restores the heap property in a heap represented as an array.
     * When the heap property is invalid at root,
     * the method fixes the heap first locally before fixing the affected subtree.
     *
     * @param root  Index of the root of the heap, which might be a subtree of the overall heap.
     * @param range Index of the last element in the heap, array elements with an index > range are not part of the heap.
     */
    @Override
    public void downHeap(int root, int range) {

        if (root == range) return;
        int p = root;
        while (p <= range) {
            if (!hasLeft(p, range)) break;
            int indexOfBiggestChiled = 2 * p + 1;
            if (hasRight(p, range)) {
                if (getRight(p) > getLeft(p)) indexOfBiggestChiled = 2 * p + 2;
            }
            if (heap[indexOfBiggestChiled] > heap[p]) swap(heap, indexOfBiggestChiled, p);
            else break;
            p = indexOfBiggestChiled;
        }
    }
}