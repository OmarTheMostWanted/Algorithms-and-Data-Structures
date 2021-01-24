package main.Tutorials.W6S3.FindSum;

import java.util.LinkedList;

class Bucket {

    private LinkedList<Float> list;

    public Bucket() {
        list = new LinkedList<>();
    }

    void add(float f) {
        list.add(f);
    }

    boolean contains(float f) {
        return list.contains(f);
    }
}
