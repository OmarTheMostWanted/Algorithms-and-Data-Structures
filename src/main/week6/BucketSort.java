package main.week6;

import java.util.LinkedList;
import java.util.Queue;

public class BucketSort {
    @SuppressWarnings("unchecked")
    public static Queue<Integer>[] fillBuckets(int[] array) {
        int vmin = 0;
        int vmax = 0;
        vmin = Integer.MAX_VALUE;
        vmax = Integer.MIN_VALUE;

        if (array.length == 0)
            return new Queue[0];

        for (int e : array) {
            if (e > vmax)
                vmax = e;

            if (e < vmin)
                vmin = e;
        }

        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];

        for (int e : array) {
            if (buckets[e - vmin] == null)
                buckets[e - vmin] = new LinkedList<Integer>();
            buckets[e - vmin].add(e);

        }

        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        int size = 0;
        for (Queue<Integer> bucketList : buckets) {
            if (bucketList != null)
                size += bucketList.size();
        }

        int[] res = new int[size];
        int counter = 0;
        for (Queue<Integer> bucketList : buckets) {
            if (bucketList != null)
                while (!bucketList.isEmpty()) {
                    res[counter] = bucketList.remove();
                    counter++;
                }
        }
        return res;
    }
}
