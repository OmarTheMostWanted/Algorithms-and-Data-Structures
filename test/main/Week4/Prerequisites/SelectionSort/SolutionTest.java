package main.Week4.Prerequisites.SelectionSort;

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
        Solution.selectionSort(data);
        assertArrayEquals(data2, data);
    }
}