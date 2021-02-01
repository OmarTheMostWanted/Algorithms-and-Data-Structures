package main.Week8.Prerequisites.ShortestPath;

import java.util.Collection;
import java.util.List;

/**
 * Interface for a generic graph. You may assume that our implementation is an
 * undirected graph.
 */
interface Graph {
    /**
     * Returns the neighbours in a sorted collection by id
     *
     * @param v node to get the neighbours of.
     * @return sorted collection of neighbours.
     */
    List<Vertex> getNeighbours(Vertex v);

    /**
     * @return an unsorted collection of all vertices in the graph.
     */
    Collection<Vertex> getAllVertices();
}
