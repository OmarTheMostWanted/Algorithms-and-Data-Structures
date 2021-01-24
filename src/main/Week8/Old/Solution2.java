package main.Week8.Old;

import java.util.Collection;

public class Solution2 {
    public static int numberOfConnectedComponents(Graph g) {
        Collection<Vertex> unexplored = g.getAllVertices();

        int count = 0;
        while (!unexplored.isEmpty()) {
            Vertex vertex = unexplored.iterator().next();
            new GraphIterator(g, vertex).forEachRemaining(unexplored::remove); // unexplored::remove == (v) -> unexplored.remove(v)

            count++;
        }

        return count;
    }
}
