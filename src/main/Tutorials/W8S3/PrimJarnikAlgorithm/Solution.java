package main.Tutorials.W8S3.PrimJarnikAlgorithm;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static Graph primJarnik(Graph g) {
        Set<Vertex> visited = new HashSet<>();

        Graph res = new Graph(g.getAllVertices().size());

        AdaptablePQ pq = new AdaptablePQ();

        for (Vertex allVertex : g.getAllVertices()) {

            visited.add(allVertex);

            for (VertexNumPair neighbour : g.getNeighbours(allVertex)) {
                pq.insertOrReplace(neighbour.getVertex(), neighbour.getNum());
            }

            while (!pq.isEmpty()) {
                VertexNumPair v = pq.removeMin();
                if (!visited.contains(v.getVertex())) {
                    visited.add(v.getVertex());
                    res.addEdge(allVertex.getId(), v.getVertex().getId(), v.getNum());

                    for (VertexNumPair neighbour : g.getNeighbours(v.getVertex())) {

                        if (!visited.contains(neighbour.getVertex()))
                            pq.insertOrReplace(neighbour.getVertex(), neighbour.getNum());
                    }

                }
            }

        }

        return res;


    }
}