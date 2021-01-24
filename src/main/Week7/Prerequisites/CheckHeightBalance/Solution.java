package main.Week7.Prerequisites.CheckHeightBalance;

class Solution {
    /**
     * This method checks whether the given tree has the height-balance property.
     *
     * @param tree the tree to check.
     * @return true iff the tree has the height-balance property, false otherwise.
     */
    public static boolean isTreeBalanced(BinaryTree tree) {
        if (tree == null) return true;
        if (Math.abs(height(tree.getLeft()) - height(tree.getRight())) > 1) {
            return false;
        }
        return isTreeBalanced(tree.getLeft()) && isTreeBalanced(tree.getRight());
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