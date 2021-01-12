package main.Week3.MainMatter.LazyDepthFirsttIterator;

import java.util.Iterator;
import java.util.Stack;

/**
 * Iterates lazily over a binary tree in a depth-first manner. For instance a tree
 * with 8 as it's root and 4 and 10 as it's children should be iterated as: 8 ->
 * 4 -> 10.
 */
public class BinaryTreeIterator<V> implements Iterator<V> {

    private BTree<V> tree;
    //    private Queue<Position<V>> queue;
    private Position<V> current;
    private Stack<Position<V>> list;

    /**
     * Constructor.
     * Should reset on a new tree.
     *
     * @param tree takes the tree
     */
    public BinaryTreeIterator(BTree<V> tree) {
        this.tree = tree;
//        this.queue = new LinkedList<>();
        this.current = tree.getRoot();
        this.list = new Stack<>();

//        try {
//            buildStack(this.tree.getRoot());
//        } catch (InvalidPositionException e) {
//            System.err.println(e);
//        }
    }

//    public void buildStack(Position<V> position) throws InvalidPositionException {
//
//        queue.add(position);
//
//
//        if (this.tree.hasLeft(position)) {
//            buildStack(this.tree.getLeft(position));
//        }
//        if (this.tree.hasRight(position)) {
//            buildStack(this.tree.getRight(position));
//        }
//
//
//    }

    /**
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
//        return !queue.isEmpty();
        return current != null;
    }

    /**
     * Get the next element of the iterator and shift
     * iterator by one.
     *
     * @return current element value
     * @post iterator is moved to next element
     */
    @Override
    public V next() {
//        return queue.remove().getValue();

        Position<V> temp = current;

        try {

            if (tree.hasLeft(current)) {
                list.push(current);
                current = tree.getLeft(current);
            } else if (!list.isEmpty()) {
                current = tree.getRight(list.pop());


            } else current = null;


        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        return temp.getValue();

    }

    /**
     * Skip a single element of the iterator.
     *
     * @post iterator is moved to next element.
     */
    @Override
    public void remove() {
        next();
    }

}
