package main.Exam.Ex4;

import java.util.Objects;


class Path implements Comparable<Path> {

    private int from;

    private int to;

    private int coatis;

    /**
     * Represents a flight path from `from` to `to` with `coatis` coatis.
     *
     * @param from   ID of the house on one side.
     * @param to     ID of the house on the other side.
     * @param coatis Amount of coatis on this path.
     */
    public Path(int from, int to, int coatis) {
        this.from = from;
        this.to = to;
        this.coatis = coatis;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCoatis() {
        return coatis;
    }

    /**
     * Compares the amount of coatis of this path to that on another.
     *
     * @param o Path to compare to.
     * @return -1 if `this` path has fewer coatis, 1 if it has more, or 0 if both have an equal amount of coatis.
     */
    @Override
    public int compareTo(Path o) {
        return Integer.compare(this.coatis, o.coatis);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Path path = (Path) o;
        return ((from == path.from && to == path.to) || (from == path.to && to == path.from)) && coatis == path.coatis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.min(from, to), Math.max(from, to), coatis);
    }

    @Override
    public String toString() {
        return "Path{" + "from=" + from + ", to=" + to + ", coatis=" + coatis + '}';
    }
}

