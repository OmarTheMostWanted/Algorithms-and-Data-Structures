package main.Exam.Ex2;

import java.util.Objects;

class CoatiNode {

    private int value;

    private CoatiNode next;

    private CoatiNode previous;

    private CoatiNode skipAhead;

    private CoatiNode skipBack;

    public CoatiNode(int value) {
        this.value = value;
    }

    public CoatiNode(int value, CoatiNode previous, CoatiNode next) {
        this(value);
        this.previous = previous;
        this.next = next;
    }

    public CoatiNode(int value, CoatiNode previous, CoatiNode next, CoatiNode skipBack, CoatiNode skipAhead) {
        this(value, previous, next);
        this.skipBack = skipBack;
        this.skipAhead = skipAhead;
    }

    public int getValue() {
        return value;
    }

    public CoatiNode getNext() {
        return next;
    }

    public void setNext(CoatiNode next) {
        this.next = next;
    }

    public CoatiNode getPrevious() {
        return previous;
    }

    public void setPrevious(CoatiNode previous) {
        this.previous = previous;
    }

    public CoatiNode getSkipAhead() {
        return skipAhead;
    }

    public void setSkipAhead(CoatiNode skipAhead) {
        this.skipAhead = skipAhead;
    }

    public CoatiNode getSkipBack() {
        return skipBack;
    }

    public void setSkipBack(CoatiNode skipBack) {
        this.skipBack = skipBack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CoatiNode coatiNode = (CoatiNode) o;
        return value == coatiNode.value && Objects.equals(next, coatiNode.next) && Objects.equals(previous, coatiNode.previous) && Objects.equals(skipAhead, coatiNode.skipAhead) && Objects.equals(skipBack, coatiNode.skipBack);
    }
}
