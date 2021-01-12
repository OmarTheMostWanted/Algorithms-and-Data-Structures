package main.Week3.MainMatter.LazyDepthFirsttIterator;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeIteratorTest {

    @Test
    public void testOneLevel() {
        BTree<Integer> tree = new BinaryTree<>();
        tree.add(42, 42);
        tree.add(21, 21);
        tree.add(84, 84);
        Iterator<Integer> iterator = new BinaryTreeIterator<>(tree);
        assertTrue(iterator.hasNext());
        assertEquals(new Integer(42), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(new Integer(21), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(new Integer(84), iterator.next());
        assertFalse(iterator.hasNext());
    }

}