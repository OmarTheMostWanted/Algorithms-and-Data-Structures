package main.Week4.MainMatter.MergeSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    public void testExample() {
        Lawyer one = new Lawyer(1, 2, 3, 4, 5);
        Lawyer two = new Lawyer(2, 3, 4, 5, 6);
        MyQueue<Lawyer> input = new MyQueue<>();
        input.enqueue(one);
        input.enqueue(two);
        MyQueue<Lawyer> solution = Solution.sortingSomeLawyer(input);

        assertEquals(two, solution.dequeue());
        assertEquals(one, solution.dequeue());
        assertTrue(solution.isEmpty());
    }

    @Test
    public void test() {
        Lawyer lawyer1 = new Lawyer(1, 2, 1, 4, 5);
        Lawyer lawyer2 = new Lawyer(2, 3, 2, 5, 6);
        Lawyer lawyer3 = new Lawyer(2, 3, 3, 5, 6);
        Lawyer lawyer4 = new Lawyer(2, 3, 4, 5, 6);
        Lawyer lawyer44 = new Lawyer(2, 3, 4, 5, 6);
        Lawyer lawyer5 = new Lawyer(2, 3, 5, 5, 6);
        Lawyer lawyer6 = new Lawyer(2, 3, 6, 5, 6);
        Lawyer lawyer7 = new Lawyer(2, 3, 7, 5, 6);
        Lawyer lawyer71 = new Lawyer(2, 3, 7, 5, 6);
        Lawyer lawyer72 = new Lawyer(2, 3, 7, 5, 6);
        Lawyer lawyer73 = new Lawyer(2, 3, 7, 6, 6);
        Lawyer lawyer8 = new Lawyer(2, 3, 8, 5, 6);
        Lawyer lawyer9 = new Lawyer(2, 3, 9, 5, 6);
        Lawyer lawyer10 = new Lawyer(2, 3, 10, 5, 6);

        MyQueue<Lawyer> input = new MyQueue<>();
        input.enqueue(lawyer1);
        input.enqueue(lawyer2);
        input.enqueue(lawyer3);
        input.enqueue(lawyer4);
        input.enqueue(lawyer44);
        input.enqueue(lawyer5);
        input.enqueue(lawyer6);
        input.enqueue(lawyer7);
        input.enqueue(lawyer71);
        input.enqueue(lawyer72);
        input.enqueue(lawyer73);
        input.enqueue(lawyer8);
        input.enqueue(lawyer9);
        input.enqueue(lawyer10);


        MyQueue<Lawyer> solution = Solution.sortingSomeLawyer(input);


        assertEquals(lawyer10, solution.dequeue());
        assertEquals(lawyer9, solution.dequeue());
        assertEquals(lawyer8, solution.dequeue());
        assertEquals(lawyer73, solution.dequeue());
        assertEquals(lawyer72, solution.dequeue());
        assertEquals(lawyer71, solution.dequeue());
        assertEquals(lawyer7, solution.dequeue());
        assertEquals(lawyer6, solution.dequeue());
        assertEquals(lawyer5, solution.dequeue());
        assertEquals(lawyer4, solution.dequeue());
        assertEquals(lawyer3, solution.dequeue());
        assertEquals(lawyer2, solution.dequeue());
        assertEquals(lawyer1, solution.dequeue());

        assertTrue(solution.isEmpty());


    }

    @Test
    public void testExampleEmptyQueue() {
        MyQueue<Lawyer> input = new MyQueue<>();
        MyQueue<Lawyer> solution = Solution.sortingSomeLawyer(input);
        assertTrue(solution.isEmpty());
    }
}