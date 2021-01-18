package main.code.trees;

import main.code.Book.Ch9PriorityQueues.DefaultComparator;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * Nodes are stored in an array.
 * <p>
 * Nodes v is stored at index f(v):
 * - f(v) = 0          > if v is the root
 * - f(v) = 2*f(p) + 1 > if v is the left child of p
 * - f(v) = 2*f(p) + 2 > if v is the right child of p
 * <p>
 * Space complexity: O(2^height) because there would be many empty positions in the array depending on the shape if the tree.
 * Many update operations require changing the entire array. Only efficient for particular shape of tree (Heaps)
 *
 * @param <T>
 */
public class ArrayTree<T> {

    int size;
    private ArrayList<Entry<T>> entries;

    //to compare elements T
    private Comparator<T> comparator;

    public ArrayTree() {
        entries = new ArrayList<>();
        size = 0;
        comparator = new DefaultComparator<T>();
    }

    public ArrayTree(Comparator<T> c){
        comparator = c;
        entries = new ArrayList<>();
        size = 0;
    }


    public boolean hasLeft(int key) {
        return size <= (2 * key + 1) && entries.get(2 * key + 1) != null;
    }

    public boolean hasRight(int key) {
        return size <= (2 * key + 2) && entries.get(2 * key + 2) != null;

    }

    public int size() {
        return size;
    }

    public int rightMostLeafNode() {
        return (int) Math.ceil((size - 1) / 2);
    }

    public int leftMostInternalNode() {
        return (int) (Math.ceil((size - 1) / 2) - 1);
    }

    public boolean isLeaf(int key) {
        return key >= rightMostLeafNode();
    }

    public boolean isInternal(int key) {
        return key <= leftMostInternalNode();
    }

    public int getLastPosition() {
        return size - 1;
    }

    public int height() {
        return (int) Math.ceil(Math.log(size + 1) / Math.log(2)) - 1;
    }

    /**
     * @param arr integer array to be checked (root at index 0)
     * @param n   the size of the array to be checked
     * @return true if the array satisfied the heap property, false otherwise
     */
    public static boolean isHeap(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (arr[getParent(arr, i)] > arr[i]) return false;
        }
        return true;
    }

    /**
     * @param arr array representation of a heap (you may assume it is a valid heap)
     * @param i   index of node whose parent we're looking for (make no assumptions about it's validity)
     * @return index of the parent of node i, or -1 if: (a) i is not a valid index, (b) i doesn't have a parent
     */
    public static int getParent(int[] arr, int i) {
        if (i >= arr.length || i <= 0) return -1;
        return (i - 1) / 2;
    }


    public void add(int key, T t) {
    }


    public T removeMin() {
        return null;
    }

    private class Entry<T> {

        int key;
        T t;

        public Entry(int k, T t) {
            key = k;
            this.t = t;
        }

        public Entry(int k) {
            key = k;
        }

    }


}
