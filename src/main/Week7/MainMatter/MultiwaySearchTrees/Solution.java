package main.Week7.MainMatter.MultiwaySearchTrees;

import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * Checks whether the given MultiwaySearchTree satisfies all to conditions.
     * Our reference solution does not change this function in any way.
     *
     * @param tree MultiwaySearchTree to check.
     * @return True iff the given tree satisfies all conditions.
     */
    public static boolean isSpecialTree(MultiwaySearchTree tree) {
        boolean cond1 = satisfiesCondition1(tree);
        boolean cond2 = satisfiesCondition2(tree);
        boolean cond3 = satisfiesCondition3(tree);
        boolean cond4 = satisfiesCondition4(tree);

        return cond1 && cond2 && cond3 && cond4;
    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should not change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition1(MultiwaySearchTree tree) {

        if (tree == null) return true;


        if (tree.children.length > 7) return false;
        boolean res = true;
        for (MultiwaySearchTree child : tree.getChildren()) {
            res &= satisfiesCondition1(child);
        }
        return res;
    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should not change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition2(MultiwaySearchTree tree) {

        boolean res = true;

        for (MultiwaySearchTree child : tree.children) {
            res &= cond2(child);

            if (!res) return false;
        }

        return res;

    }

    private static boolean cond2(MultiwaySearchTree tree) {

        if (tree == null) return true;

        if (tree.getChildren().length == 0) return true;

        if (tree.children.length < 4) return false;
        boolean res = true;
        for (MultiwaySearchTree child : tree.getChildren()) {
            if (!cond2(child)) return false;
        }
        return res;
    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should not change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition3(MultiwaySearchTree tree) {

        if (tree == null) return true;

        if (tree.children.length != 0) {
            return tree.children.length >= 2;
        } else return true;
    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should not change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition4(MultiwaySearchTree tree) {

        if (tree == null) return true;


        Set<Integer> keySet = new HashSet<>();
        return cond4(tree, keySet);
    }

    private static boolean cond4(MultiwaySearchTree tree, Set<Integer> set) {

        if (tree == null) return true;


        for (int key : tree.getKeys()) {
            if (!set.contains(key)) set.add(key);
            else return false;
        }
        boolean res = true;
        for (MultiwaySearchTree child : tree.getChildren()) {
            res = cond4(child, set);
            if (!res) return false;
        }
        return res;
    }

}