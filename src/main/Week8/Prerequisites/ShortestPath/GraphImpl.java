package main.Week8.Prerequisites.ShortestPath;

import java.util.*;

class GraphImpl implements Graph {
    private Map<Integer, Vertex> vertices;

    public GraphImpl() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        this.vertices.put(v.getId(), v);
    }

    @Override
    public Collection<Vertex> getAllVertices() {
        return this.vertices.values();
    }

    @Override
    public List<Vertex> getNeighbours(Vertex v) {
        List<Vertex> neigh = new ArrayList<>(((VertexImpl) v).getNeighbours());
        Collections.sort(neigh);
        return neigh;
    }

    public void addEdge(Vertex v, Vertex w) {
        VertexImpl realV = (VertexImpl) v;
        VertexImpl realW = (VertexImpl) w;
        realV.addNeighbour(w);
        realW.addNeighbour(v);
    }
}