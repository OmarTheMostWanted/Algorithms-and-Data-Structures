package test.week4;

import main.week4.ArrayStack;
import main.week4.EmptyStackException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {
    @Test
    public void testConstructor() {
        ArrayStack tmp = new ArrayStack();
        assertArrayEquals(tmp.getElements(), new Object[1]);
    }

    @Test
    public void testToStringTwo() {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
    }

    @Test
    public void testGrowShrink() throws EmptyStackException {
        ArrayStack s = new ArrayStack();
        s.push(1);
        s.push(2);
        assertEquals("<ArrayStack[1,2]>(Size=2, Cap=2)", s.toString());
        s.push(3);
        assertEquals(4, s.getElements().length);

        s.pop();
        s.pop();
        s.pop();
        assertEquals(2, s.getElements().length);
    }

    @Test
    public void randomOpsTest() throws EmptyStackException {
        ArrayStack s = new ArrayStack();

        System.out.println(s.toString());

        for (int i = 0; i < 10; i++) {
            s.push(i);
        }

        System.out.println(s.toString());
        assertEquals(16, s.getElements().length);
        for (int i = 0; i < 5; i++) {
            s.pop();
        }
        System.out.println(s.toString());
        assertEquals(16, s.getElements().length);


        for (int i = 5; i < 10; i++) {
            s.push(i);
        }
        System.out.println(s.toString());
        assertEquals(16, s.getElements().length);

        for (int i = 10; i < 16; i++) {
            s.push(i);
        }

        System.out.println(s.toString());

        assertEquals(16, s.getElements().length);

        s.push(16);
        System.out.println(s.toString());

        assertEquals(32, s.getElements().length);

        for (int i = 0; i <= 16; i++) {
            s.pop();
        }
        System.out.println(s.toString());
        assertEquals(2, s.getElements().length);
        boolean ex = false;
        try {
            s.pop();
        } catch (EmptyStackException e) {
            ex = true;
        }
        assertTrue(ex);
    }
}
