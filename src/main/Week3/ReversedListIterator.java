package main.Week3;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Iterates lazily over lists in reversed order. For instance, the list
 * [1,2,3,4] should be iterated as follows: 4 -> 3 -> 2 -> 1.
 */
class ReversedListIterator<V> implements Iterator<V> {


    private final List<V> list;
    private int index;

    /**
     * Constructor.
     * Should reset on a new List.
     *
     * @param list takes the list
     */
    public ReversedListIterator(List<V> list) {
        index = list.size() - 1;
        this.list = list;
    }

    /**
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    /**
     * Get the next element of the iterator and shift
     * iterator by one.
     *
     * @return current element value
     * @throws NoSuchElementException iff there is no next element
     * @post iterator is moved to next element
     */
    @Override
    public V next() throws NoSuchElementException {
        if (index < 0) throw new NoSuchElementException();
        return list.get(--index);
    }

    /**
     * Skip a single element of the iterator.
     *
     * @throws NoSuchElementException iff there is no elemented to be removed
     * @post iterator is moved to next element
     */
    @Override
    public void remove() throws NoSuchElementException {
        if (index < 0) throw new NoSuchElementException();
        index--;
    }
}

