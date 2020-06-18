package test.week6;

import org.junit.jupiter.api.Test;

import static main.week6.StableSort.stableSort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StableSortTest {
    @Test
    public void testEmpty() {
        String[][] data = {};
        String[][] data2 = {};
        stableSort(data, 0);
        assertArrayEquals(data2, data);
    }

    @Test
    public void testOneColumn() {
        String[][] data = {{"d"}, {"a"}, {"e"}, {"b"}, {"g"}, {"c"}, {"f"}};
        String[][] data2 = {{"a"}, {"b"}, {"c"}, {"d"}, {"e"}, {"f"}, {"g"}};
        stableSort(data, 0);
        assertArrayEquals(data2, data);
    }

    @Test
    public void testMixed() {
        String[][] data = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        String[][] data2 = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        String[][] data3 = {{"ccc", "bbb"}, {"aaa", "ddd"}};
        stableSort(data, 0);
        assertArrayEquals(data2, data);
        stableSort(data, 1);
        assertArrayEquals(data3, data);
    }

    @Test
    public void test(){

        String[][] data = {  {"bzb" , "cxc" , "dad" , "mom"} , {"dd"}, {"aa"}, {"ee"}, {"bb"}, {"gg"}, {"cc"}, {"ff"} };
        String[][] res = { {"dad" , "mom" , "cxc" , "bzb"} ,   {"aa"}, {"bb"}, {"cc"}, {"dd"}, {"ee"}, {"ff"}, {"gg"}};
        stableSort(data, 1);
        assertArrayEquals(res, data);

    }
}
