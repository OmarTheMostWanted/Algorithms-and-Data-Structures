package main.code.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree<T> {

    T value;
    List<Tree<T>> children;

    public Tree(T value, ArrayList<Tree<T>> children) {
        this.value = value;
        this.children = children;
    }

    public Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }


    /**
     * Creates a hard copy of the n-ary tree.
     *
     * @param t - the tree to create a copy of
     * @return a new tree in which every node contains the values of the nodes at the corresponding positions in t
     */
    public Tree<T> copy() {
        return copy(this);
    }

    private Tree<T> copy(Tree<T> t) {
        if (t == null) return null;
        Tree<T> res = new Tree<>(t.value);
        for (Tree<T> c : t.children) {
            res.children.add(copy(c));
        }
        return res;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof Tree<?>) {
            if (((Tree<?>) other).value.equals(this.value)) {
//                for (Object o : ((Tree<?>) other).children) {
//                    return equals(o);
//                }
                return this.children.equals(((Tree<?>) other).children);
            } else return false;
        } else return false;
    }


    /**
     * Returns a human readable format of this tree.
     *
     * @return A string representation of this tree.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.toString(sb, 0);
        return sb.toString();
    }

    /**
     * Returns a human readable format of this tree.
     *
     * @param sb    StringBuilder to append to.
     * @param depth Identation depth of this part.
     */
    private void toString(StringBuilder sb, int depth) {
        for (int i = 0; i < depth; i++) sb.append("  ");
        sb.append("<Tree ").append(this.value.toString()).append(" [");

        if (this.children.isEmpty()) {
            sb.append("]>");
            return;
        }
        // Recursively add children
        for (Tree<T> t : this.children) {
            sb.append("\n");
            for (int i = 0; i < depth; i++) sb.append("  ");
            t.toString(sb, depth + 1);
        }
        sb.append("\n");
        for (int i = 0; i < depth; i++) sb.append("  ");
        sb.append("]>");
    }


    public void preOrder(List<T> list) {
        preOrder(this, list);
    }

    private void preOrder(Tree<T> tree, List<T> list) {
        if (list == null) return;
        list.add(tree.value);
        for (Tree<T> t : tree.children)
            preOrder(t, list);
    }

    public void postOrder(List<T> list) {
        postOrder(this, list);
    }

    private void postOrder(Tree<T> tree, List<T> list) {
        if (list == null) return;
        for (Tree<T> t : tree.children)
            postOrder(t, list);
        list.add(tree.value);
    }

    public void breadthFirst(List<T> list) {
        breadthFirst(this, list);
    }

    private void breadthFirst(Tree<T> tree, List<T> list) {
        if (list == null) return;
        Queue<Tree<T>> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Tree<T> t = queue.poll();
            list.add(t.value);
            queue.addAll(t.children);
        }
    }
}
