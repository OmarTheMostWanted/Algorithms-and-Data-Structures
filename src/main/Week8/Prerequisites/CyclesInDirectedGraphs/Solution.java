package main.Week8.Prerequisites.CyclesInDirectedGraphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {

    /**
     * Detects cycles in a connected component.
     *
     * @param s     starting node in our connected component.
     * @param nodes the nodes that belong to our graph.
     * @return true iff there is a cycle in the connected component the source belongs to.
     */
    public static boolean detectCycle(Node s, List<Node> nodes) {

        Set<Node> visited = new HashSet<>();

        for (Node node : nodes) { // if the graph had more than one connected component
            if (!visited.contains(node)) {
                if (detectCycle(node, nodes, visited, new Stack<>())) return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(Node s, List<Node> nodes, Set<Node> known, Stack<Node> stack) {
        known.add(s);
        stack.push(s);
        for (Node outgoingEdge : s.getOutgoingEdges()) {
            if (!known.contains(outgoingEdge)) return detectCycle(outgoingEdge, nodes, known, stack);
            if (stack.contains(outgoingEdge)) return true;
        }
        stack.pop();
        return false;
    }
}
