package main.code;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class SortingArraysTest {

    private int[] arr;
    private int[] res;
    private int[] random;
    private int[] randomRes;

    private int[] generateRandomArray(int size) {
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

    private void log(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    @BeforeEach
    public void initEach() {
        arr = new int[]{6, 5, 4, 3, 2, -1};
        res = new int[]{-1, 2, 3, 4, 5, 6};
        random = generateRandomArray(10);
        randomRes = Arrays.copyOf(random, random.length);
        Arrays.sort(randomRes);
    }

    @Test
    public void insertionSortTest() {

        SortingArrays.insertionSort(arr);
        Assert.assertArrayEquals(res, arr);

        SortingArrays.insertionSort(random);
        Assert.assertArrayEquals(randomRes, random);

    }
}