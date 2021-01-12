package main.code.trees;


/**
 * Each Node of the tree Contains a reference to it's Parent and sequence of children nodes.
 * <p>
 * Space Complexity: O(n) where n is the size of the tree
 * Time complexity for insertion/removal: O(1)
 *
 * @param <T>
 */
public class LinkedTree<T> {

    private Node<T> root;
    private int size;

    public LinkedTree() {
        size = 0;
    }


    public int size() {
        return size;
    }


    //take log2(n) rightmost bits
    public int getPathToLastNode() {
        return (int) (size - Math.pow(2, Math.ceil(Math.log(size) / Math.log(2))));
    }

    //take log2(n+1) rightmost bits
    public int getPathToNewNode() {
        return (int) (size + 1 - Math.pow(2, Math.ceil(Math.log(size + 1) / Math.log(2))));
    }


    public int numberOfNodesInLastLevel() {
        return (int) (size - Math.pow(2, Math.floor(Math.log(size) / Math.log(2))) + 1);
    }

    public int height() {
        return (int) Math.ceil(Math.log(size + 1) / Math.log(2)) - 1;
    }

    public void add(int key, T t) {
    }


    public T removeMin() {
        return null;
    }


    private class Node<T> {

        private int key;
        private T value;

        private Node<T> parent, left, right;

        public Node(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, T value, Node<T> parent, Node<T> left, Node<T> right) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

}
