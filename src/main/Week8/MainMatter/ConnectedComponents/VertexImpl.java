package main.Week8.MainMatter.ConnectedComponents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class VertexImpl implements Vertex {
    private int id;
    private Set<Vertex> neighbours;

    public VertexImpl(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<Node: " + id + ">";
    }

    @Override
    public int getId() {
        return id;
    }

    public Collection<Vertex> getNeighbours() {
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
