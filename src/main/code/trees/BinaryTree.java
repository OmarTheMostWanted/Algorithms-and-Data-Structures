package main.code.trees;


/**
 * Properties:
 * - Each Internal Node has at most two children.
 * - The children of a node are an ordered pair: Left child -> Right child
 * <p>
 * Proper Binary Tree:
 * - Tree in which every node has either zero or two children.
 * <p>
 * In-Order traversal in binary trees (Depth-First): Nodes is visited AFTER left child and BEFORE right child*.
 * <p>
 * The Maximum number of nodes in a level: 2^(level)
 * <p>
 * The Height of a tree: The Maximum depth of all of it's nodes.
 * <p>
 * The Maximum number of nodes in a binary with height h: (2^(h+1) -1)
 *
 * @param <T>
 */
public interface BinaryTree<T> {

    boolean hasLeft(int key);

    boolean hasRight(int key);

    int size();

    int height();

    void add(int key, T t);

    T removeMin();

}
