package main.Week4.MainMatter.TaskScheduling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void testExample() {
        int[] tasks = {3, 7, 5};
        assertEquals(8, Solution.completeTasks(tasks, 2));
    }

    @Test
    public void test() {
        int[] tasks = {2, 3, 1, 2, 5, 4, 1, 1};


        assertEquals(10, Solution.completeTasks(tasks, 2));
    }

}