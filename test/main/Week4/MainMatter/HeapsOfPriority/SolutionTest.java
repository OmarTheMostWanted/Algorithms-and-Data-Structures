package main.Week4.MainMatter.HeapsOfPriority;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {


    private static int[] reverse(int a[]) {

        int n = a.length;
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

        return b;

    }

    @Test
    public void testExample() {
        List<Integer> input = Arrays.asList(4, 2, 5, 1, 3);
        List<Integer> res = Solution.pqSort(input);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), res);
    }

    @Test
    public void test() {

        int[] in = {4, 3, 5, 0, 34, 56, 2, 6, 2, 1, 8, 6, 9};


        List<Integer> test = new ArrayList<>();
        List<Integer> input = new ArrayList<>();

        for (Integer e : (in)) {
            input.add(e);
        }

        Arrays.sort(in);
        for (Integer e : reverse(in)) {
            test.add(e);
        }


        List<Integer> res = Solution.pqSort(input);
        assertEquals(test, res);
    }

    @Test
    public void testNull() {
        List<Integer> input = null;
        List<Integer> res = Solution.pqSort(input);
        assertEquals(null, res);
    }

    @Test
    public void testEmpty() {
        List<Integer> input = new ArrayList<>();
        List<Integer> res = Solution.pqSort(input);
        assertEquals(new ArrayList<Integer>(), res);
    }

    @Test
    public void testHeap() {
        LibraryPQ queue = new SolutionPQ();
        queue.insert(15);
        queue.insert(6);
        queue.insert(72);
        queue.insert(13);
        assertTrue(queue.heapEquals(Arrays.asList(72, 13, 15, 6)));
    }

}