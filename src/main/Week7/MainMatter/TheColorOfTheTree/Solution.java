package main.Week7.MainMatter.TheColorOfTheTree;

class Solution {

    /**
     * Checks whether the given BinaryTree is a Red Black Tree.
     *
     * @param tree BinaryTree to check.
     * @return True if the given tree is a Red Black Tree, false otherwise.
     */
    public static boolean isRedBlackTree(BinaryTree tree) {


        if (tree == null) return true;

        if (tree.isBlack()) { // check root is black

            /*
            true; //
            */

            boolean redPropertyLeft = redProperty(tree.getLeft());
            boolean redPropertyRight = redProperty(tree.getRight());

            int depth = findExternalNodeBlackDepthDepth(tree);
            boolean blackDepthBalance = checkBlackDepth(tree, 0, depth); //black depth is balanced

            boolean BTSTree = isTreeBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
            return redPropertyLeft && redPropertyRight && blackDepthBalance && BTSTree;
        } else return false;
    }

    private static boolean redProperty(BinaryTree tree) {

        if (tree == null) return true;
        if (tree.isRed()) {
            if (tree.hasLeft() && tree.getLeft().isRed()) return false;
            if (tree.hasRight() && tree.getRight().isRed()) return false;
        }
        return redProperty(tree.getLeft()) && redProperty(tree.getRight());
    }

    private static boolean checkBlackDepth(BinaryTree tree, int blackDepth, int externalNodeBlackDepth) {


        boolean leftBlackDepth = true;
        boolean rightBlackDepth = true;

        if (tree == null) {
            return blackDepth + 1 == externalNodeBlackDepth;
        }


        if (isExternal(tree)) return blackDepth == externalNodeBlackDepth;

        if (tree.isBlack()) {
            leftBlackDepth = checkBlackDepth(tree.getLeft(), blackDepth + 1, externalNodeBlackDepth);
            rightBlackDepth = checkBlackDepth(tree.getRight(), blackDepth + 1, externalNodeBlackDepth);

        } else {
            leftBlackDepth = checkBlackDepth(tree.getLeft(), blackDepth, externalNodeBlackDepth);
            rightBlackDepth = checkBlackDepth(tree.getRight(), blackDepth, externalNodeBlackDepth);
        }

        return leftBlackDepth && rightBlackDepth;

    }

    private static int findExternalNodeBlackDepthDepth(BinaryTree tree) {

        BinaryTree pointer = tree;
        int depth = 0;
        while (!isExternal(pointer)) {

            if (pointer.isBlack()) depth++;

            if (pointer.hasLeft()) pointer = pointer.getLeft();
            if (pointer.hasRight()) pointer = pointer.getRight();
        }

        return depth;
    }


    private static boolean isExternal(BinaryTree tree) {
        return tree.getLeft() == null && tree.getRight() == null;
    }

    private static boolean isTreeBST(BinaryTree tree, int min, int max) {
        if (tree == null) return true;
        if (tree.getValue() <= min || tree.getValue() >= max) return false;
        return isTreeBST(tree.getLeft(), min, tree.getValue()) && isTreeBST(tree.getRight(), tree.getValue(), max);
    }

}

