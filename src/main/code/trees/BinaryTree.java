package main.code.trees;

public interface BinaryTree<T> {

    boolean hasLeft(int key);

    boolean hasRight(int key);

    int size();

    int height();

    void add(int key, T t);

    T removeMin();

}
