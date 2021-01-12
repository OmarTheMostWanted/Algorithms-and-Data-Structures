package main.Week7;

public class Solution3 {
    /**
     * Computes whether the BinaryTree is an AVL tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree) {
        return isTreeAVL(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Computes the height of the BinaryTree.
     * @param tree
     *     the BinaryTree to calculate the height for.
     * @return the height of the tree.
     */
    public static int getHeight(BinaryTree tree) {
        if (tree == null) return 0;
        return 1 + Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight()));
    }

    /**
     * Computes whether the BinaryTree is an AVL tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @param min
     *     the minimum value the root key needs to have
     * @param max
     *     the maximum value the root key needs to have
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree, int min, int max) {
        if (tree.getKey() < min || tree.getKey() > max) return false;
        if (tree.hasLeft() && !isTreeAVL(tree.getLeft(), min, tree.getKey() - 1)) return false;
        if (tree.hasRight() && !isTreeAVL(tree.getRight(), tree.getKey() + 1, max)) return false;
        if (Math.abs(getHeight(tree.getLeft()) - getHeight(tree.getRight())) > 1) return false;
        return true;
    }

    private /**
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
