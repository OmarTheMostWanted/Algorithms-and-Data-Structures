package main.Week3.MainMatter.BinaryTreeCompleteness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    public void testEmptyTree() {
        assertTrue(Solution.isTreeComplete(null));
    }

    @Test
    public void testOneLevel() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertTrue(Solution.isTreeComplete(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertTrue(Solution.isTreeComplete(tree));
    }

    @Test
    public void testOneRightChild() {
        BinaryTree tree = new BinaryTree(42, null, new BinaryTree(21));
        assertFalse(Solution.isTreeComplete(tree));
    }
}