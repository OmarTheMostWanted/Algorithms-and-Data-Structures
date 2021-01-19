package main.Week4.Prerequisites.MergeSortedQueues;

import java.util.LinkedList;

class MyQueue<T> {

    private LinkedList<T> q;

    public MyQueue() {
        this.q = new LinkedList<>();
    }

    public void enqueue(T e) {
        q.add(e);
    }

    public T dequeue() {
        return q.poll();
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public T front() {
        return q.peek();
    }

    @Override
    public boolean equals(Object other) {

        if (other instanceof MyQueue<?>) {
            MyQueue<T> that = (MyQueue<T>) other;

            return this.q.equals(that.q);
        }
        return false;

    }
}
