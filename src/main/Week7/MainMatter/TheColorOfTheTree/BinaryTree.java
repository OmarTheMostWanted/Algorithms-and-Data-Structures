package main.Week7.MainMatter.TheColorOfTheTree;

class BinaryTree {

    private int value;

    private BinaryTree left, right;

    private boolean isRed;

    /**
     * Simple constructor.
     *
     * @param value Value for this tree set as value.
     * @param isRed True if this node is red, false otherwise.
     */
    public BinaryTree(int value, boolean isRed) {
        this.value = value;
        this.isRed = isRed;
    }

    /**
     * Extended constructor.
     *
     * @param value to set as value.
     * @param left  to set as left child.
     * @param right to set as right child.
     */
    public BinaryTree(int value, boolean isRed, BinaryTree left, BinaryTree right) {
        this(value, isRed);
        setLeft(left);
        setRight(right);
    }

    /**
     * @return the value of this tree.
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the new value of this tree.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the left child.
     */
    public BinaryTree getLeft() {
        return left;
    }

    /**
     * @param left Left subtree to set.
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * @return the right child.
     */
    public BinaryTree getRight() {
        return right;
    }

    /**
     * @param right Right subtree to set.
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }

    /**
     * @return true if this node is red, false otherwise.
     */
    public boolean isRed() {
        return isRed;
    }

    /**
     * @param red True if the new color is red, false otherwise.
     */
    public void setRed(boolean red) {
        isRed = red;
    }

    /**
     * @return true if this node is black, false otherwise.
     */
    public boolean isBlack() {
        return !isRed;
    }

    /**
     * @return True if the tree has a left child, false otherwise.
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * @return True if the tree has a right child, false otherwise.
     */
    public boolean hasRight() {
        return right != null;
    }
}
