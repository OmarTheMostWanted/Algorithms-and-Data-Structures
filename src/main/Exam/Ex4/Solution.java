package main.Exam.Ex4;

import java.util.*;

class Solution {


    /**
     * @param village       Adjacency map representation of the town.
     * @param tooManyCoatis The paths that contain too many coatis.
     * @return The paths the messenger owls should take.
     */
    public static Set<Path> relocateTheOwls(List<Map<Integer, Integer>> village, Set<Path> tooManyCoatis) {

        List<Path> paths = new LinkedList<>();

        for (int i = 0; i < village.size(); i++) {
            Path p;
            for (Map.Entry<Integer, Integer> e : village.get(i).entrySet()) {
                p = new Path(i, e.getKey(), e.getValue());
                if (!tooManyCoatis.contains(p)) {

                    paths.add(p);
                }
            }

        }

        Set<Path> res = buildMST(village.size(), paths, new TreeSet<>());

        return res;

    }

    /**
     * Builds a Minimum Spanning Tree (MST) using
     * Kruskal's Algorithm (as learned in class).
     * Nodes are numbered from 0 to n - 1.
     *
     * @param n     the amount of nodes in the graph
     * @param edges the edges that comprise the graph
     * @return the list of edges that should be included in the MST
     */
    public static Set<Path> buildMST(int n, List<Path> edges, Set<Integer> added) {
        UnionFind unionFind = new UnionFind(n);
        PriorityQueue<Path> priorityQueue = new PriorityQueue<>(edges);
        Set<Path> list = new TreeSet<>();
        while (list.size() < n - 1 && !priorityQueue.isEmpty()) {
            Path e = priorityQueue.poll();
            if (unionFind.union(e.getFrom(), e.getTo())) {
                added.add(e.getFrom());
                added.add(e.getTo());
                list.add(e);
            }
        }
        return added.size() == n ? list : null;
    }

}
