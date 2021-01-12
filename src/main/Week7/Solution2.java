package main.Week7;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * Return all elements in the given BST in descending order.
     * @param tree The BST to traverse.
     * @return A list of all elements in reverse order.
     */
    public static List<Integer> descendingOrder(BinaryTree tree) {
        return descendingOrder(tree, new ArrayList<>());
    }

    /**
     * Return all elements in the given BST in descending order.
     * @param tree The BST to traverse.
     * @param list The List to start with.
     * @return A list of all elements in reverse order.
     */
    public static List<Integer> descendingOrder(BinaryTree tree, List<Integer> list) {
        if (tree.hasRight()) descendingOrder(tree.getRight(), list);
        list.add(tree.getKey());
        if (tree.hasLeft()) descendingOrder(tree.getLeft(), list);
        return list;
    }

    /**
     * Library
     */
    class BinaryTree {

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
         * @param left to set
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
         * @param right to set
         */
        public void setRight(BinaryTree right) {
            this.right = right;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }
    }
}
