package main.Week3.MainMatter.TheMiddleoftheHeap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    Heap test;

    @BeforeEach
    public void init() {


    }

    @Test
    public void testNull() {
        assertNull(Solution.findMiddleInLastLayer(null));
    }

    @Test
    public void testTwoPositions() {
        Heap heap = new Heap(42);
        heap.setLeft(heap.getRoot(), 84);
        assertEquals(84, Solution.findMiddleInLastLayer(heap).getKey());
    }

    @Test
    public void testThreePositions() {
        Heap heap = new Heap(42);
        heap.setLeft(heap.getRoot(), 84);
        heap.setRight(heap.getRoot(), 99);
        assertEquals(84, Solution.findMiddleInLastLayer(heap).getKey());
    }

    @Test
    public void testTreeH13() {

        test = new Heap(0);


        test.setLeft(test.getRoot(), 1);
        test.setRight(test.getRoot(), 2);

        test.setLeft(test.getLeft(test.getRoot()), 3);
        test.setRight(test.getLeft(test.getRoot()), 4);

        test.setLeft(test.getRight(test.getRoot()), 5);
        test.setRight(test.getRight(test.getRoot()), 6);

        test.setLeft(test.getLeft(test.getLeft(test.getRoot())), 7);
        test.setRight(test.getLeft(test.getLeft(test.getRoot())), 8);

        test.setLeft(test.getRight(test.getLeft(test.getRoot())), 9);
        test.setRight(test.getRight(test.getLeft(test.getRoot())), 10);

        test.setLeft(test.getLeft(test.getRight(test.getRoot())), 11);
        test.setRight(test.getLeft(test.getRight(test.getRoot())), 12);

        assertEquals("101", Solution.getPathToLastNode(test.size()));

        assertEquals(9, Solution.findMiddleInLastLayer(test).getKey());

    }

    @Test
    public void testTreeH12() {

        test = new Heap(0);


        test.setLeft(test.getRoot(), 1);
        test.setRight(test.getRoot(), 2);

        test.setLeft(test.getLeft(test.getRoot()), 3);
        test.setRight(test.getLeft(test.getRoot()), 4);

        test.setLeft(test.getRight(test.getRoot()), 5);
        test.setRight(test.getRight(test.getRoot()), 6);

        test.setLeft(test.getLeft(test.getLeft(test.getRoot())), 7);
        test.setRight(test.getLeft(test.getLeft(test.getRoot())), 8);

        test.setLeft(test.getRight(test.getLeft(test.getRoot())), 9);
        test.setRight(test.getRight(test.getLeft(test.getRoot())), 10);

        test.setLeft(test.getLeft(test.getRight(test.getRoot())), 11);

        assertEquals("001", Solution.getPathToLastNode(test.size()));

        assertEquals(9, Solution.findMiddleInLastLayer(test).getKey());

    }

    @Test
    public void testTreeH4() {

        test = new Heap(0);


        test.setLeft(test.getRoot(), 1);
        test.setRight(test.getRoot(), 2);

        test.setLeft(test.getLeft(test.getRoot()), 3);


//        assertEquals("00" , Solution.getPathToLastNode(test.size()));

        assertEquals(3, Solution.findMiddleInLastLayer(test).getKey());

    }


}