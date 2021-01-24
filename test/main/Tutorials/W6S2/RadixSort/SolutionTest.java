package main.Tutorials.W6S2.RadixSort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testEmpty() {
        assertEquals(new ArrayList<>(), Solution.radixSortMSD(new ArrayList<>()));
    }

    @Test
    public void testReversed() {
        List<String> data = Arrays.asList("donut", "cherry", "banana", "apple");
        List<String> data2 = Arrays.asList("apple", "banana", "cherry", "donut");
        assertEquals(data2, Solution.radixSortMSD(data));
    }

    @Test
    public void test() {

        List<String> data = Arrays.asList("dca", "aca", "bca", "baa", "bac", "bab", "aza");
        List<String> data2 = Arrays.asList("aca", "aza", "baa", "bab", "bac", "bca", "dca");
        assertEquals(data2, Solution.radixSortMSD(data));

    }
}