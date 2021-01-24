package main.Tutorials.W6S3.FindSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void testExampleA() {
        float[] arr = new float[]{42, 24, 4, 2, 1, 0, 43, 22, 13, 5};
        assertEquals(20f, Solution.findSum(arr, 9), 0.1);
    }

    @Test
    public void testExampleB() {
        float[] arr = new float[]{42, 24, 4, 2, 1, 0, 43, 22, 13, 5};
        assertEquals(312f, Solution.findSum(arr, 37), 0.1);
    }

    @Test
    public void testExampleC() {
        float[] arr = new float[]{42, 24, 4, 2, 1, 0, 43, 22, 13, 5};
        assertEquals(-1f, Solution.findSum(arr, 99), 0.1);
    }

}