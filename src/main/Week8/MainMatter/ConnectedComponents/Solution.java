package main.Week8.MainMatter.ConnectedComponents;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int numberOfConnectedComponents(Graph g) {

        if (g.getAllVertices().size() == 0) return 0;
        if (g.getAllVertices().size() == 1) return 1;


        return numberOfConnectedComponents(g, new HashSet<>(), 0);
    }

    private static int numberOfConnectedComponents(Graph g, Set<Vertex> known, int num) {


        while (g.getAllVertices().size() != known.size()) {
            num++;

            Vertex start = null;
            if (g.getAllVertices().size() > 1) {
                for (Vertex v : g.getAllVertices()) {
                    if (!known.contains(v)) {
                        start = v;
                        break;
                    }
                }

                if (start != null) {
                    new GraphIterator(g, start).forEachRemaining(w -> {
                        if (!known.contains(w)) known.add(w);
                    });
                }
            }
        }
        return num;
    }


}
