package main.Week8.MainMatter.ShortestPath;

/**
 * Container class used to store a Vertex and an int.
 */
class VertexNumPair {

    private Vertex vertex;

    private int num;

    public VertexNumPair(Vertex vertex, int num) {
        this.vertex = vertex;
        this.num = num;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public int getNum() {
        return num;
    }
}