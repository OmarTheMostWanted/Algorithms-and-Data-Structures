package main.Tutorials.W4S3.QuicksortQueue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testExampleA() {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(4, 2, 42, 24, 1, 100));
        Queue<Integer> expected = new LinkedList<>(Arrays.asList(1, 2, 4, 24, 42, 100));
        assertEquals(expected, Solution.queueSort(q));
    }

    @Test
    public void testExampleB() {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(-4, 2, 42, -24, -100, 1));
        Queue<Integer> expected = new LinkedList<>(Arrays.asList(-100, -24, -4, 1, 2, 42));
        assertEquals(expected, Solution.queueSort(q));
    }

    @Test
    public void testNull() {
        Queue<Integer> q = null;
        Queue<Integer> expected = null;
        assertEquals(expected, Solution.queueSort(q));
    }
}