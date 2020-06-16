package main.trees;

/**
 * Position ensures that nodes are not accessible from the outside.
 **/
interface Position<V> {
    /**
     * @return the key of this position.
     */
    public int getKey();

    /**
     * @return the value of the position.
     */
    public V getValue();
}
