package test;

import main.DLList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class DLListTest {

    private DLList dlList;

    @BeforeEach
    void setUp() {
        dlList = new DLList();
    }

    @AfterEach
    void tearDown() {
        dlList = null;
    }

    @Test
    void getHead() {
        dlList.addFirst(1);
        Assertions.assertEquals(1, dlList.getHead());
    }

    @Test
    void getTail() {
        dlList.addFirst(1);
        dlList.addLast(2);
        Assertions.assertEquals(1, dlList.getHead());
        Assertions.assertEquals(2, dlList.getTail());
    }

    @Test
    void addFirst() {
        dlList.addFirst(0);
        Assertions.assertEquals(0, dlList.getHead());
        Assertions.assertEquals(0, dlList.getTail());
        dlList.addFirst(1);
        Assertions.assertEquals(1, dlList.getHead());
        Assertions.assertEquals(0, dlList.getTail());

    }

    @Test
    void removeFirst() {
        dlList.addFirst(0);
        int removed = (int) dlList.removeFirst();
        Assertions.assertNull(dlList.getHead());
        Assertions.assertEquals(0, removed);

        dlList.addFirst(10);
        dlList.addLast(11);

        Assertions.assertEquals(10, dlList.getHead());

    }

    @Test
    void addLast() {
        dlList.addLast(0);
        Assertions.assertEquals(0, dlList.getHead());
        Assertions.assertEquals(0, dlList.getTail());
        dlList.addLast(1);
        Assertions.assertEquals(0, dlList.getHead());
        Assertions.assertEquals(1, dlList.getTail());
        dlList.addFirst(2);
        Assertions.assertEquals(2, dlList.getHead());
        Assertions.assertEquals(1, dlList.getTail());

        dlList.addLast(10);
        Assertions.assertEquals(10 , dlList.getTail());
    }

    @Test
    void removeLast() {
        dlList.addLast(0);
        int removed = (int) dlList.removeLast();
        Assertions.assertNull(dlList.getHead());
        Assertions.assertEquals(0, removed);

        dlList.addFirst(10);
        dlList.addLast(11);

        Assertions.assertEquals(11, dlList.getTail());
        Assertions.assertEquals(11 , dlList.removeLast());
        Assertions.assertEquals(10 , dlList.removeFirst());
        Assertions.assertNull(dlList.removeLast());
    }

    @Test
    void size() {
        Assertions.assertEquals(0 , dlList.size());
        dlList.addFirst(0);
        Assertions.assertEquals(1 , dlList.size());
        dlList.addLast(1);
        Assertions.assertEquals(2 , dlList.size());

        dlList.addAtPosition(1 , 11);
        Assertions.assertEquals(3 , dlList.size());
    }

    @Test
    void addAtPosition() {
        dlList.addAtPosition(0 , 0);
        dlList.addAtPosition(1 ,1);
        dlList.addAtPosition(2 , 2);
        dlList.addLast(3);

        Assertions.assertEquals(0 , dlList.getHead());
        Assertions.assertEquals(3 , dlList.getTail());

        Assertions.assertEquals(4 , dlList.size());

        Assertions.assertEquals(0 , dlList.removeFirst());
        Assertions.assertEquals(1 , dlList.getHead());
        dlList.removeLast();
        Assertions.assertEquals(2, dlList.removeLast());

    }

    @Test
    void removeFromPosition() {
        Assertions.assertNull(dlList.removeFromPosition(1));
        Assertions.assertNull(dlList.removeFromPosition(0));
        dlList.addFirst(3);
        dlList.addFirst(2);
        dlList.addFirst(1);
        dlList.addFirst(0);
        Assertions.assertEquals(0 , dlList.removeFromPosition(0));
        Assertions.assertEquals(3 , dlList.removeFromPosition(2));
        Assertions.assertEquals(1 , dlList.getHead());

    }

    @Test
    void reverse() {
        dlList.addAtPosition(0 , 0);
        dlList.addAtPosition(1 ,1);
        dlList.addAtPosition(2 ,2);


        DLList reversed = dlList.reverse();

        Assertions.assertEquals(0 , reversed.getTail());
        Assertions.assertEquals(2 , reversed.getHead());

    }

    @Test
    void testToString() {
        Assertions.assertEquals("[]" , dlList.toString());
    }


}