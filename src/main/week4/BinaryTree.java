package main.week4;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private int key;
    private BinaryTree left;
    private BinaryTree right;

    /**
     * Constructor with no children
     **/
    public BinaryTree(int key) {
        this.key = key;
    }

    /**
     * Constructor with two children
     **/
    public BinaryTree(int key, BinaryTree left, BinaryTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    /**
     * Returns the key of the root of this tree.
     **/
    public int getKey() {
        return this.key;
    }

    /**
     * Returns the left child of this tree iff hasLeft(v) is true, else null.
     **/
    public BinaryTree getLeft() {
        return this.left;
    }

    /**
     * Returns the right child of this tree iff hasRight(v) is true, else null.
     **/
    public BinaryTree getRight() {
        return this.right;
    }

    /**
     * Returns true iff this tree has a left child.
     */
    public boolean hasLeft() {
        return this.left != null;
    }

    /**
     * Returns true iff this tree has a right child.
     **/
    public boolean hasRight() {
        return this.right != null;
    }

    /**
     * Set the new left child of this tree.
     **/
    public void setLeft(BinaryTree child) {
        this.left = child;
    }

    /**
     * Set the new right child of this tree.
     **/
    public void setRight(BinaryTree child) {
        this.right = child;
    }

    /**
     * Computes whether the BinaryTree is complete.
     * The approach is to do a level order traversal starting from the root. In the traversal, once a node is found which is NOT a Full Node, all the following nodes must be leaf nodes.
     * Also, one more thing needs to be checked to handle the below case: If a node has an empty left child, then the right child must be empty.
     *
     * @param tree the BinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     */
    public static boolean isTreeComplete(BinaryTree tree) {
        if (tree == null) {
            return true;
        }

        boolean foundNotFullNode = false;


        if (tree.getLeft() != null) {
            if (tree.getRight() == null) {
                foundNotFullNode = true;
            }

            if (isLeafNode(tree.getLeft())) {
                return true;
            }
        } else if (tree.getRight() == null)
            return true;
        else return false;


        Queue<BinaryTree> q = new LinkedList<>();
        q.add(tree);


        while (!q.isEmpty()) {
            BinaryTree temp = q.remove();

            if (temp.getLeft() == null && temp.getRight() != null) {
                return false;
            }
            if (temp.getLeft() != null)
                q.add(temp.getLeft());
            if (temp.getRight() != null) {
                q.add(temp.getRight());
            }

            if (foundNotFullNode) {
                if (!isLeafNode(temp)) {
                    return false;
                }
            } else foundNotFullNode = !(isFullNode(temp));

        }

        return true;
    }

    public static boolean isFullNode(BinaryTree tree) {
        return tree.getLeft() != null && tree.getRight() != null;
    }

    public static boolean isLeafNode(BinaryTree tree) {
        return tree.getLeft() == null && tree.getRight() == null;
    }

}
