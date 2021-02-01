package main.Week8.MainMatter.ShortestPath;

import java.util.*;

class Solution {

    /**
     * Returns the list of vertices along the shortest path between vertex a and b in graph g.
     *
     * @param g Graph to consider.
     * @param a Vertex to start from.
     * @param b Vertex to go to.
     * @return The list of vertices along the shortest path between a and b, or null if no such path exists.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex a, Vertex b) {

        Map<Vertex, VertexNumPair> pathFromA = new HashMap<>();

        Set<Vertex> visited = new HashSet<>();
        AdaptablePQ adaptablePQ = new AdaptablePQ();

        LinkedList<Vertex> res = new LinkedList<>();

        adaptablePQ.insertOrReplace(a, 0);

        while (!adaptablePQ.isEmpty()) {

            VertexNumPair v = adaptablePQ.removeMin();

            visited.add(v.getVertex());

            for (VertexNumPair n : g.getNeighbours(v.getVertex())) {

                if (!visited.contains(n.getVertex())) {
                    adaptablePQ.insertOrReplace(n.getVertex(), v.getNum() + n.getNum());
                }
                //relax if need
                if (pathFromA.containsKey(n.getVertex())) {
                    if (pathFromA.get(n.getVertex()).getNum() > v.getNum() + n.getNum()) {
                        pathFromA.put(n.getVertex(), new VertexNumPair(v.getVertex(), v.getNum() + n.getNum()));
                    }
                } else pathFromA.put(n.getVertex(), new VertexNumPair(v.getVertex(), v.getNum() + n.getNum()));
            }
        }
        if (!pathFromA.containsKey(b)) return null;
        Vertex path = b;
        while (a != path) {
            res.addFirst(path);
            path = pathFromA.get(path).getVertex();
        }
        res.addFirst(a);

        return res;
    }


}
