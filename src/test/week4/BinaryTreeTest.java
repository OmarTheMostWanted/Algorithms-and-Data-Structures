package test.week4;


import main.week4.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {
    @Test
    public void testEmptyTree() {
        assertTrue(BinaryTree.isTreeComplete(null));
    }

    @Test
    public void testOneLevel() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertTrue(BinaryTree.isTreeComplete(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertTrue(BinaryTree.isTreeComplete(tree));
    }

    @Test
    public void testOneRightChild() {
        BinaryTree tree = new BinaryTree(42, null, new BinaryTree(21));
        assertFalse(BinaryTree.isTreeComplete(tree));
    }
}
