package main.Week3.MainMatter.BinaryTreeCompleteness;

public class BinaryTree {

    private int key;
    private BinaryTree left;
    private BinaryTree right;

    // Constructor with no children
    BinaryTree(int key) {
        this.key = key;
    }

    // Constructor with two children
    BinaryTree(int key, BinaryTree left, BinaryTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    // Returns the key of the root of this tree.
    int getKey() {
        return this.key;
    }

    // Returns the left child of this tree iff hasLeft(v) is true, else null.
    BinaryTree getLeft() {
        return this.left;
    }

    // Set the new left child of this tree.
    void setLeft(BinaryTree child) {
        this.left = child;
    }

    // Returns the right child of this tree iff hasRight(v) is true, else null.
    BinaryTree getRight() {
        return this.right;
    }

    // Set the new right child of this tree.
    void setRight(BinaryTree child) {
        this.right = child;
    }

    // Returns true iff this tree has a left child.
    boolean hasLeft() {
        return this.left != null;
    }

    // Returns true iff this tree has a right child.
    boolean hasRight() {
        return this.right != null;
    }
}
