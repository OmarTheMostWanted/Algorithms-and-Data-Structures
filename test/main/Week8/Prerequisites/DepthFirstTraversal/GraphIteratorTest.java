package main.Week8.Prerequisites.DepthFirstTraversal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

class GraphIteratorTest {

    @Test
    public void testDoubleVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        Vertex w = new VertexImpl(1);
        g.addVertex(v);
        g.addVertex(w);
        g.addEdge(v, w);
        Iterator<Vertex> it = new GraphIterator(g, v);
        Assert.assertSame(v, it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertSame(w, it.next());
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void testSingleLoopingVertex() {
        GraphImpl g = new GraphImpl();
        Vertex v = new VertexImpl(0);
        g.addVertex(v);
        g.addEdge(v, v);
        Iterator<Vertex> it = new GraphIterator(g, v);
        Assert.assertTrue(it.hasNext());
        Assert.assertSame(v, it.next());
        Assert.assertFalse(it.hasNext());
    }

}