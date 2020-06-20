package main.week6;

import java.util.*;

public class MySet extends HashSet<String> {
    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();
        if (that == null) {
            this.iterator().forEachRemaining(result::add);
            return result;
        }
        Iterator<String> it1 = this.iterator();
        Iterator<String> it2 = that.iterator();
        it1.forEachRemaining(result::add);
        it2.forEachRemaining(s -> {
            if (!(result.contains(s))) result.add(s);
        });
        return result;
    }

    /**
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();
        if (that == null) return result;
        Iterator<String> it1 = this.iterator();
        it1.forEachRemaining(s -> {
            if (that.contains(s)) {
                result.add(s);
            }
        });
        return result;
    }

    /**
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();
        if (that == null) {
            this.iterator().forEachRemaining(result::add);
            return result;
        }
        Iterator<String> it1 = this.iterator();
        it1.forEachRemaining(s -> {
            if (!that.contains(s)) {
                result.add(s);
            }
        });
        return result;
    }

    /**
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();
        if (that == null) {
            this.iterator().forEachRemaining(result::add);
            return result;
        }
        Iterator<String> it1 = this.iterator();
        Iterator<String> it2 = that.iterator();
        it1.forEachRemaining(s -> {
            if (!(that.contains(s))) result.add(s);
        });
        it2.forEachRemaining(s -> {
            if (!(this.contains(s))) result.add(s);
        });
        return result;
    }


    /**
     * @return a String representation of a MySet object
     */
    public String toString() {
        StringBuilder res = new StringBuilder("MySet<");
        this.iterator().forEachRemaining(res::append);
        res.append(">");
        return res.toString();
    }
}
