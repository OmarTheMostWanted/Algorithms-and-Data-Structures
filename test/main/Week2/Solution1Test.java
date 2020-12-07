package main.Week2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Solution1Test {
    @Test
    public void testRemoveArray_Empty() {
        int[] array = new int[0];
        assertEquals(0, Solution1.removeLastOccurrence(5, array).length);
    }

    @Test
    public void testFirstSimple() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(result, Solution1.removeLastOccurrence(1, input));
    }

    @Test
    public void testLastSimple() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(result, Solution1.removeLastOccurrence(10, input));
    }
}