package main.trees;

import java.util.Iterator;
import java.util.Queue;

/**
 * Interface for a tree where nodes can have an arbitrary number of children.
 **/
public interface Tree<E> extends Iterable<E> {
    Position<E> root();

    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    Iterable<Position<E>> children(Position<E> p)
            throws IllegalArgumentException;

    int numChildren(Position<E> p) throws IllegalArgumentException;

    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    Iterator<E> iterator();

    Iterable<Position<E>> positions();

    void visit(Position<E> p);

    default int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }

    int height(Position<E> p);

    /**
     * Node is visited before its children.
     **/
    void preorder(Position<E> p);

    /**
     * Node is visited after its children.
     **/
    void postorder(Position<E> p);


    /**
     * Visits nodes per level (depth).
     **/
    void breadthfirst(Position<E> p);
}