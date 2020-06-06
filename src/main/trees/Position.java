package main.trees;

/**
 * Position ensures that nodes are not accessible from the outside.
 **/
public interface Position<E> {
    E getElement() throws IllegalStateException;
}
