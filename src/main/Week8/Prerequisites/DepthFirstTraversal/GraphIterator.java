package main.Week8.Prerequisites.DepthFirstTraversal;

import java.util.*;

/**
 * Implements a Depth first traversal of the Graph, starting at contructor vertex v. It
 * should return nodes at most once. If there is a choice between multiple next nodes,
 * always pick the lowest id node.
 */
class GraphIterator implements Iterator<Vertex> {
    private Graph g;
    private Vertex v;
    private Stack<Vertex> stack;
    private Set<Vertex> colored;
    private int graphSize;

    public GraphIterator(Graph g, Vertex v) {
        this.g = g;
        this.v = v;
        stack = new Stack<>();
        colored = new TreeSet<>();
        graphSize = g.getAllVertices().size();
    }

    @Override
    public boolean hasNext() {
        return v != null && colored.size() < graphSize;
    }

    @Override
    public Vertex next() {

        if (!hasNext()) return null;


        Vertex next = v;

        colored.add(v);

        List<Vertex> neighbours = new LinkedList<>(g.getNeighbours(v));

        neighbours.sort(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {

                return Integer.compare(o2.getId(), o1.getId());

            }
        });

        for (Vertex neighbour : neighbours) {
            if (!colored.contains(neighbour)) {
                stack.push(neighbour);
            }
        }

        if (!stack.isEmpty()) v = stack.pop();
        else v = null;

        return next;

    }
}