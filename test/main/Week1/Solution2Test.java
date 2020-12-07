package main.Week1;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class Solution2Test {

    @Test
    public void testExample() {
        int[] arr = {1, 2, 3, 4, 5};
        Solution2.reverse(arr);
        int[] result = {5, 4, 3, 2, 1};
        assertArrayEquals(result, arr);
    }

}