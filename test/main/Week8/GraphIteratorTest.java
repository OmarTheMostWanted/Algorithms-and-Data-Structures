package main.Week8;


public class GraphIteratorTest {
//    @Test
//    public void testDoubleVertex() {
//        Resit.GraphImpl g = new Resit.GraphImpl();
//        Resit.Vertex v = new VertexImpl(0);
//        Vertex w = new VertexImpl(1);
//        g.addVertex(v);
//        g.addVertex(w);
//        g.addEdge(v, w);
//        Iterator<Vertex> it = new GraphIterator(g, v);
//        Assert.assertSame(v, it.next());
//        Assert.assertTrue(it.hasNext());
//        Assert.assertSame(w, it.next());
//        Assert.assertFalse(it.hasNext());
//    }
//
//    @Test
//    public void testSingleLoopingVertex() {
//        GraphImpl g = new GraphImpl();
//        Vertex v = new VertexImpl(0);
//        g.addVertex(v);
//        g.addEdge(v, v);
//        Iterator<Vertex> it = new GraphIterator(g, v);
//        Assert.assertTrue(it.hasNext());
//        Assert.assertSame(v, it.next());
//        Assert.assertFalse(it.hasNext());
//    }
//
//    @Test
//    public void testComplexGraph() {
//        GraphImpl g = new GraphImpl();
//        Vertex a = new VertexImpl(1);
//        Vertex b = new VertexImpl(2);
//        Vertex c = new VertexImpl(3);
//        Vertex d = new VertexImpl(5);
//        Vertex e = new VertexImpl(4);
//        Vertex f = new VertexImpl(6);
//        Vertex f1 = new VertexImpl(7);
//
//        g.addVertex(a);
//        g.addVertex(b);
//        g.addVertex(c);
//        g.addVertex(d);
//        g.addVertex(e);
//        g.addVertex(f);
//        g.addVertex(f1);
//
//        g.addEdge(a, b);
//        g.addEdge(b, c);
//        g.addEdge(c, d);
//        g.addEdge(b, e);
//        g.addEdge(c, f);
//        g.addEdge(e, f);
//        g.addEdge(f, f1);
//
//
//
//        Iterator<Vertex> it = new GraphIterator(g, a);
//        ArrayList<Vertex> vs = new ArrayList<>();
//        while(it.hasNext()){
//            vs.add(it.next());
//        }
//        System.out.println(vs.toString());
//        // System.out.println(vs.get(0) == a);
//        // System.out.println(vs.get(1) == b);
//        // System.out.println(vs.get(2) == c);
//        // System.out.println(vs.get(3) == d);
//    }
}