package main.Week7.Prerequisites.CheckHeightBalance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {


    @Test
    public void testEmptyTree() {
        assertTrue(Solution.isTreeBalanced(null));
    }

    @Test
    public void testOneLevel() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertTrue(Solution.isTreeBalanced(tree));
    }

    @Test
    public void testLinearTree() {
        assertFalse(Solution.isTreeBalanced(new BinaryTree(1, new BinaryTree(2, new BinaryTree(3), null), null)));
    }
}

