package main.Week7.Prerequisites.FlattenBST;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testOneLevel() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), new BinaryTree(84));
        assertEquals(Arrays.asList(84, 42, 21), Solution.descendingOrder(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertEquals(Arrays.asList(42, 21), Solution.descendingOrder(tree));
    }
}