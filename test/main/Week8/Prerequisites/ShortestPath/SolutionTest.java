package main.Week8.Prerequisites.ShortestPath;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void testDoubleVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        Assert.assertEquals(2, Solution.shortestPath(g, v, w).size());
        Vertex[] va = {v, w};
        Assert.assertArrayEquals(va, Solution.shortestPath(g, v, w).toArray());
    }

    @Test
    public void testSingleLoopingVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        Assert.assertEquals(1, Solution.shortestPath(g, v, v).size());
    }
}