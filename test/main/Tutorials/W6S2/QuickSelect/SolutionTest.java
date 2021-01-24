package main.Tutorials.W6S2.QuickSelect;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testExample() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 52, 42, 6, 123, 2, 1, 4, 44, 64));
        assertEquals((Integer) 4, Solution.quickSelect(list, 4));
        assertEquals((Integer) 42, Solution.quickSelect(list, 7));
    }
}