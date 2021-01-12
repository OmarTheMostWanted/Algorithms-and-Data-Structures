package main.Week3.MainMatter.LazyDepthFirsttIterator;

public interface Position<V> {
    /**
     * @return the key of this position.
     */
    public int getKey();

    /**
     * @return the value of the position.
     */
    public V getValue();

    public V getElement();
}