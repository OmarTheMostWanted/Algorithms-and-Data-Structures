package main.Tutorials.W8S3.PrimJarnikAlgorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void small1Example() {
        Graph g = new Graph(1);
        Graph mst = new Graph(1);
        assertEquals(mst, Solution.primJarnik(g));
    }

    @Test
    public void small3Example() {
        Graph g = new Graph(3);
        g.addEdge(g.getVertex(0), g.getVertex(1), 1);
        g.addEdge(g.getVertex(0), g.getVertex(2), 2);
        g.addEdge(g.getVertex(1), g.getVertex(2), 1);
        Graph mst = new Graph(3);
        mst.addEdge(mst.getVertex(0), mst.getVertex(1), 1);
        mst.addEdge(mst.getVertex(1), mst.getVertex(2), 1);
        assertEquals(mst, Solution.primJarnik(g));
    }
}