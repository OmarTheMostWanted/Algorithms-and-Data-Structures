package main.Tutorials.W7S3.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

class AVLNode extends BSTNode {

    public AVLNode(int key, String value) {
        super(key, value);
    }

    public void recalculateHeight() {
        height = 1 + Math.max(leftChildHeight(), rightChildHeight());
    }

    private boolean hasLeft() {
        return getLeft() != null;
    }

    private boolean hasRight() {
        return getRight() != null;
    }

    public void rotateLeft() {

    }

    public void rotateRight() {
        // TODO
    }

    @Override
    public String get(int key) {
        // TODO
        return null;
    }

    @Override
    public String put(int key, String value) {
        // TODO
        return null;
    }
}

class AVLTree {

    private AVLNode root;

    /**
     * Simple constructor.
     */
    public AVLTree() {
        root = null;
    }

    /**
     * @return The root node of this AVLTree.
     */
    public AVLNode getRoot() {
        return root;
    }

    /**
     * @param key The key we need to find in the tree.
     * @return the value that key maps to (null if it didn't exist).
     */
    public String get(int key) {
        if (root == null) {
            return null;
        } else {
            return root.get(key);
        }
    }

    /**
     * @param key   The key we need to put or replace in the tree.
     * @param value The value that key needs to be mapped to.
     * @return the old value that key mapped to (null if it didn't exist).
     */
    public String put(int key, String value) {
        if (root == null) {
            root = new AVLNode(key, value);
            return null;
        } else {
            return root.put(key, value);
        }
    }

    /**
     * @param key The key we need to remove from the tree.
     * @return the value that key mapped to (null if it didn't exist).
     */
    public String remove(int key) {
        if (root == null) {
            return null;
        } else {
            return root.remove(key);
        }
    }

    /**
     * @return A string representation of this AVLTree.
     */
    public String toString() {
        Queue<AVLNode> q = new LinkedList<AVLNode>();
        q.offer(root);
        if (root == null) {
            return "";
        }
        String ret = "";
        while (q.peek() != null) {
            AVLNode node = q.poll();
            if (node.getLeft() != null) {
                q.offer((AVLNode) node.getLeft());
            }
            if (node.getRight() != null) {
                q.offer((AVLNode) node.getRight());
            }
            ret += node.getKey() + ",";
        }
        return ret;
    }
}
