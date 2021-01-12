package main.Week3.MainMatter.LazyDepthFirsttIterator;

public class BTNode<V> implements Position<V> {
    private int key;
    private V value;
    private Position<V> parent, left, right;

    /**
     * Simple constructor.
     *
     * @param key   to set as key.
     * @param value to set as value.
     */
    public BTNode(int key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    /**
     * @param value to set.
     */
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public V getElement() {
        return null;
    }

    /**
     * @return the parent.
     */
    public Position<V> getParent() {
        return parent;
    }

    /**
     * @param parent to set
     */
    public void setParent(Position<V> parent) {
        this.parent = parent;
    }

    /**
     * @return the left child.
     */
    public Position<V> getLeft() {
        return left;
    }

    /**
     * @param left to set
     */
    public void setLeft(Position<V> left) {
        this.left = left;
    }

    /**
     * @return the right child.
     */
    public Position<V> getRight() {
        return right;
    }

    /**
     * @param right to set
     */
    public void setRight(Position<V> right) {
        this.right = right;
    }
}