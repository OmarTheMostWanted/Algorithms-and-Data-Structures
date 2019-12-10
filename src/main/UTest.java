package main;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UTest {
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
}
