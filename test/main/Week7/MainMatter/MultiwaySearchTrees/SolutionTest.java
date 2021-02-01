package main.Week7.MainMatter.MultiwaySearchTrees;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    private MultiwaySearchTree makeLeafNode(int value) {
        int[] child2Value = new int[1];
        child2Value[0] = value;
        MultiwaySearchTree[] child2Children = new MultiwaySearchTree[2];
        return new MultiwaySearchTree(child2Value, child2Children);
    }

    @Test
    public void testExample() {
        int[] rootValue = new int[1];
        rootValue[0] = 4;
        MultiwaySearchTree[] rootChildren = new MultiwaySearchTree[2];
        MultiwaySearchTree tree = new MultiwaySearchTree(rootValue, rootChildren);
        assertTrue(Solution.isSpecialTree(tree));
        rootChildren[0] = makeLeafNode(2);
        rootChildren[1] = makeLeafNode(6);
        assertTrue(Solution.isSpecialTree(tree));
    }

    @Test
    public void testExample2() {
        int[] rootValue = new int[1];
        rootValue[0] = 4;
        MultiwaySearchTree[] rootChildren = new MultiwaySearchTree[2];
        rootChildren[0] = makeLeafNode(2);
        rootChildren[1] = makeLeafNode(3);
        MultiwaySearchTree tree = new MultiwaySearchTree(rootValue, rootChildren);
        Assert.assertFalse(Solution.isSpecialTree(tree));
        Assert.assertTrue(Solution.satisfiesCondition1(tree));
        Assert.assertTrue(Solution.satisfiesCondition2(tree));
        Assert.assertTrue(Solution.satisfiesCondition3(tree));
        Assert.assertFalse(Solution.satisfiesCondition4(tree));
    }
}