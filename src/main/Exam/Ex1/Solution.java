package main.Exam.Ex1;

import java.util.LinkedList;
import java.util.List;

class Solution {

    /**
     * Sorts the list of doctor IDs as defined in the description.
     *
     * @param doctorIds - list of doctor IDs
     * @return sorted list of doctor IDs
     */
    static List<String> sortDoctorIds(List<String> doctorIds) {


        if (doctorIds == null) return null;

        List<String> sortedOnStrings = radixSortMSD(doctorIds, 0);

        return sortedOnStrings;


    }

    @SuppressWarnings("unchecked")
    static List<String> radixSortMSD(List<String> words, int count) {


        if (words.size() <= 1) return words;

        LinkedList<String>[] buckets = new LinkedList[26];

        List<String> res = new LinkedList<>();

        boolean stop = true;

        for (String word : words) {
            if (word.length() > count && count != 2 && count != 4) {
                if (buckets[25 - ((int) word.charAt(count) - 65)] == null) {
                    buckets[25 - ((int) word.charAt(count) - 65)] = new LinkedList<>();
                }
                buckets[25 - ((int) word.charAt(count) - 65)].add(word);
                stop = false;
            } else res.add(word);
        }
        for (LinkedList<String> bucket : buckets) {
            if (bucket != null && !stop) {

                if (count + 1 != 2 && count + 1 != 4) res.addAll(radixSortMSD(bucket, count + 1));
                else res.addAll(sortOnNumbers(bucket, count + 1));

            } else if (bucket != null) {
                if (count + 1 != 2 && count + 1 != 4) res.addAll(radixSortMSD(bucket, count + 1));
                else res.addAll(sortOnNumbers(bucket, count + 1));
            }
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    static List<String> sortOnNumbers(List<String> words, int count) {


        if (count != 2 && count != 4) return words;


        if (words.size() <= 1) return words;

        LinkedList<String>[] buckets = new LinkedList[10];

        List<String> res = new LinkedList<>();

        boolean stop = true;

        for (String word : words) {
            if (word.length() > count && count == 2 || count == 4) {
                if (buckets[(Integer.parseInt(word.charAt(count) + ""))] == null) {
                    buckets[(Integer.parseInt(word.charAt(count) + ""))] = new LinkedList<>();
                }
                buckets[(Integer.parseInt(word.charAt(count) + ""))].add(word);
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
