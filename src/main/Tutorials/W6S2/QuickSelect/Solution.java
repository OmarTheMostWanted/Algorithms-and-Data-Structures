package main.Tutorials.W6S2.QuickSelect;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public static Integer quickSelect(List<Integer> list, int k) {
        if (list.size() == 1) return list.get(0);

        List<Integer> less = new LinkedList<>();
        List<Integer> larger = new LinkedList<>();
        List<Integer> equal = new LinkedList<>();

        int pivotIndex = (int) (Math.random() * list.size());

        int pivot = list.get(pivotIndex);

        for (Integer integer : list) {
            if (integer < pivot) {
                less.add(integer);
            } else if (integer > pivot) {
                larger.add(integer);
            } else equal.add(integer);
        }
        if (k <= less.size()) return quickSelect(less, k);
        else if (k <= less.size() + equal.size()) return pivot;
        else return quickSelect(larger, k - less.size() - equal.size());
    }


}

