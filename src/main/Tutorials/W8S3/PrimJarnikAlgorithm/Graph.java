package main.Tutorials.W8S3.PrimJarnikAlgorithm;

import java.util.*;

class Graph {

    private Map<Integer, Vertex> vertices = new HashMap<>();

    /**
     * Creates a new graph with n vertices.
     *
     * @param n Amount of vertices in the graph.
     */
    public Graph(int n) {
        for (int i = 0; i < n; i++) vertices.put(i, new Vertex(i));
    }

    /**
     * Returns the vertex with the given ID.
     *
     * @param id The ID for the vertex to get.
     * @return The vertex with the given ID.
     * @throws IllegalArgumentException if no vertex with the given ID is in the graph.
     */
    public Vertex getVertex(int id) throws IllegalArgumentException {
        if (!vertices.containsKey(id))
            throw new IllegalArgumentException("Vertex not in graph");
        return vertices.get(id);
    }

    public Collection<Vertex> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    /**
     * Returns all neighbours of the given vertex sorted by their ID.
     *
     * @param v The vertex to get the neighbours from.
     * @return A sorted list of all neighbouring vertices.
     */
    public List<VertexNumPair> getNeighbours(Vertex v) {
        List<VertexNumPair> neighbours = new ArrayList<>(v.getNeighbours());
        neighbours.sort(Comparator.comparingInt(a -> a.getVertex().getId()));
        return neighbours;
    }

    /**
     * Adds an edge between vertex u and v with the given weight.
     *
     * @param u      First vertex.
     * @param v      Second vertex.
     * @param weight Weight of the edge between a and b.
     */
    public void addEdge(Vertex u, Vertex v, int weight) {
        u.addNeighbour(v, weight);
        v.addNeighbour(u, weight);
    }

    /**
     * Adds an edge between the vertices with IDs u and v with the given weight.
     *
     * @param u      ID of the first vertex.
     * @param v      ID of the second vertex.
     * @param weight Weight of the edge between a and b.
     * @throws IllegalArgumentException if no vertex with the given ID is in the graph.
     */
    public void addEdge(int u, int v, int weight) throws IllegalArgumentException {
        addEdge(getVertex(u), getVertex(v), weight);
    }

    @Override
    public String toString() {
        String ret = "V: {";
        for (Vertex v : getAllVertices()) {
            ret += v.getId() + ",";
        }
        ret += "}\r\nE: {";
        for (Vertex v : getAllVertices()) {
            for (VertexNumPair vnp : v.getNeighbours()) {
                ret += "(" + v.getId() + "," + vnp.getVertex().getId() + "),";
            }
        }
        ret += "}";
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != getClass()) {
            return false;
        }
        Graph g = (Graph) o;
        ArrayList<Vertex> thisVertices = (ArrayList<Vertex>) getAllVertices();
        ArrayList<Vertex> otherVertices = (ArrayList<Vertex>) g.getAllVertices();
        if (thisVertices.size() == otherVertices.size()) {
            for (int i = 0; i < thisVertices.size(); i++) {
                if (getNeighbours(thisVertices.get(i)).size() == getNeighbours(otherVertices.get(i)).size()) {
                    for (int j = 0; j < getNeighbours(thisVertices.get(i)).size(); j++) {
                        if (getNeighbours(thisVertices.get(i)).get(j).getVertex().getId() != g.getNeighbours(otherVertices.get(i)).get(j).getVertex().getId()) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
