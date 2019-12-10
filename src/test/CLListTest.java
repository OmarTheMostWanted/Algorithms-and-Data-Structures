package test;

import main.CLL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CLListTest {

    private CLL<Integer> integerCLL;
    private CLL<String> stringCLL;

    @BeforeEach
    void setUp() {
        integerCLL = new CLL<Integer>();
        stringCLL = new CLL<String>();
    }

    @AfterEach
    void dispose() {
        integerCLL = null;
        stringCLL = null;
    }


    @Test
    void constructor() {
        Assertions.assertNotNull(integerCLL);
    }

    @Test
    void constructor1() {
        Assertions.assertEquals(0, integerCLL.getSize());
    }

    @Test
    void constructor2() {
        Assertions.assertNull(integerCLL.getFirst());
    }

    @Test
    void addFistTest() {
        integerCLL.addFirst(1);
        Assertions.assertEquals(1, integerCLL.getFirst());
    }

    @Test
    void addFistTest1() {
        integerCLL.addFirst(1);
        Assertions.assertEquals(1, integerCLL.getSize());
        Assertions.assertEquals(1, integerCLL.getLast());
    }

    @Test
    void addFirstTest2() {
        stringCLL.addFirst("test");
        stringCLL.addFirst("1");
        Assertions.assertEquals("test", stringCLL.getLast());
        Assertions.assertEquals("1", stringCLL.getFirst());
        Assertions.assertEquals(2, stringCLL.getSize());
    }

    @Test
    void addLastTest() {
        stringCLL.addLast("zero");
        Assertions.assertEquals(1, stringCLL.getSize());
    }

    @Test
    void addLastTest1() {

        final String test = "zero";
        stringCLL.addLast(test);
        Assertions.assertEquals(test, stringCLL.getFirst());
        Assertions.assertEquals(test, stringCLL.getLast());
    }

    @Test
    void addLastTest2() {
        integerCLL.addLast(0);
        integerCLL.addLast(1);
        integerCLL.addFirst(2);
        Assertions.assertEquals(3, integerCLL.getSize());
        Assertions.assertEquals(1, integerCLL.getLast());
        Assertions.assertEquals(2, integerCLL.getFirst());
    }

    @Test
    void rotateTest() {
        integerCLL.rotate();
        Assertions.assertNull(integerCLL.getFirst());

        integerCLL.addFirst(1);
        integerCLL.rotate();

        Assertions.assertEquals(1, integerCLL.getFirst());
        Assertions.assertEquals(1, integerCLL.getLast());
    }

    @Test
    void rotateTest1() {
        integerCLL.addFirst(0);
        integerCLL.addFirst(1);

        Assertions.assertEquals(1, integerCLL.getFirst());
        Assertions.assertEquals(0, integerCLL.getLast());

        integerCLL.rotate();

        Assertions.assertEquals(0, integerCLL.getFirst());
        Assertions.assertEquals(1, integerCLL.getLast());
    }

    @Test
    void rotateTest2() {

        integerCLL.addLast(0);
        integerCLL.addLast(1);
        integerCLL.addLast(2);
        integerCLL.addLast(3);

        Assertions.assertEquals(0, integerCLL.getFirst());

        integerCLL.rotate();
        Assertions.assertEquals(1, integerCLL.getFirst());
        Assertions.assertEquals(0, integerCLL.getLast());

    }


    @Test
    void removeFirst() {

        integerCLL.addFirst(1);
        integerCLL.addLast(2);

        Assertions.assertEquals(1, integerCLL.removeFirst());

        Assertions.assertEquals(1, integerCLL.getSize());

    }

    @Test
    void removeFirst1() {
        Assertions.assertNull(integerCLL.removeFirst());
    }

    @Test
    void removeFirst2() {
        Assertions.assertNull(stringCLL.removeFirst());
    }

    @Test
    void removeLast() {

        integerCLL.addFirst(1);
        integerCLL.addLast(2);

        Assertions.assertEquals(2, integerCLL.removeLast());

        Assertions.assertEquals(1, integerCLL.getFirst());

        Assertions.assertEquals(1, integerCLL.getSize());
    }


    @Test
    void removeLast1() {
        Assertions.assertNull(stringCLL.removeLast());
    }


    @Test
    void toStringTest() {
        Assertions.assertEquals("[]", integerCLL.toString());
        integerCLL.addFirst(1);
        Assertions.assertEquals("[1]", integerCLL.toString());
        integerCLL.addFirst(2);
        Assertions.assertEquals("[2 1]", integerCLL.toString());

    }

    @Test
    void equalsTest() {
      //  Assertions.assertTrue(integerCLList.equals(integerCLList));
        Assertions.assertFalse(integerCLL.equals(stringCLL));
       // Assertions.assertFalse(integerCLList.equals(new Object()));

    }

}
