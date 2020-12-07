package main.Week1;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution4Test {
    @Test
    public void testExample() {
        int[] arr = {0, 1, 1, 3, 3, 3, 8, 10};
        int[] result = {1, 2, 0, 3, 0};
        assertArrayEquals(result, Solution4.count(arr, 4));
    }
}