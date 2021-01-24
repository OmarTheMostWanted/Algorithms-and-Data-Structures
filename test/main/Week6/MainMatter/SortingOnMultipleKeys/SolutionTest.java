package main.Week6.MainMatter.SortingOnMultipleKeys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    public void testEmpty() {
        String[][] data = {};
        String[][] data2 = {};
        Solution.stableSort(data, 0);
        assertArrayEquals(data2, data);
    }

    @Test
    public void testOneColumn() {
        String[][] data = {{"d"}, {"a"}, {"e"}, {"b"}, {"g"}, {"c"}, {"f"}};
        String[][] data2 = {{"a"}, {"b"}, {"c"}, {"d"}, {"e"}, {"f"}, {"g"}};
        Solution.stableSort(data, 0);
        assertArrayEquals(data2, data);
    }

    @Test
    public void testMixed() {
        String[][] data = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        String[][] data2 = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        String[][] data3 = {{"ccc", "bbb"}, {"aaa", "ddd"}};
        Solution.stableSort(data, 0);
        assertArrayEquals(data2, data);
        Solution.stableSort(data, 1);
        assertArrayEquals(data3, data);
    }
}