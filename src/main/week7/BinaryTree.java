package main.week7;

public class BinaryTree {

    private int key;

    private BinaryTree left, right;

    /**
     * Simple constructor.
     *
     * @param key to set as key.
     */
    public BinaryTree(int key) {
        this.key = key;
    }

    /**
     * Extended constructor.
     *
     * @param key   to set as key.
     * @param left  to set as left child.
     * @param right to set as right child.
     */
    public BinaryTree(int key, BinaryTree left, BinaryTree right) {
        this.key = key;
        setLeft(left);
        setRight(right);
    }

    /**
     * Computes whether the BinaryTree is a binary search tree.
     *
     * @param tree the BinaryTree to check.
     * @return true iff the BinaryTree is a binary search tree, else false.
     */
    public static boolean isTreeBST(BinaryTree tree) {
        if (tree == null) {
            return true;
        } else return isTreeBSTHelper(tree , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    public static boolean isTreeBSTHelper(BinaryTree tree , int min , int max) {

        /* an empty tree is BST */
        if (tree == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (tree.getKey() < min || tree.getKey() > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isTreeBSTHelper(tree.getLeft(), min, tree.getKey() - 1) &&
                isTreeBSTHelper(tree.getRight(), tree.getKey() + 1, max));

    }

    public int getKey() {
        return key;
    }

    /**
     * @return the left child.
     */
    public BinaryTree getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public BinaryTree getRight() {
        return right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    /**
     * @param left to set
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * @param right to set
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
