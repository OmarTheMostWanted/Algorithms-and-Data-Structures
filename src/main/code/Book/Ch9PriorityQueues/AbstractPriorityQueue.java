package main.code.Book.Ch9PriorityQueues;

import main.code.Book.Ch7PositionalList.PositionalList;

import java.util.Comparator;

/**
 * An abstract base class to assist implementations of the PriorityQueue interface.
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    /**
     * The comparator defining the ordering of keys in the priority queue.
     */
    private Comparator<K> comp;
    //----------- end of nested PQEntry class -----------

    // instance variable for an AbstractPriorityQueue

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<>());
    }

    /**
     * Method for comparing two entries according to key
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Determines whether a key is valid.
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0); // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    /**
     * Sorts sequence S, using initially empty priority queue P to produce the order.
     */
    public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E, ?> P) {
        int n = S.size();
        for (int j = 0; j < n; j++) {
            E element = S.remove(S.first());
            P.insert(element, null); // element is key; null value
        }
        for (int j = 0; j < n; j++) {
            E element = P.removeMin().getKey();
            S.addLast(element); // the smallest key in P is next placed in S
        }
    }

    /**
     * Tests whether the priority queue is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    //---------------- nested PQEntry class ----------------
    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K k; // key
        private V v; // value

        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }

        // methods of the Entry interface
        public K getKey() {
            return k;
        }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) {
            k = key;
        }

        public V getValue() {
            return v;
        }

        protected void setValue(V value) {
            v = value;
        }
    }
}