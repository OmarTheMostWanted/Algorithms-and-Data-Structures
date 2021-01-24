package main.Week4.MainMatter.Quicksort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    /**
     * sorting an unsorted array
     */
    @Test
    public void testNormal() {
        int[] data = {11, 90, 33, 71, 24, 50, 35, 30, 15, 21};
        int[] data2 = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90};
        Solution.quickSort(data);
        System.out.println(Arrays.toString(data));
        assertArrayEquals(data2, data);
    }

    @Test
    public void test1() {
        int[] data = {11, 90, 33, 71, 24};
        int[] data2 = Arrays.copyOf(data, data.length);
        Arrays.sort(data2);

        Solution.quickSort(data);
        assertArrayEquals(data2, data);
    }

    @Test
    public void test2() {
        int[] data = {11, 11, 11, 11, 11, 11, 90};
        int[] data2 = Arrays.copyOf(data, data.length);
        Arrays.sort(data2);

        Solution.quickSort(data);
        assertArrayEquals(data2, data);
    }

}