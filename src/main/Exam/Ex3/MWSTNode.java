package main.Exam.Ex3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class MWSTNode {

    private List<Integer> keys;

    private MWSTNode parent;

    private LinkedList<MWSTNode> children;

    public MWSTNode(List<Integer> keys, MWSTNode parent, LinkedList<MWSTNode> children) {
        this.keys = keys;
        this.parent = parent;
        // If children is left as null, create a list of m + 1 nulls, where m is the number of keys
        if (children == null) {
            this.children = new LinkedList<>(Collections.nCopies(keys.size(), null));
        } else {
            this.children = children;
        }
    }

    public List<Integer> getKeys() {
        return keys;
    }

    public void setKeys(List<Integer> keys) {
        this.keys = keys;
    }

    public MWSTNode getParent() {
        return parent;
    }

    public void setParent(MWSTNode parent) {
        this.parent = parent;
    }

    public LinkedList<MWSTNode> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<MWSTNode> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MWSTNode mwstNode = (MWSTNode) o;
        return Objects.equals(keys, mwstNode.keys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keys);
    }
}
