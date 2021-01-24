package main.Week6.Prerequisites.SetOperations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySetTest {

    @Test
    public void testUnion() {
        // before
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        ms1.add("d");
        MySet ms2 = new MySet();
        ms2.add("a");
        ms2.add("d");
        ms2.add("t");
        ms2.add("t");
        // test code
        MySet union12 = ms1.union(ms2);
        MySet union21 = ms2.union(ms1);
        assertEquals(4, ms1.size());
        assertEquals(3, ms2.size());
        assertEquals(5, union12.size());
        assertTrue(union12.contains("a"));
        assertTrue(union12.contains("b"));
        assertTrue(union12.contains("c"));
        assertTrue(union12.contains("d"));
        assertTrue(union12.contains("t"));
        assertEquals(5, union21.size());
        assertTrue(union21.contains("a"));
        assertTrue(union21.contains("b"));
        assertTrue(union21.contains("c"));
        assertTrue(union21.contains("d"));
        assertTrue(union21.contains("t"));
    }

    @Test
    public void testIntersection() {
        // before
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        ms1.add("d");
        MySet ms2 = new MySet();
        ms2.add("a");
        ms2.add("d");
        ms2.add("t");
        ms2.add("t");
        // test code
        MySet intersection12 = ms1.intersection(ms2);
        MySet intersection21 = ms2.intersection(ms1);
        assertEquals(4, ms1.size());
        assertEquals(3, ms2.size());
        assertEquals(2, intersection12.size());
        assertTrue(intersection12.contains("a"));
        assertTrue(intersection12.contains("d"));
        assertEquals(2, intersection21.size());
        assertTrue(intersection21.contains("a"));
        assertTrue(intersection21.contains("d"));
    }

    @Test
    public void testDifference() {
        // before
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        ms1.add("d");
        MySet ms2 = new MySet();
        ms2.add("a");
        ms2.add("d");
        ms2.add("t");
        ms2.add("t");
        // test code
        MySet difference12 = ms1.difference(ms2);
        MySet difference21 = ms2.difference(ms1);

        assertEquals(4, ms1.size());
        assertEquals(3, ms2.size());
        assertEquals(2, difference12.size());
        assertTrue(difference12.contains("b"));
        assertTrue(difference12.contains("c"));
        assertEquals(1, difference21.size());
        assertTrue(difference21.contains("t"));
    }

    @Test
    public void testXOR() {
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        MySet ms2 = new MySet();
        ms2.add("b");
        ms2.add("c");
        ms2.add("d");
        MySet ms3 = ms1.exclusiveOr(ms2);
        String s = ms3.toString();
        assertTrue(s.contains("a"));
        assertFalse(s.contains("b"));
        assertFalse(s.contains("c"));
        assertTrue(s.contains("d"));
    }

    @Test
    public void testToString() {
        // before
        MySet ms1 = new MySet();
        ms1.add("a");
        ms1.add("b");
        ms1.add("c");
        ms1.add("d");
        // test code
        String s = ms1.toString();
        assertTrue(s.contains("a"));
        assertTrue(s.contains("b"));
        assertTrue(s.contains("c"));
        assertTrue(s.contains("d"));
        assertTrue(s.contains(">"));
        assertTrue(s.contains("<"));
        assertTrue(s.contains("MySet"));
    }

}