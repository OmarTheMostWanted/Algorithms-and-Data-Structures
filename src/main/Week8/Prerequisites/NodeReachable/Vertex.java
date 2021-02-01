package main.Week8.Prerequisites.NodeReachable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class Vertex {

    private int id;

    private Set<Vertex> neighbours;

    public Vertex(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<vertex: " + id + ">";
    }

    public Collection<Vertex> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vertex && ((Vertex) o).getId() == this.getId();
    }
}