package main.Tutorials.W8S3.PrimJarnikAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class AdaptablePQ {

    private ArrayList<PQEntry> heap = new ArrayList<>();
    private Map<Vertex, PQEntry> entries = new HashMap<>();

    private int parent(int j) {
        return (j - 1) / 2;
    }

    private int left(int j) {
        return 2 * j + 1;
    }

    private int right(int j) {
        return 2 * j + 2;
    }

    private boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    private boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     *
     * @param i First index to swap.
     * @param j Second index to swap.
     */
    private void swap(int i, int j) {
        PQEntry temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
        heap.get(i).setIndex(i);
        heap.get(j).setIndex(j);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap property.
     *
     * @param j Index to start from.
     */
    private void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (heap.get(j).compareTo(heap.get(p)) >= 0)
                break;
            swap(j, p);
            j = p;
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap property.
     *
     * @param j Index to start from.
     */
    private void downheap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (heap.get(leftIndex).compareTo(heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;
            }
            if (heap.get(smallChildIndex).compareTo(heap.get(j)) >= 0)
                break;
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    /**
     * Restores the heap property by moving the entry at index j upward/downward.
     *
     * @param j Index to start restoring the heap from.
     */
    private void bubble(int j) {
        if (j > 0 && heap.get(j).compareTo(heap.get(parent(j))) < 0)
            upheap(j);
        else
            downheap(j);
    }

    /**
     * Adds a new vertex to the PriorityQueue with the given key.
     *
     * @param vertex Vertex to add to the queue.
     * @param key    Key for the vertex in the queue.
     */
    private void insert(Vertex vertex, int key) {
        PQEntry newest = new PQEntry(key, vertex, heap.size());
        heap.add(newest);
        upheap(heap.size() - 1);
        entries.put(vertex, newest);
    }

    /**
     * Returns the number of items in the priority queue.
     *
     * @return number of items.
     */
    public int size() {
        return heap.size();
    }

    // ------- PUBLIC METHODS -----------------------------------------------------

    /**
     * Replaces the key of a given vertex and reorders it in the PriorityQueue.
     * If the key was not in the PriorityQueue yet, it is added.
     *
     * @param vertex Vertex to change the key from.
     * @param key    New key for the given vertex.
     */
    public void insertOrReplace(Vertex vertex, int key) {
        if (!entries.containsKey(vertex)) {
            this.insert(vertex, key);
        } else {
            PQEntry entry = entries.get(vertex);
            entry.setKey(key);
            bubble(entry.getIndex());
        }
    }

    /**
     * Removes and returns an entry with minimal key.
     *
     * @return the removed entry's Vertex and its key (or null if the PQ is empty).
     */
    public VertexNumPair removeMin() {
        if (isEmpty())
            return null;
        PQEntry entry = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        entries.remove(entry.getValue());
        return new VertexNumPair(entry.getValue(), entry.getKey());
    }

    /**
     * Returns whether the PriorityQueue is empty or not.
     *
     * @return True when the PQ is empty, false otherwise.
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private static class PQEntry implements Comparable<PQEntry> {

        private int key;

        private Vertex value;

        private int index;

        public PQEntry(int key, Vertex value, int index) {
            this.key = key;
            this.value = value;
            this.index = index;
        }

        protected int getKey() {
            return key;
        }

        protected void setKey(int key) {
            this.key = key;
        }

        protected Vertex getValue() {
            return value;
        }

        protected int getIndex() {
            return index;
        }

        protected void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(PQEntry o) {
            return Integer.compare(this.getKey(), o.getKey());
        }
    }
}
