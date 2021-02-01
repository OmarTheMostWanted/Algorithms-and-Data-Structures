package main.Week7.MainMatter.MultiwaySearchTrees;


import java.util.Arrays;

class MultiwaySearchTree {

    int[] keys;

    MultiwaySearchTree[] children;

    public MultiwaySearchTree(int[] keys, MultiwaySearchTree[] children) {
        this.keys = keys;
        this.children = children;
    }

    public int[] getKeys() {
        return keys;
    }

    public MultiwaySearchTree[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "MultiwaySearchTree{" + "keys=" + Arrays.toString(keys) + '}';
    }
}
