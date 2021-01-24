package main.Week4.MainMatter.HeapsOfPriority;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Takes a list and returns a new list sorted in descending order.
     * This is done by using the priority queue `queue`.
     * <p>
     * Return null if list is null.
     *
     * @param list the array that needs to be sorted.
     */
    public static List<Integer> pqSort(List<Integer> list) {
        LibraryPQ queue = new SolutionPQ();

        if (list == null) return null;
        int s = 0;
        for (Integer i : list) {
            queue.insert(i);
            s++;
        }
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            res.add(queue.removeMax());
        }
        return res;

    }
}

class SolutionPQ extends LibraryPQ {
    /**
     * Restores the heap property in a heap represented as an arraylist.
     * The method compares the node to its parent and swaps if necessary.
     *
     * @param i index of the node
     */
    @Override
    public void upHeap(int i) {
        int parent;
        while (i > 0) {
            parent = (i - 1) / 2;
            if (parent >= 0) {
                int element = this.getInHeap(i);
                int parentE = this.getInHeap(parent);
                if (parentE < element) {
                    swap(parent, i);
                    i = parent;
                } else break;
            }
        }
    }
}
