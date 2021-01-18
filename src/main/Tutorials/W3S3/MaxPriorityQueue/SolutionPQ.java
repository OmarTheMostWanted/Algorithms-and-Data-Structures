package main.Tutorials.W3S3.MaxPriorityQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * In this exercise you are given the implementation of a heap-based priority queue that returns
 * the minimum element in the priority queue. Your task is to change this to a priority queue that
 * returns the maximum value first.
 */
public class SolutionPQ {

    private List<Integer> heap;

    public SolutionPQ() {
        heap = new ArrayList<>();
    }

    /**
     * Swaps two elements in the heap.
     *
     * @param i array index of one element to swap
     * @param j array index of the other element to swap
     */
    private void swap(int i, int j) {
        int t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }

    /**
     * Restores the heap order property top-down in a heap represented as an ArrayList.
     * When the heap property is invalid at node with index i,
     * the method fixes the heap first locally before fixing the affected subtree.
     *
     * @param i index of the node of the heap to start downHeap from
     *          range index of the last element in the heap, array indices > range are not part of the heap
     */
    private void downHeap(int i) {


        // indices of left and right children
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int biggest = i;
        if (left < heap.size() && heap.get(left) > heap.get(biggest))
            biggest = left;

        if (right < heap.size() && heap.get(right) > heap.get(biggest))
            biggest = right;

        // heap property invalid at root
        if (biggest != i) {
            swap(i, biggest);
            downHeap(biggest);
        }

//        // indices of left and right children
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//
//        int smallest = i;
//        if (left < heap.size() && heap.get(left) < heap.get(smallest))
//            smallest = left;
//
//        if (right < heap.size() && heap.get(right) < heap.get(smallest))
//            smallest = right;
//
//        // heap property invalid at root
//        if (smallest != i) {
//            swap(i, smallest);
//            downHeap(smallest);
//        }
    }

    /**
     * Restores the heap order property bottom-up in a heap represented as an ArrayList.
     * The method compares the node at index i to its parent, swaps if necessary,
     * and performs this same operation again and again while traversing up the heap
     * until the property is restored.
     *
     * @param i index of the node
     */
    private void upHeap(int i) {

        while (i >= 1) {
            int j = (i - 1) / 2;
            if (heap.get(j) >= heap.get(i))
                break;
            swap(j, i);
            i = j;
        }

//        while (i >= 1) {
//            int j = (i - 1) / 2;
//            if (heap.get(j) <= heap.get(i))
//                break;
//            swap(j, i);
//            i = j;
//        }
    }

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param elem the element to add
     */
    public void add(int elem) {
        heap.add(elem);
        upHeap(heap.size() - 1);
    }

    /**
     * Retrieves and removes the first element of this priority queue.
     *
     * @return the first element of the queue
     */
    public int poll() {
        int i = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return i;
    }

    /**
     * Returns the number of elements in the heap.
     *
     * @return the current number of elements in the heap
     */
    public int size() {
        return this.heap.size();
    }
}


