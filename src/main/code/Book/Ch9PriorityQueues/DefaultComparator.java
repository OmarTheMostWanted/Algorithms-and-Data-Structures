package main.code.Book.Ch9PriorityQueues;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}