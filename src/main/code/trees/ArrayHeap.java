package main.code.trees;

import java.util.ArrayList;

public class ArrayHeap<T> {

    int size;
    private ArrayList<Entry<T>> entries;

    public ArrayHeap() {
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
