package main.Exam.Ex4;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;


class SolutionTest {

    @Test
    public void emptyVillage() {
        Set<Path> solution = Solution.relocateTheOwls(new ArrayList<>(), new HashSet<>());
        Assert.assertTrue("An empty village requires no flights to be made", solution.isEmpty());
    }

    @Test
    public void disconnectedVillage() {
        List<Map<Integer, Integer>> input = new ArrayList<>();
        input.add(new HashMap<>());
        input.add(new HashMap<>());
        Assert.assertNull("A disconnected village should give no solution", Solution.relocateTheOwls(input, new HashSet<>()));
    }

    /**
     * Village: https://i.imgur.com/BdvaXpV.png
     * Expected flight paths used: https://i.imgur.com/RS9poLa.png
     */
    @Test
    public void triangleTown() {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int x = 0; x < 6; x++) graph.add(new HashMap<>());
        graph.get(0).put(1, 1);
        graph.get(0).put(2, 1);
        graph.get(1).put(2, 2);
        graph.get(1).put(3, 3);
        graph.get(3).put(4, 2);
        graph.get(3).put(5, 1);
        graph.get(4).put(5, 1);
        Set<Path> solution = new HashSet<>();
        solution.add(new Path(0, 1, 1));
        solution.add(new Path(0, 2, 1));
        solution.add(new Path(1, 3, 3));
        solution.add(new Path(3, 5, 1));
        solution.add(new Path(4, 5, 1));
        Assert.assertEquals(solution, Solution.relocateTheOwls(graph, new HashSet<>()));
    }

    /**
     * Same graph as above, but now with 1 disallowed flight path
     */
    @Test
    public void triangleTownImpossible() {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int x = 0; x < 6; x++) graph.add(new HashMap<>());
        graph.get(0).put(1, 1);
        graph.get(0).put(2, 1);
        graph.get(1).put(2, 2);
        graph.get(1).put(3, 3);
        graph.get(3).put(4, 2);
        graph.get(3).put(5, 1);
        graph.get(4).put(5, 1);
        Set<Path> solution = new HashSet<>();
        solution.add(new Path(0, 2, 1));
        solution.add(new Path(1, 2, 2));
        solution.add(new Path(1, 3, 3));
        solution.add(new Path(3, 5, 1));
        solution.add(new Path(4, 5, 1));
        Set<Path> forbidden = new HashSet<>();
        forbidden.add(new Path(0, 1, 1));
        Assert.assertEquals(solution, Solution.relocateTheOwls(graph, forbidden));
    }

}