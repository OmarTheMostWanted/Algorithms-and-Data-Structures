package main.Week8.MainMatter.KruskalsAlgorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    /**
     * Builds a Minimum Spanning Tree (MST) using
     * Kruskal's Algorithm (as learned in class).
     * Nodes are numbered from 0 to n - 1.
     *
     * @param n     the amount of nodes in the graph
     * @param edges the edges that comprise the graph
     * @return the list of edges that should be included in the MST
     */
    public static List<Edge> buildMST(int n, List<Edge> edges) {
        UnionFind unionFind = new UnionFind(n);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(edges);
        List<Edge> list = new LinkedList<>();
        while (list.size() < n - 1 && !priorityQueue.isEmpty()) {
            Edge e = priorityQueue.poll();
            if (unionFind.union(e.getFrom(), e.getTo())) {
                list.add(e);
            }
        }
        return list;
    }
}
