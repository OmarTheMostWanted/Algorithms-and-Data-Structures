package main.Week8.MainMatter.KruskalsAlgorithm;

class UnionFind {

    private int[] parent;

    private int[] rank;

    // Union Find structure implemented with two arrays for Union by Rank
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
    }

    /**
     * Merge two clusters, if they are not already part of the same cluster.
     *
     * @param i a node in the first cluster
     * @param j a node in the second cluster
     * @return true iff i and j had different clusters.
     */
    boolean union(int i, int j) {
        int parent1 = find(i);
        int parent2 = find(j);
        if (parent2 == parent1)
            return false;
        if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        } else if (rank[parent2] > rank[parent1]) {
            parent[parent1] = parent2;
        } else {
            parent[parent2] = parent1;
            rank[parent1]++;
        }
        return true;
    }

    /**
     * NB: this function should also do path compression
     *
     * @param i index of a node
     * @return the root of the subtree containg i.
     */
    int find(int i) {
        int parent = this.parent[i];
        if (i == parent) {
            return i;
        }
        return this.parent[i] = find(parent);
    }

    // Return the rank of the trees
    public int[] getRank() {
        return rank;
    }

    // Return the parent of the trees
    public int[] getParent() {
        return parent;
    }
}
