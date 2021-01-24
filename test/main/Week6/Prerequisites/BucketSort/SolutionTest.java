package main.Week6.Prerequisites.BucketSort;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testFillBucketsZeroElements() {
        int[] a = {};
        Queue<Integer>[] buckets = Solution.fillBuckets(a);
        // Check a has not been changed.
        assertEquals(0, a.length);
        // Check no buckets have been created
        assertEquals(0, buckets.length);
    }

    @Test
    public void testFillBucketsOneElement() {
        int[] a = {42};
        Queue<Integer>[] buckets = Solution.fillBuckets(a);
        // Check a has not been changed.
        assertEquals(42, a[0]);
        // Check one bucket has been created
        assertEquals(1, buckets.length);
        assertEquals(new Integer(42), buckets[0].peek());
    }

    @Test
    public void testFillBucketsTwoElements() {
        int[] a = {42, 21};
        Queue<Integer>[] buckets = Solution.fillBuckets(a);
        // Check a has not been changed.
        assertEquals(42, a[0]);
        assertEquals(21, a[1]);
        // Check enough buckets have been created
        assertEquals(22, buckets.length);
        // Check that the values are in the right buckets
        assertEquals(new Integer(21), buckets[0].peek());
        assertEquals(new Integer(42), buckets[21].peek());
    }

    @Test
    public void testFillBucketsThreeElements() {
        int[] a = {42, 42, 21};
        Queue<Integer>[] buckets = Solution.fillBuckets(a);
        // Check a has not been changed.
        assertEquals(42, a[0]);
        assertEquals(42, a[1]);
        assertEquals(21, a[2]);
        // Check one bucket has been created
        assertEquals(22, buckets.length);
        assertEquals(new Integer(21), buckets[0].poll());
        assertEquals(new Integer(42), buckets[21].poll());
        assertEquals(new Integer(42), buckets[21].poll());
    }

    @Test
    public void testSortZeroElements() {
        int[] a = {};
        int[] sorted = Solution.readBuckets(Solution.fillBuckets(a));
        // Check a has not been changed.
        assertEquals(0, a.length);
        // Check sorted array has the same length.
        assertEquals(0, sorted.length);
    }

    @Test
    public void testSortOneElement() {
        int[] a = {42};
        int[] sorted = Solution.readBuckets(Solution.fillBuckets(a));
        // Check that a new array has been built.
        assertFalse(a == sorted);
        // Check sorted array.
        assertArrayEquals(a, sorted);
    }

    @Test
    public void testSortTwoElements() {
        int[] a = {42, 21};
        int[] expected = {21, 42};
        int[] sorted = Solution.readBuckets(Solution.fillBuckets(a));
        // Check sorted array has the same length.
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void testSortThreeElements() {
        int[] a = {42, 15, 21};
        int[] expected = {15, 21, 42};
        int[] sorted = Solution.readBuckets(Solution.fillBuckets(a));
        // Check sorted array has the same length.
        assertArrayEquals(expected, sorted);
    }
}