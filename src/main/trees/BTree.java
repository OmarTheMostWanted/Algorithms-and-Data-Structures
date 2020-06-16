package main.trees;


interface BTree<V> {
    /**
     * @return the root of the tree
     */
    public Position<V> getRoot();

    /**
     * Get the left child of a position.
     *
     * @param v
     *     the position to get the child of.
     * @return the child of the position iff hasLeft(v) is true.
     * @throws InvalidPositionException
     *     else
     */
    public Position<V> getLeft(Position<V> v) throws InvalidPositionException;

    /**
     * Get the right child of a position.
     *
     * @param v
     *     the position to get the child of.
     * @return the child of the position iff hasRight(v) is true.
     * @throws InvalidPositionException
     *     else
     */
    public Position<V> getRight(Position<V> v) throws InvalidPositionException;

    /**
     * Check if a position has a left child.
     *
     * @param v
     *     position to check.
     * @return true iff v has a left child.
     * @throws InvalidPositionException
     *     if v is not valid (e.g. null)
     */
    public boolean hasLeft(Position<V> v) throws InvalidPositionException;

    /**
     * Check if a position has a right child.
     *
     * @param v
     *     position to check.
     * @return true iff v has a right child.
     * @throws InvalidPositionException
     *     if v is not valid (e.g. null)
     */
    public boolean hasRight(Position<V> v) throws InvalidPositionException;

    /**
     * Adds a new entry to the tree.
     *
     * @param key
     *     to use.
     * @param value
     *     to add.
     */
    public void add(int key, V value);
}