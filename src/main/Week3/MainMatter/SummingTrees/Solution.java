package main.Week3.MainMatter.SummingTrees;


class Solution {

    /**
     * Sums the values of the nodes of two n-ary trees.
     *
     * @param t1 - first tree to sum values for
     * @param t2 - second tree to sum values for
     * @return a new tree in which every node contains the sum of the values of the nodes at the corresponding positions in t1 and t2
     */
    public static Tree sum(Tree t1, Tree t2) {

        Tree tree = new Tree(t1.getValue() + t2.getValue());
        for (int i = 0; i < t1.getChildren().size(); i++) {
            tree.getChildren().add(sum(t1.getChildren().get(i), t2.getChildren().get(i)));
        }
        return tree;

    }
}

