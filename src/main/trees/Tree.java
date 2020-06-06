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

    default int height(Position<E> p) {
        int h = 0; // base case (p is leaf)
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }

    /**
     * Node is visited before its children.
     **/
    default void preorder(Position<E> p) {
        visit(p); // visit performs some operation at the node, e.g. print its element
        for (Position<E> c : children(p))
            preorder(c);
    }

    /**
     * Node is visited after its children.
     **/
    default void postorder(Position<E> p) {
        for (Position<E> c : children(p))
            postorder(c);
        visit(p);
    }


    /**Visits nodes per level (depth).**/
//    default void breadthfirst(Position<E> p) {
//        Queue<Position<E>> q = new Queue();
//        q.enqueue(p);
//        while (!q.isEmpty()) {
//            Position<E> p = q.dequeue();
//            visit(p);
//            for (Position<E> c : children(p))
//                q.enqueue(c);
//        }
//    }
}