package main.Week2.Old;

public class QueueWithFixedSizeCircularArray {

    private int[] arr;
    private int start;
    private int end;
    private int size;

    /**
     * Creates a new ArrayQueue with the given capacity.
     *
     * @param capacity the capacity for this queue
     */
    public QueueWithFixedSizeCircularArray(int capacity) {
        arr = new int[capacity];
        start = 0;
        end = 0;
        size = 0;
    }

    /**
     * Adds the given element to the queue.
     *
     * @param e the element to add to the queue
     * @throws FullQueueException if the queue is full
     */
    public void enqueue(int e) throws FullQueueException {
        if (size == arr.length) throw new FullQueueException();
        int i = (start + size) % arr.length;
        arr[i] = e;
        end = i;
        size++;
    }

    /**
     * Removes an element from the queue and returns it.
     *
     * @return the first element in the queue
     * @throws EmptyQueueException if the queue is empty
     */
    public int dequeue() throws EmptyQueueException {
        if (size == 0) throw new EmptyQueueException();

        int res = 0;
        if (start < end) {
            res = arr[start];
            start++;
        } else if (start == end) {
            res = arr[start];
            end = 0;
            start = 0;
        } else if (start > end) {
            res = arr[start];
            if (start + 1 == arr.length) {
                start = 0;
            } else {
                start++;
            }
        }
        size--;
        return res;
    }

    private class FullQueueException extends Exception {
    }

    private class EmptyQueueException extends Exception {
    }
}
