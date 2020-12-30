package main.code.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TreeTest {

    /*
               0
              /   \
             1     2
            / \    /\
           3   4  5  6
     */
    private Tree<Integer> treeA;


    @BeforeEach
    void setUp() {
        Tree<Integer> tree0 = new Tree<Integer>(0, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree1 = new Tree<Integer>(1, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree2 = new Tree<Integer>(2, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree3 = new Tree<Integer>(3, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree4 = new Tree<Integer>(4, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree5 = new Tree<Integer>(5, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree6 = new Tree<Integer>(6, new ArrayList<Tree<Integer>>());

        tree0.children.add(tree1);
        tree0.children.add(tree2);
        tree1.children.add(tree3);
        tree1.children.add(tree4);
        tree2.children.add(tree5);
        tree2.children.add(tree6);

        treeA = tree0;
    }


    @Test
    void copy() {
        Tree<Integer> test = treeA.copy();
        assertEquals(treeA, test);
    }

    @Test
    void equals() {

        Tree<Integer> tree0 = new Tree<Integer>(0, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree1 = new Tree<Integer>(1, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree2 = new Tree<Integer>(2, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree3 = new Tree<Integer>(3, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree4 = new Tree<Integer>(4, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree5 = new Tree<Integer>(5, new ArrayList<Tree<Integer>>());
        Tree<Integer> tree6 = new Tree<Integer>(6, new ArrayList<Tree<Integer>>());

        tree0.children.add(tree1);
        tree0.children.add(tree2);
        tree1.children.add(tree3);
        tree1.children.add(tree4);
        tree2.children.add(tree5);
        tree2.children.add(tree6);

        assertEquals(tree0, treeA);

        tree6.value = 69;

        assertNotEquals(tree0, treeA);


    }

    @Test
    void preOrder() {
        ArrayList<Integer> test = new ArrayList<>();
        treeA.preOrder(test);
        ArrayList<Integer> res = new ArrayList<>();
        Collections.addAll(res, 0, 1, 3, 4, 2, 5, 6);
        assertEquals(res, test);
    }

    @Test
    void postOrder() {
        ArrayList<Integer> test = new ArrayList<>();
        treeA.postOrder(test);
        ArrayList<Integer> res = new ArrayList<>();
        Collections.addAll(res, 3, 4, 1, 5, 6, 2, 0);
        assertEquals(res, test);
    }

    @Test
    void breadthFirst() {
        ArrayList<Integer> test = new ArrayList<>();
        treeA.breadthFirst(test);
        ArrayList<Integer> res = new ArrayList<>();
        Collections.addAll(res, 0, 1, 2, 3, 4, 5, 6);
        assertEquals(res, test);
    }
}