package main.Week4.Prerequisites.MergeSortedQueues;

class Solution {

    /**
     * @param queue1 first sorted Queue to be merged
     * @param queue2 second sorted Queue to be merged
     * @return sorted Queue containing all elements from both Queues
     */
    public static MyQueue<Integer> merge(MyQueue<Integer> queue1, MyQueue<Integer> queue2) {

        if (queue1 == null && queue2 == null) return null;

        if (queue1 == null) return copy(queue2);
        if (queue2 == null) return copy(queue1);

        MyQueue<Integer> res = new MyQueue<>();

        MyQueue<Integer> q1 = new MyQueue<>();
        MyQueue<Integer> q2 = new MyQueue<>();


        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.front() > queue2.front()) {
                q1.enqueue(queue1.front());
                res.enqueue(queue1.dequeue());
            } else {
                q2.enqueue(queue2.front());
                res.enqueue(queue2.dequeue());
            }
        }

        while (!queue1.isEmpty()) {
            q1.enqueue(queue1.front());
            res.enqueue(queue1.dequeue());
        }

        while (!queue1.isEmpty()) {
            q2.enqueue(queue2.front());
            res.enqueue(queue2.dequeue());
        }

        while (!q1.isEmpty()) {
            queue1.enqueue(q1.dequeue());
        }

        while (!q2.isEmpty()) {
            queue2.enqueue(q2.dequeue());
        }

        return res;
    }

    private static MyQueue<Integer> copy(MyQueue<Integer> queue) {

        MyQueue<Integer> res = new MyQueue<>();
        MyQueue<Integer> q = new MyQueue<>();

        while (!queue.isEmpty()) {
            q.enqueue(queue.front());
            res.enqueue(queue.dequeue());
        }
        while (!q.isEmpty()) {
            queue.enqueue(q.dequeue());
        }

        return res;

    }

}