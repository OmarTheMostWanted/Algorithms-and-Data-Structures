package main.Tutorials.W3S2;

public class ArithmeticTree {

    /**
     * Evaluates the arithmetic expression stored in this binary tree.
     *
     * @param node
     * @return
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("rawtypes")
    public static int eval(Node node) throws IllegalArgumentException {
        if (node.isLeaf()) return (int) node.getVal();
        return switch ((String) node.getVal()) {
            case "+" -> eval(((InternalNode) node).getLeft()) + eval(((InternalNode) node).getRight());
            case "-" -> eval(((InternalNode) node).getLeft()) - eval(((InternalNode) node).getRight());
            case "*" -> eval(((InternalNode) node).getLeft()) * eval(((InternalNode) node).getRight());
            case "/" -> eval(((InternalNode) node).getLeft()) / eval(((InternalNode) node).getRight());
            default -> throw new IllegalArgumentException();
        };
    }
}

abstract class Node<T> {
    protected T val;

    public T getVal() {
        return val;
    }

    public void setVal(T v) {
        val = v;
    }

    public abstract boolean isLeaf();
}

/**
 * Internal Node that stores an operator represented as a string
 */
@SuppressWarnings("rawtypes")
class InternalNode extends Node<String> {
    public Node left;
    public Node right;

    public InternalNode(String operator, Node left, Node right) {
        this.val = operator;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return false;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}

/**
 * Leaf Node that stores an operand represented as an integer
 */
class LeafNode extends Node<Integer> {
    public LeafNode(int constant) {
        this.val = constant;
    }

    public boolean isLeaf() {
        return true;
    }
}