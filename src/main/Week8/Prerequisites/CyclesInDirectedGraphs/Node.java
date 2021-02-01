package main.Week8.Prerequisites.CyclesInDirectedGraphs;

import java.util.ArrayList;
import java.util.List;

class Node {

    List<Node> outgoingEdges;

    int id;

    public Node(int id) {
        this.outgoingEdges = new ArrayList<>();
        this.id = id;
    }

    public List<Node> getOutgoingEdges() {
        return outgoingEdges;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return Integer.toString(id);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
