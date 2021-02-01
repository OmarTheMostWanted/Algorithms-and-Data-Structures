package main.Exam.Ex1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
    @Test
    public void testExample() {
        assertEquals(Arrays.asList("BC4D2A", "AC1D4B", "AC1B3B", "AB1B3B", "AB2A4B", "AB2A4A", "AA1B3B"), Solution.sortDoctorIds(Arrays.asList("AA1B3B", "AB2A4B", "BC4D2A", "AB1B3B", "AB2A4A", "AC1B3B", "AC1D4B")));
    }

    @Test
    public void testNull() {
        assertNull(Solution.sortDoctorIds(null));
    }

    @Test
    public void testEmpty() {
        assertEquals(Collections.emptyList(), Solution.sortDoctorIds(Collections.emptyList()));
    }
}