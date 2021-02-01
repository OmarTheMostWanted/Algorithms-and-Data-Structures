package main.Exam.Ex4;

class UnionFind {

    private int[] parent;

    private int[] rank;

    /**
     * Union Find structure implemented with two arrays for Union by Rank.
     *
     * @param size Size of the UF structure.
     */
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
    }

    /**
     * Merges two clusters, if they are not already part of the same cluster.
     *
     * @param i Node in the first cluster
     * @param j Node in the second cluster
     * @return True iff the merge was successful.
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
     * @param i Index of a node
     * @return The root of the subtree containing i.
     */
    int find(int i) {
        int parent = this.parent[i];
        if (i == parent) {
            return i;
        }
        return this.parent[i] = find(parent);
    }

    /**
     * @return The ranks of the trees.
     */
    public int[] getRank() {
        return rank;
    }

    /**
     * @return The parents of the trees
     */
    public int[] getParent() {
        return parent;
    }
}