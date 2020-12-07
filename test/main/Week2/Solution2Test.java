package main.Week2;

import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class Solution2Test {
    @Test
    public void testMultipleLast() {
        ArrayList<Integer> input = new ArrayList<>(asList(1, 1, 3, 5, 7, 1, 5, 9, 1));
        ArrayList<Integer> result = new ArrayList<>(asList(1, 1, 3, 5, 7, 1, 5, 9));
        Solution2.removeLastOccurrence(1, input);
        assertEquals(result, input);
    }
}