package main.code.Book.Ch9PriorityQueues;

import main.code.Book.Ch7PositionalList.LinkedPositionalList;
import main.code.Book.Ch7PositionalList.Position;
import main.code.Book.Ch7PositionalList.PositionalList;

import java.util.Comparator;

/**
 * An implementation of a priority queue with a sorted list.
 */
public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    /**
     * primary collection of priority queue entries
     */
    private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    public SortedPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     */
    public SortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Inserts a key-value pair and returns the entry created.
     */
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key); // auxiliary key-checking method (could throw exception)
        Entry<K, V> newest = new PQEntry<>(key, value);
        Position<Entry<K, V>> walk = list.last();
        // walk backward, looking for smaller key
        while (walk != null && compare(newest, walk.getElement()) < 0)
            walk = list.before(walk);
        if (walk == null)
            list.addFirst(newest); // new key is smallest
        else
            list.addAfter(walk, newest); // newest goes after walk
        return newest;
    }

    /**
     * Returns (but does not remove) an entry with minimal key.
     */
    public Entry<K, V> min() {
        if (list.isEmpty()) return null;
        return list.first().getElement();
    }

    /**
     * Removes and returns an entry with minimal key.
     */
    public Entry<K, V> removeMin() {
        if (list.isEmpty()) return null;
        return list.remove(list.first());
    }

    /**
     * Returns the number of items in the priority queue.
     */
    public int size() {
        return list.size();
    }
}

