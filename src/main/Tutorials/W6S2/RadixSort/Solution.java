package main.Tutorials.W6S2.RadixSort;

import java.util.LinkedList;
import java.util.List;

class Solution {
    /**
     * Sorts a list of words using MSD radix sort.
     *
     * @param words The list of words to sort.
     * @return The sorted list of words.
     * @throws NullPointerException If `words` equals `null`.
     */
    static List<String> radixSortMSD(List<String> words) {
        return radixSortMSD(words, 0);
    }

    @SuppressWarnings("unchecked")
    static List<String> radixSortMSD(List<String> words, int count) {

        if (words.size() <= 1) return words;

        LinkedList<String>[] buckets = new LinkedList[26];

        List<String> res = new LinkedList<>();

        boolean stop = true;

        for (String word : words) {
            if (word.length() > count) {
                if (buckets[(int) word.charAt(count) - 97] == null) {
                    buckets[(int) word.charAt(count) - 97] = new LinkedList<>();
                }
                buckets[(int) word.charAt(count) - 97].add(word);
                stop = false;
            } else res.add(word);
        }
        for (LinkedList<String> bucket : buckets) {
            if (bucket != null && !stop) {
                res.addAll(radixSortMSD(bucket, count + 1));
            } else if (bucket != null) {
                res.addAll(bucket);
            }
        }
        return res;
    }

}