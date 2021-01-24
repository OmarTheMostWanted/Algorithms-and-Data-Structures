package main.Week6.Prerequisites.BucketSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    @SuppressWarnings("unchecked")
    public static Queue<Integer>[] fillBuckets(int[] array) {
        int vmin = Integer.MAX_VALUE;
        int vmax = Integer.MIN_VALUE;
        if (array.length == 0) return new Queue[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < vmin) {
                vmin = array[i];
            }
            if (array[i] > vmax) {
                vmax = array[i];
            }
        }
        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];
        for (int i = 0; i < array.length; i++) {
            if (buckets[array[i] - vmin] == null) buckets[array[i] - vmin] = new LinkedList<>();
            buckets[array[i] - vmin].add(array[i]);
        }
        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            while (!buckets[i].isEmpty()) {
                res.add(buckets[i].poll());
            }
        }
        int[] list = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            list[i] = res.get(i);
        }
        return list;
    }
}
