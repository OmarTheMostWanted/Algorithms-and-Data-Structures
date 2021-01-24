package main.Tutorials.W4S3.QuicksortQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * Sorts the queue using quicksort.
     *
     * @param q - the input queue that needs to be sorted
     * @return a sorted queue containing the elements from q
     */
    public static Queue<Integer> queueSort(Queue<Integer> q) {

        if (q == null) return null;

        if (q.size() < 2) return q;

        Queue<Integer> smallerOrEqual = new LinkedList<>();
        Queue<Integer> larger = new LinkedList<>();

        int pivot = q.poll();

//        while (!q.isEmpty()){
//            if(q.peek() > pivot) larger.add(q.poll());
//            else smallerOrEqual.add(q.poll());
//        }

        q.forEach(e -> {
            if (e > pivot) larger.add(e);
            else smallerOrEqual.add(e);
        });

        Queue<Integer> res = new LinkedList<>();

        res.addAll(queueSort(smallerOrEqual));
        res.add(pivot);
        res.addAll(queueSort(larger));

        return res;

    }

    private static void swap(int[] elements, int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}
