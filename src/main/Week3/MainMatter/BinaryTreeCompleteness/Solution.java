package main.Week3.MainMatter.BinaryTreeCompleteness;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    /**
     * Computes whether the BinaryTree is complete.
     *
     * @param tree the BinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     */
    public static boolean isTreeComplete(BinaryTree tree) {

        if (tree == null) return true;

        Queue<BinaryTree> q = new LinkedList<>();

        q.add(tree);

        boolean flag = false;

        while (!q.isEmpty()) {

            BinaryTree t = q.poll();

            if (t.hasLeft()) {

                if (flag) return false;

                q.add(t.getLeft());
                if (t.hasRight()) {
                    q.add(t.getRight());
                } else {
                    flag = true;
                }

            } else {
                flag = true;
                if (t.hasRight()) return false;
            }

        }

        return true;

    }
}
