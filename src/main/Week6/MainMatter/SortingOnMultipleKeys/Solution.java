package main.Week6.MainMatter.SortingOnMultipleKeys;

import java.util.Arrays;

class Solution {
    public static void stableSort(String[][] table, int column) {
        if (table != null) {
            String[][] res = mergeSort(table, column);
            for (int i = 0; i < res.length; i++) {
                table[i] = res[i];
            }
        }
    }

    private static String[][] mergeSort(String[][] table, int column) {
        if (table.length < 2) return table;

        String[][] left;
        String[][] right;

        left = Arrays.copyOfRange(table, 0, table.length / 2);
        right = Arrays.copyOfRange(table, table.length / 2, table.length);

        /*
        for (int i = 0; i < table.length / 2; i++) {
            for (int j = 0; j < table[i].length; j++) {
                left[i][j] = table[i][j];
            }
        }

        for (int i = table.length / 2; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                right[i][j] = table[i][j];
            }
        }
        */
        return merge(mergeSort(left, column), mergeSort(right, column), column);

    }

    private static String[][] merge(String[][] left, String[][] right, int column) {

        String[][] res = new String[left.length + right.length][left[0].length];

        int p = 0;
        int l = 0;
        int r = 0;

        while (l < left.length && r < right.length) {

            if (left[l][column].compareTo(right[r][column]) < 0) {
                res[p] = left[l];
                p++;
                l++;
            } else {
                res[p] = right[r];
                p++;
                r++;
            }
        }

        while (l < left.length) {
            res[p] = left[l];
            p++;
            l++;
        }

        while (r < right.length) {
            res[p] = right[r];
            p++;
            r++;
        }

        return res;

    }
}
