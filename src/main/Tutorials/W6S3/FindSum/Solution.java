package main.Tutorials.W6S3.FindSum;

class Solution {

    /**
     * Implement the method findSum(float[] arr, float x), that takes as input an array of random floats and returns the product of the 2 floats that sum to x.
     * <p>
     * The time complexity of the algorithm should be O(n). You may assume that the floats in the array arr are perfectly random.
     *
     * @param arr
     * @param x
     * @return
     */
    public static float findSum(float[] arr, float x) {
        Bucket bucket = new Bucket();

        for (float v : arr) {
            if (v <= x) {
                if (bucket.contains(x - v)) {
                    return (x - v) * v;
                }
                bucket.add(v);
            }
        }

        return -1;

    }
}
