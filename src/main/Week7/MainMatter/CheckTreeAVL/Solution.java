package main.Week7.MainMatter.CheckTreeAVL;


class Solution {

    /**
     * Computes whether the BinaryTree is an AVL tree.
     *
     * @param tree the BinaryTree to check.
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree) {
        return isTreeAVL(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private static boolean isTreeAVL(BinaryTree tree, int min, int max) {
        if (tree == null) return true;

        if (tree.getKey() <= min || tree.getKey() >= max) return false; //check BST
        if (Math.abs(height(tree.getLeft()) - height(tree.getRight())) > 1) { // check height balance
            return false;
        }
        return isTreeAVL(tree.getLeft(), min, tree.getKey()) && isTreeAVL(tree.getRight(), tree.getKey(), max);
    }


    private static int height(BinaryTree tree) {
        if (tree == null) return 0;
        int h = 1;
        if (tree.hasLeft()) {
            h = Math.max(h, 1 + height(tree.getLeft()));
        }
        if (tree.hasRight()) {
            h = Math.max(h, 1 + height(tree.getRight()));
        }
        return h;
    }
}
