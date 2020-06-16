package main.trees;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

//this is from week4 this is also can be done by flattening the tree into an array and using an index;
class BinaryTreeIterator<V> implements Iterator<V> {

    private final BTree<V> tree;
    private Position<V> next;
    private Position<V> parent;
    private Stack<Position<V>> parents = new Stack<>();
    private boolean hasNext;


    /**
     * Constructor.
     * Should reset on a new tree.
     *
     * @param tree takes the tree
     */
    public BinaryTreeIterator(BTree<V> tree) {
        this.tree = tree;

        this.next = tree.getRoot();

        this.hasNext = !(next == null);

    }

    /**
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
        return hasNext;
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

        if (this.next == null) {
            throw new NoSuchElementException();
        }
        V res = next.getValue();

        try {
            if (tree.hasLeft(next)) {
                parents.add(next);
                next = tree.getLeft(next);
                hasNext = true;
            } else {

                if (!parents.isEmpty()) {
                    parent = parents.pop();
                    if (tree.hasRight(parent)) {
                        next = tree.getRight(parent);
                        hasNext = true;
                    }
                } else {
                    next = null;
                    hasNext = false;
                }

            }
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }

        return res;

    }


    /**
     * Skip a single element of the iterator.
     *
     * @post iterator is moved to next element.
     */
    @Override
    public void remove() {
        this.next();
    }
}


//class BinaryTreeIterator<V> implements Iterator<V> {
//    private final BTree<V> tree;
//    private final Queue<Position<V>> queue;
//    // private Position<V> next;
//
//    /**
//     * Constructor.
//     * Should reset on a new tree.
//     *
//     * @param tree takes the tree
//     */
//    public BinaryTreeIterator(BTree<V> tree) {
//        this.tree = tree;
//        // this.next = tree.getRoot();
//
//        this.queue = new LinkedList<>();
//        try {
//            this.preOrder(tree.getRoot());
//        } catch (InvalidPositionException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @return True if there is a next element in the iterator, else False
//     */
//    @Override
//    public boolean hasNext() {
//        return !queue.isEmpty();
//        // return next != null;
//    }
//
//    /**
//     * Get the next element of the iterator and shift
//     * iterator by one.
//     *
//     * @return current element value
//     * @post iterator is moved to next element
//     */
//    @Override
//    public V next() {
//
//        // if (this.next == null) {
//        //   return null;
//        // }
//        // V res = next.getValue();
//
//        // Position<V> parent = next;
//        // try {
//        //     if (tree.hasLeft(parent)) {
//        //         next = tree.getLeft(parent);
//        //     } else next = tree.getRight(parent);
//
//        // } catch (InvalidPositionException e) {
//        //     e.printStackTrace();
//        // }
//
//        // return res;
//        if(queue.isEmpty()){
//            return null;
//        }
//        else return queue.remove().getValue();
//    }
//
//    //this makes a list all the positions but does not work as it does  make a complete list of all elements beforehand.
//    private void preOrder(Position<V> p) throws InvalidPositionException {
//        queue.add(p);
//        if (tree.hasLeft(p)) {
//            preOrder(tree.getLeft(p));
//        }
//        if (tree.hasRight(p)) {
//            preOrder(tree.getRight(p));
//        }
//    }
//
//    /**
//     * Skip a single element of the iterator.
//     *
//     * @post iterator is moved to next element.
//     */
//    @Override
//    public void remove() {
//        this.next();
//    }
//}


