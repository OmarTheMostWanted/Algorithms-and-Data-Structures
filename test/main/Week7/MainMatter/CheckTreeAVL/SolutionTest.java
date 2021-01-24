package main.Week7.MainMatter.CheckTreeAVL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    public void testJustRoot() {
        BinaryTree tree = new BinaryTree(42);
        assertTrue(Solution.isTreeAVL(tree));
    }

    @Test
    public void testOneLevelTrue() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), new BinaryTree(84));
        assertTrue(Solution.isTreeAVL(tree));
    }

    @Test
    public void testOneLevelFalse() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertFalse(Solution.isTreeAVL(tree));
    }

    @Test
    public void testOneLevelFalseDuplicate() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(42), new BinaryTree(21));
        assertFalse(Solution.isTreeAVL(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertTrue(Solution.isTreeAVL(tree));
        tree = new BinaryTree(42, new BinaryTree(84), null);
        assertFalse(Solution.isTreeAVL(tree));
    }

    /*
           42
          /
         36
        /  \
       21  39
     */
    @Test
    public void testTwoLevelsSkew2() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(36, new BinaryTree(21), new BinaryTree(39)), null);
        assertFalse(Solution.isTreeAVL(tree));
    }
}