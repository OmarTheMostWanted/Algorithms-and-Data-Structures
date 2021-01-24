package main.Tutorials.W4S3.QuackSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    public void testExampleA() {
        int[] arr = new int[]{4, 2, 42, 24, 1, 100};
        int[] expected = new int[]{1, 2, 4, 24, 42, 100};
        Solution.quackSort(arr);

        System.out.println(Arrays.toString(arr));

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testExampleB() {
        int[] arr = new int[]{8, 9, 5, 1, 6, 2, 3, 4, 7};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Solution.quackSort(arr);
        assertArrayEquals(expected, arr);
    }
}