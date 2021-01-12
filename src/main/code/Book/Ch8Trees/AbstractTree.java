package main.code.Book.Ch8Trees;

import main.code.Book.Ch7PositionalList.Position;

/**
 * An abstract base class providing some functionality of the Tree interface.
 */
public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of levels separating Position p from the root.
     * Time complexity O(depth-of-p + 1):
     * because the algorithm performs a constant-time recursive step for each ancestor of p.
     * Worst case when it's all of the positions ie O(n)
     */
    public int depth(Position<E> p) {
        if (isRoot(p)) return 0;
        else return 1 + depth(parent(p));

    }

    /**
     * Returns the height of the tree.
     */
    private int heightBad() { // works, but quadratic worst-case time O(n)
        int h = 0;
        for (Position<E> p : positions()) //positions() is O(n) and it's called for all leaf nodes ie O(n^2)
            if (isExternal(p)) // only consider leaf positions
                h = Math.max(h, depth(p));
        return h;
    }

    /**
     * Returns the height of the subtree rooted at Position p.
     * <p>
     * children(p) visits every node in subtree of p once: O(n)
     * height(c) called recursively, only once per node from top to bottom o(n)
     * <p>
     * so height(p) is o(n+n) ie o(n)
     * <p>
     * Worst case O(n).
     *
     * @param p subtree.
     * @return the height of the subtree p.
     */
    public int height(Position<E> p) {
        if (isRoot(p)) return 0;
        int h = 0; // base case if p is external
        for (Position<E> c : children(p)) { // children(p) is O(number of children of p + 1)
            return h = Math.max(h, 1 + height(c));
        }
        return h;
    }
}