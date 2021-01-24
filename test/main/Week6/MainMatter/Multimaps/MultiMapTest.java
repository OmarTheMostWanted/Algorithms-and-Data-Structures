package main.Week6.MainMatter.Multimaps;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MultiMapTest {

    @Test
    public void testEverythingOneItem() {
        MultiMap map = new MultiMap();
        map.put(1, 2);
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        assertEquals(Collections.singletonList(2), map.get(1));
        assertFalse(map.remove(1, 3));
        assertTrue(map.remove(1, 2));
    }

    @Test
    public void test() {
        MultiMap map = new MultiMap();
        map.put(1, 2);
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());

        map.put(2, 3);


        assertEquals(Collections.singletonList(2), map.get(1));
        assertEquals(Collections.singletonList(3), map.get(2));

        map.put(2, 3);

        assertEquals(Arrays.asList(new Integer[]{3, 3}), map.get(2));

        assertFalse(map.remove(1, 3));
        assertTrue(map.remove(1, 2));
    }


}