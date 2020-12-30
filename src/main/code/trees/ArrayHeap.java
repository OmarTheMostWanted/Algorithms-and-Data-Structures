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
