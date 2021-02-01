package main.Exam.Ex3;

import java.util.LinkedList;

class Solution {

    /**
     * See the description of the exercise.
     */
    public static MWSTNode getCousin(MultiWaySearchTree tree, MWSTNode node) {

        if (node == null || tree == null) return null;

        /* Go up two level to get grand parent */
        MWSTNode parent = node.getParent();
        if (parent == null) return null;

        MWSTNode grandParent = parent.getParent();
        if (grandParent == null) return null;

        /* Now Go back two level deep though the farthest right path */

        //Get last element (farthest right uncle)
        LinkedList<MWSTNode> uncles = grandParent.getChildren();
        int numUncles = uncles.size();

        //Traverse uncles from right to left until you find the farthest cousin
        while (numUncles > 0) {
            MWSTNode rightUncle = uncles.get(numUncles - 1);

            //Ensure the last element isn't null and not the parent
            if (rightUncle == null || rightUncle.equals(parent)) {
                numUncles--;
                continue;
            }

            //Get farthest cousin
            LinkedList<MWSTNode> cousins = rightUncle.getChildren();
            int numCousins = cousins.size();
            MWSTNode rightCousin = null;

            //Ensure that this uncle does have a children
            while (numCousins > 0 && rightCousin == null) {
                rightCousin = cousins.get(numCousins - 1);
                numCousins--;
            }

            //Go back to next uncle (from right to left) if no cousins found
            if (rightCousin == null) {
                numUncles--;
                continue;
            }

            return rightCousin;
        }

        return null;
    }

    /**
     * See the description of the exercise.
     */
    public static MWSTNode getUncle(MultiWaySearchTree tree, MWSTNode node) {
        if (node == null || tree == null) return null;

        /* Go up two level to get grand parent */
        MWSTNode parent = node.getParent();
        if (parent == null) return null;

        MWSTNode grandParent = parent.getParent();
        if (grandParent == null) return null;

        /* Now go down one level deep though the farthest left path */

        //Get first element (farthest left uncle)
        LinkedList<MWSTNode> uncles = grandParent.getChildren();
        int indexUncle = 0;

        //Traverse uncles from left to right to skip null values
        while (indexUncle < uncles.size()) {
            MWSTNode leftUncle = uncles.get(indexUncle);

            //Skip this if null or the parent
            if (leftUncle == null || leftUncle.equals(parent)) {
                indexUncle++;
                continue;
            }

            return leftUncle;
        }

        return null;
    }


    /**
     * See the description of the exercise.
     */
    public static boolean restrictedSearch(MultiWaySearchTree tree, int key) {

        if (tree == null) return false;

        MWSTNode root = tree.getRoot();
        if (root == null) return false;

        if (root.getKeys().size() < 0)
            return false;

//        for(int i = root.getKeys().size(); i >= 0; i--) {
//
//        }

        return false;
    }
}

