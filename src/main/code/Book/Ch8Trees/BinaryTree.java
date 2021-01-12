package main.code.Book.Ch8Trees;

import main.code.Book.Ch7PositionalList.Position;

/**
 * An interface for a binary tree, in which each node has at most two children
 *
 * @param <E> element
 */
public interface BinaryTree<E> extends Tree<E> {
    /**
     * Returns the Position of p's left child (or null if no child exists).
     *
     * @param p parent.
     * @return left child.
     * @throws IllegalArgumentException
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's right child (or null if no child exists).
     *
     * @param p parent.
     * @return right child.
     * @throws IllegalArgumentException
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's sibling (or null if no sibling exists)..
     *
     * @param p position.
     * @return sibling of p.
     * @throws IllegalArgumentException
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
