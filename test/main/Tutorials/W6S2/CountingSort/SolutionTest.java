package main.Tutorials.W6S2.CountingSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    public void testExampleA() {

        System.out.println((int) 'a');
        System.out.println((int) 'b');
        System.out.println((int) 'c');
        System.out.println((int) 'd');
        System.out.println((int) 'e');
        System.out.println((int) 'f');
        System.out.println((int) 'g');
        System.out.println((int) 'h');
        System.out.println((int) 'z');


        int[] arr = new int[]{42, 24, 4, 2, 1, 0, 43, 22, 13, 5};
        int[] expected = new int[]{0, 1, 2, 4, 5, 13, 22, 24, 42, 43};
        assertArrayEquals(expected, Solution.countingSort(arr));
    }

    @Test
    public void testExampleB() {
        int[] arr = new int[]{5, 3, 42, 24, 1, 53, 2};
        int[] expected = new int[]{1, 2, 3, 5, 24, 42, 53};
        assertArrayEquals(expected, Solution.countingSort(arr));
    }

    @Test
    public void testExampleC() {
        int[] arr = new int[]{3, 0, 4, 2, 6};
        int[] expected = new int[]{0, 2, 3, 4, 6};
        assertArrayEquals(expected, Solution.countingSort(arr));
    }
}