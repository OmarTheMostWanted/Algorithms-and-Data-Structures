package main.Week8.MainMatter.ConnectedComponents;

import java.util.*;

/**
 * Implements a Depth first traversal of the Graph, starting at the smallest id. It
 * should return nodes at most once. If there is a choice between next nodes,
 * always pick the lowest id node.
 */
class GraphIterator implements Iterator<Vertex> {
    private Graph g;
    private Stack<Vertex> stack;
    private Set<Vertex> colored;
    private int graphSize;
    private Vertex v;

    public GraphIterator(Graph g, Vertex v) {
        this.g = g;
        this.v = v;
        this.reset();
    }

    public void reset() {
        this.stack = new Stack<>();
        this.colored = new TreeSet<>();
        if (g != null && v != null) {
            graphSize = g.getAllVertices().size();
            this.stack.add(v);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty() && graphSize != colored.size();
    }

    @Override
    public Vertex next() {
        if (this.stack.isEmpty() || graphSize == colored.size()) {
            return null;
        }
        Vertex u = stack.pop();
        colored.add(u);
        List<Vertex> neigh = g.getNeighbours(u);
        Collections.reverse(neigh);
        for (Vertex n : neigh) {
            if (!colored.contains(n)) {
                stack.add(n);
            }
        }
        return u;
    }

    @Override
    public void remove() {
        // Can be ignored.
    }
}