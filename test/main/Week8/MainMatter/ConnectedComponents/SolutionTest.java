package main.Week8.MainMatter.ConnectedComponents;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void testSingleLoopingVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        Assert.assertEquals(1, Solution.numberOfConnectedComponents(g));
    }

    @Test
    public void testNotPossibleGraph() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex z = new VertexImpl(3);
        g.addVertex(v);
        g.addVertex(z);
        Assert.assertEquals(2, Solution.numberOfConnectedComponents(g));
    }
}