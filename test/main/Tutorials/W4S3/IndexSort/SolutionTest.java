package main.Tutorials.W4S3.IndexSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
    @Test
    public void testExample() {
        String[] arr = {"a", "d", "b", "c"};
        int[] res = Solution.indexSort(arr);
        System.out.println(Arrays.toString(res));
        int[] expected = {0, 2, 3, 1};
        assertArrayEquals(expected, res);
    }

    @Test
    public void testNull() {
        String[] arr = null;
        int[] res = Solution.indexSort(arr);
        assertNull(res);
    }

    @Test
    public void testEmpty() {
        String[] arr = {};
        int[] res = Solution.indexSort(arr);
        int[] expected = {};
        assertArrayEquals(expected, res);
    }
}