package test.week7;

import main.week7.BinaryTree;
import org.junit.jupiter.api.Test;

import static main.week7.BinaryTree.isTreeBST;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    public void testOneLevelTrue() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), new BinaryTree(84));
        assertTrue(isTreeBST(tree));
    }

    @Test
    public void testOneLevelFalse() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertFalse(isTreeBST(tree));
    }

    @Test
    public void testOneLevelFalseDuplicate() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(42), new BinaryTree(21));
        assertFalse(isTreeBST(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertTrue(isTreeBST(tree));
        tree = new BinaryTree(42, new BinaryTree(84), null);
        assertFalse(isTreeBST(tree));
    }
}