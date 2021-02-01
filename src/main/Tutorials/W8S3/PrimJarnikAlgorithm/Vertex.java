package main.Tutorials.W8S3.PrimJarnikAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class Vertex implements Comparable<Vertex> {

    private int id;

    private Set<VertexNumPair> neighbours;

    public Vertex(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void addNeighbour(Vertex v, int weight) {
        neighbours.add(new VertexNumPair(v, weight));
    }

    @Override
    public String toString() {
        return "<vertex: " + id + ">";
    }

    public Collection<VertexNumPair> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public int compareTo(Vertex o) {
        return this.getId() - o.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vertex && ((Vertex) o).getId() == this.getId();
    }
}
