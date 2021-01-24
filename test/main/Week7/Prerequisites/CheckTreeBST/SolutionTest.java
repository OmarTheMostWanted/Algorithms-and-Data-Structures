package main.Week7.Prerequisites.CheckTreeBST;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    public void testOneLevelTrue() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), new BinaryTree(84));
        assertTrue(Solution.isTreeBST(tree));
    }

    @Test
    public void testOneLevelFalse() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertFalse(Solution.isTreeBST(tree));
    }

    @Test
    public void testOneLevelFalseDuplicate() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(42), new BinaryTree(21));
        assertFalse(Solution.isTreeBST(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertTrue(Solution.isTreeBST(tree));
        tree = new BinaryTree(42, new BinaryTree(84), null);
        assertFalse(Solution.isTreeBST(tree));
    }

}