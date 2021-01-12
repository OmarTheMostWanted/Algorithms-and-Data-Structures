package main.code.Book.Ch8Trees;

import main.code.Book.Ch7PositionalList.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract base class providing some functionality of the BinaryTree interface.
 * <p>
 * Properties of Binary Trees:
 * - We denote the set of all nodes of a tree T at the same depth d as level d of T.
 * - Level d has at most 2^d nodes.
 * - In a nonempty proper binary tree T, with nE external nodes and nI internal nodes, we have nE = nI +1.
 *
 * @param <E> element.
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     */
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) return null; // p must be the root
        if (p == left(parent)) // p is a left child
            return right(parent); // (right child might be null)
        else // p is a right child
            return left(parent); // (left child might be null)
    }

    /**
     * Returns the number of children of Position p.
     */
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    /**
     * Returns an iterable collection of the Positions representing p's children.
     */
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

}
