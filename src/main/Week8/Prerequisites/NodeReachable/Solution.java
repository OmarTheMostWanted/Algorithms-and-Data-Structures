package main.Week8.Prerequisites.NodeReachable;

import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * Checks if vertex b is reachable from vertex a.
     *
     * @param a Vertex to start from.
     * @param b Vertex to reach.
     * @return true if vertex b is reachable.
     */
    public static boolean solve(Vertex a, Vertex b) {
        return solve(a, b, new HashSet<Vertex>());
    }

    private static boolean solve(Vertex a, Vertex b, Set<Vertex> known) {

        if (a.equals(b)) return true;

        known.add(a);

        for (Vertex neighbour : a.getNeighbours()) {
            if (!known.contains(neighbour)) {
                return solve(neighbour, b, known);
            }
        }

        return false;

    }
}

