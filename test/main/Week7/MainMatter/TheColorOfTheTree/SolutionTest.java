package main.Week7.MainMatter.TheColorOfTheTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    public void testExample() {
        BinaryTree tree = new BinaryTree(4, false);
        assertTrue(Solution.isRedBlackTree(tree));
        tree.setLeft(new BinaryTree(2, false));
        tree.setRight(new BinaryTree(6, false));
        assertTrue(Solution.isRedBlackTree(tree));
        tree.getLeft().setLeft(new BinaryTree(1, false));
        tree.setRight(null);
        assertFalse(Solution.isRedBlackTree(tree));
    }

    @Test
    public void test() {

        BinaryTree tree = new BinaryTree(7, false);
        BinaryTree tree4 = new BinaryTree(4, false);
        BinaryTree tree12 = new BinaryTree(12, false);
        BinaryTree tree15 = new BinaryTree(15, true);
        BinaryTree tree3 = new BinaryTree(3, true);
        BinaryTree tree5 = new BinaryTree(5, true);
        BinaryTree tree14 = new BinaryTree(14, true);
        BinaryTree tree18 = new BinaryTree(18, true);


        tree.setLeft(tree4);
        tree.setRight(tree12);
        tree12.setRight(tree15);

        assertTrue(Solution.isRedBlackTree(tree));

        tree4.setLeft(tree3);
        assertTrue(Solution.isRedBlackTree(tree));

        tree4.setRight(tree5);
        tree15.setLeft(tree14);
        assertFalse(Solution.isRedBlackTree(tree));

        tree.setRight(tree14);
        tree14.setRed(false);
        tree14.setLeft(tree12);
        tree14.setRight(tree15);
        tree12.setRed(true);
        tree12.setRight(null);
        tree15.setLeft(null);
        assertTrue(Solution.isRedBlackTree(tree));

        tree15.setRight(tree18);
        assertFalse(Solution.isRedBlackTree(tree));


        tree14.setRed(true);
        tree12.setRed(false);
        tree15.setRed(false);
        assertTrue(Solution.isRedBlackTree(tree));


    }

}