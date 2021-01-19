package main.Week4.Prerequisites.MergeSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    /**
     * sorting an unsorted array
     */
    @Test
    public void testNormal() {
        int[] data = {11, 90, 33, 71, 24, 50, 35, 30, 15, 21};
        int[] data2 = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90};
        int[] result = Solution.mergeSort(data);
        assertArrayEquals(data2, result);
    }

    @Test
    public void testNormal1() {
        int[] data = {11, 90, 33, 71, 100, 24, 50, 35, 30, 15, 21};
        int[] data2 = {11, 15, 21, 24, 30, 33, 35, 50, 71, 90, 100};
        int[] result = Solution.mergeSort(data);
        assertArrayEquals(data2, result);
    }

}