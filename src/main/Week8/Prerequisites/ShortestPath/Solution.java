package main.Week8.Prerequisites.ShortestPath;

import java.util.*;

class Solution {
    /**
     * Find the shortest path between v and u in the graph g.
     *
     * @param g graph to search in.
     * @param v node to start from.
     * @param u node to reach.
     * @return the nodes you that form the shortest path, including v and u. An
     * empty list iff there is no path between v and u.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex v, Vertex u) {

        Map<Vertex, Vertex> predecessors = new TreeMap<>();
        GraphIterator it = new GraphIterator(g, v);

        it.forEachRemaining(w -> {
            for (Vertex neighbour : g.getNeighbours(w)) {
                if (!predecessors.containsKey(neighbour)) {
                    predecessors.put(neighbour, w);
                }

            }
        });

        if (!predecessors.containsKey(v)) {
            return new ArrayList<>();
        }

        LinkedList<Vertex> list = new LinkedList<>();
        Vertex cursor = u;

        while (cursor != v) {
            list.addFirst(cursor);
            cursor = predecessors.get(cursor);
        }

        list.addFirst(v);

        return list;
    }

}
