package test;

import main.CLList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CLListTest {

    private CLList<Integer> integerCLList;
    private CLList<String> stringCLList;

    @BeforeEach
    void setUp() {
        integerCLList = new CLList<Integer>();
        stringCLList = new CLList<>();
    }

    @AfterEach
    void dispose() {
        integerCLList = null;
        stringCLList = null;
    }


    @Test
    void constructor() {
        Assertions.assertNotNull(integerCLList);
    }

    @Test
    void constructor1() {
        Assertions.assertEquals(0, integerCLList.getSize());
    }

    @Test
    void constructor2() {
        Assertions.assertNull(integerCLList.getFirst());
    }

    @Test
    void addFistTest() {
        integerCLList.addFirst(1);
        Assertions.assertEquals(1, integerCLList.getFirst());
    }

    @Test
    void addFistTest1() {
        integerCLList.addFirst(1);
        Assertions.assertEquals(1, integerCLList.getSize());
        Assertions.assertEquals(1, integerCLList.getLast());
    }

    @Test
    void addFirstTest2() {
        stringCLList.addFirst("test");
        stringCLList.addFirst("1");
        Assertions.assertEquals("test", stringCLList.getLast());
        Assertions.assertEquals("1", stringCLList.getFirst());
        Assertions.assertEquals(2, stringCLList.getSize());
    }

    @Test
    void addLastTest() {
        stringCLList.addLast("zero");
        Assertions.assertEquals(1, stringCLList.getSize());
    }

    @Test
    void addLastTest1() {

        final String test = "zero";
        stringCLList.addLast(test);
        Assertions.assertEquals(test, stringCLList.getFirst());
        Assertions.assertEquals(test, stringCLList.getLast());
    }

    @Test
    void addLastTest2() {
        integerCLList.addLast(0);
        integerCLList.addLast(1);
        integerCLList.addFirst(2);
        Assertions.assertEquals(3, integerCLList.getSize());
        Assertions.assertEquals(1, integerCLList.getLast());
        Assertions.assertEquals(2, integerCLList.getFirst());
    }

    @Test
    void rotateTest() {
        integerCLList.rotate();
        Assertions.assertNull(integerCLList.getFirst());

        integerCLList.addFirst(1);
        integerCLList.rotate();

        Assertions.assertEquals(1, integerCLList.getFirst());
        Assertions.assertEquals(1, integerCLList.getLast());
    }

    @Test
    void rotateTest1() {
        integerCLList.addFirst(0);
        integerCLList.addFirst(1);

        Assertions.assertEquals(1, integerCLList.getFirst());
        Assertions.assertEquals(0, integerCLList.getLast());

        integerCLList.rotate();

        Assertions.assertEquals(0, integerCLList.getFirst());
        Assertions.assertEquals(1, integerCLList.getLast());
    }

    @Test
    void rotateTest2() {

        integerCLList.addLast(0);
        integerCLList.addLast(1);
        integerCLList.addLast(2);
        integerCLList.addLast(3);

        Assertions.assertEquals(0, integerCLList.getFirst());

        integerCLList.rotate();
        Assertions.assertEquals(1, integerCLList.getFirst());
        Assertions.assertEquals(0, integerCLList.getLast());

    }




}
