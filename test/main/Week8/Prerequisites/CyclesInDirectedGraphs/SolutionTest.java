package main.Week8.Prerequisites.CyclesInDirectedGraphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    /**
     * Graph: https://i.imgur.com/ty3flio.png
     */
    @Test
    public void testNoCycle() {
        Node[] nodes = new Node[4];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new Node(i);
        nodes[0].outgoingEdges.add(nodes[1]);
        nodes[0].outgoingEdges.add(nodes[2]);
        nodes[2].outgoingEdges.add(nodes[3]);
        nodes[3].outgoingEdges.add(nodes[1]);

        assertFalse(Solution.detectCycle(nodes[0], Arrays.asList(nodes.clone())));
    }

    /**
     * Graph: https://i.imgur.com/IuPAZTV.png
     */
    @Test
    public void testCycle() {
        Node[] nodes = new Node[5];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new Node(i);

        nodes[0].outgoingEdges.add(nodes[1]);
        nodes[0].outgoingEdges.add(nodes[2]);
        nodes[1].outgoingEdges.add(nodes[3]);
        nodes[2].outgoingEdges.add(nodes[3]);
        nodes[3].outgoingEdges.add(nodes[4]);
        nodes[4].outgoingEdges.add(nodes[2]);

        assertTrue(Solution.detectCycle(nodes[0], Arrays.asList(nodes.clone())));
    }
}