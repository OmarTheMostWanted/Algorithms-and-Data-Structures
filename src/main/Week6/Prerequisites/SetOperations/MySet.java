package main.Week6.Prerequisites.SetOperations;

import java.util.HashSet;

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
        result.addAll(this);

        if (that != null) result.addAll(that);
        return result;
    }

    /**
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();

        if (that == null) return result;

        this.forEach(e -> {
            if (that.contains(e)) {
                result.add(e);
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
            result.addAll(this);
            return result;
        }

        this.forEach(e -> {
            if (!that.contains(e)) {
                result.add(e);
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
            result.addAll(this);
            return result;
        }


        this.forEach(e -> {
            if (!that.contains(e)) {
                result.add(e);
            }
        });

        that.forEach(e -> {
            if (!this.contains(e)) {
                result.add(e);
            }
        });


        return result;
    }

    /**
     * @return a String representation of a MySet object
     */
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("MySet<");
        stringBuilder.append(super.toString());
        stringBuilder.append(">");

        return stringBuilder.toString();
    }
}