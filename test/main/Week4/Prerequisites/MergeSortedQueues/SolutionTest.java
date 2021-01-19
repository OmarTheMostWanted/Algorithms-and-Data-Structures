package main.Week4.Prerequisites.MergeSortedQueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    public void testSmall() {
        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.enqueue(4);
        queue1.enqueue(2);
        queue1.enqueue(1);

        MyQueue<Integer> queue2 = new MyQueue<>();
        queue2.enqueue(6);
        queue2.enqueue(5);
        queue2.enqueue(3);
        queue2.enqueue(2);

        MyQueue<Integer> solution = Solution.merge(queue1, queue2);

        assertEquals(Integer.valueOf(6), solution.dequeue());
        assertEquals(Integer.valueOf(5), solution.dequeue());
        assertEquals(Integer.valueOf(4), solution.dequeue());
        assertEquals(Integer.valueOf(3), solution.dequeue());
        assertEquals(Integer.valueOf(2), solution.dequeue());
        assertEquals(Integer.valueOf(2), solution.dequeue());
        assertEquals(Integer.valueOf(1), solution.dequeue());
        assertTrue(solution.isEmpty());

        assertEquals(Integer.valueOf(4), queue1.dequeue());
        assertEquals(Integer.valueOf(2), queue1.dequeue());
        assertEquals(Integer.valueOf(1), queue1.dequeue());
        assertTrue(queue1.isEmpty());

        assertEquals(Integer.valueOf(6), queue2.dequeue());
        assertEquals(Integer.valueOf(5), queue2.dequeue());
        assertEquals(Integer.valueOf(3), queue2.dequeue());
        assertEquals(Integer.valueOf(2), queue2.dequeue());
        assertTrue(queue2.isEmpty());
    }

    @Test
    public void testnull() {
        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.enqueue(4);
        queue1.enqueue(2);
        queue1.enqueue(1);

        MyQueue<Integer> queue2 = null;
        MyQueue<Integer> solution = Solution.merge(queue1, queue2);

        assertEquals(queue1, solution);
    }

    @Test
    public void testempty() {
        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.enqueue(4);
        queue1.enqueue(2);
        queue1.enqueue(1);

        MyQueue<Integer> queue2 = new MyQueue<>();
        MyQueue<Integer> solution = Solution.merge(queue1, queue2);

        assertEquals(queue1, solution);
    }

}