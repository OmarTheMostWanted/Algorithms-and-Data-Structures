package main.Week7.Prerequisites.CheckTreeBST;

class Solution {

    /**
     * Computes whether the BinaryTree is a binary search tree.
     *
     * @param tree the BinaryTree to check.
     * @return true iff the BinaryTree is a binary search tree, else false.
     */
    public static boolean isTreeBST(BinaryTree tree) {
        if (tree == null) return true;
        return isTreeBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isTreeBST(BinaryTree tree, int min, int max) {
        if (tree == null) return true;
        if (tree.getKey() <= min || tree.getKey() >= max) return false;
        return isTreeBST(tree.getLeft(), min, tree.getKey()) && isTreeBST(tree.getRight(), tree.getKey(), max);
    }
}