package main.Week3.MainMatter.SummingTrees;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testExample() {
        Tree t1 = new Tree(1, Arrays.asList(new Tree(2), new Tree(3), new Tree(4)));
        Tree t2 = new Tree(5, Arrays.asList(new Tree(6), new Tree(7), new Tree(8)));
        Tree res = new Tree(6, Arrays.asList(new Tree(8), new Tree(10), new Tree(12)));
        assertEquals(res, Solution.sum(t1, t2));
    }
}