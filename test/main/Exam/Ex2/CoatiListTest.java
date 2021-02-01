package main.Exam.Ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoatiListTest {
    @Test
    public void oneElement() {
        CoatiList list = new CoatiList();
        list.addLast(42);
        assertEquals(42, list.getHead().getValue());
        assertEquals(42, list.getTail().getValue());
    }

    @Test
    public void twoElements() {
        CoatiList list = new CoatiList();
        list.addLast(4);
        list.addLast(3);
        assertEquals(3, list.removeLast());
        assertEquals(4, list.removeLast());
    }

    @Test
    public void getPosition() {
        CoatiList list = new CoatiList();
        list.addLast(1);
        list.addLast(2);
        //assertEquals(1, list.getValueAtPosition(0));
        assertEquals(2, list.getValueAtPosition(1));
    }

    @Test
    public void remove() {
        CoatiList list = new CoatiList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        assertEquals(1, list.getValueAtPosition(0));
        assertEquals(2, list.getValueAtPosition(1));
        assertEquals(3, list.getValueAtPosition(2));
        assertEquals(4, list.getValueAtPosition(3));

        assertEquals(4, list.removeLast());
        assertEquals(3, list.removeLast());
        assertEquals(2, list.removeLast());
        assertEquals(1, list.removeLast());


    }

}