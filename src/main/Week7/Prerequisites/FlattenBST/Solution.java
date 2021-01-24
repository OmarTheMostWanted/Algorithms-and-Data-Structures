package main.Week7.Prerequisites.FlattenBST;

import java.util.LinkedList;
import java.util.List;

class Solution {

    /**
     * Return all elements in the given BST in descending order.
     *
     * @param tree The BST to traverse.
     * @return A list of all elements in reverse order.
     */
    public static List<Integer> descendingOrder(BinaryTree tree) {
        if (tree == null) return null;
        List<Integer> res = new LinkedList<>();
        if (tree.hasRight()) {
            res.addAll(descendingOrder(tree.getRight()));
        }
        res.add(tree.getKey());
        if (tree.hasLeft()) {
            res.addAll(descendingOrder(tree.getLeft()));
        }
        return res;
    }
}
