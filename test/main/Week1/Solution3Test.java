package main.Week1;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class Solution3Test {

    @Test
    public void testSmall() {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {2, 3, 5, 6};
        int[] arr = Solution3.merge(arr1, arr2);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4, 5, 6}, arr);
    }

}