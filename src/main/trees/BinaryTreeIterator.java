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


//import java.util.*;
//
///**
// * Iterates lazily over a binary tree in a depth-first manner. For instance a tree
// * with 8 as it's root and 4 and 10 as it's children should be iterated as: 8 ->
// * 4 -> 10.
// */
//class BinaryTreeIterator<V> implements Iterator<V> {
//    /**
//     * Constructor.
//     * Should reset on a new tree.
//     *
//     * @param tree
//     * takes the tree
//     */
//    Stack<Position<V>> s;
//    BTree<V> tr;
//    public BinaryTreeIterator(BTree<V> tree) {
//        s = new Stack<>();
//        s.push(tree.getRoot());
//        tr = tree;
//// System.out.println(s.peek().getValue());
//    }
//
//    /**
//     * @return True if there is a next element in the iterator, else False
//     */
//    @Override
//    public boolean hasNext() {
//
//        if(s.isEmpty()) return false;
//        if(s.peek()== null) return false;
//        return true;
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
//        if(s.isEmpty()) return null;
//
//        Position<V> dummy = s.peek();
//        s.pop();
//        if(dummy == null ) return null;
//// System.out.println(dummy.getValue());
//        try
//        {
//            if(tr.hasRight(dummy))
//            {
//                s.push(tr.getRight(dummy));
//
//            }
//// System.out.println(tr.getRight(dummy).getValue());
//        }
//
//        catch (InvalidPositionException e){}
//
//        try{
//            if(tr.hasLeft(dummy)){
//                s.push(tr.getLeft(dummy));
//
//            }
//// System.out.println(tr.getLeft(dummy).getValue());
//        }
//
//        catch (InvalidPositionException e){}
//
//
//
//
//        return dummy.getValue();
//
//    }
//
//    /**
//     * Skip a single element of the iterator.
//     *
//     * @post iterator is moved to next element.
//     */
//    @Override
//    public void remove() {
//
//        if(s.isEmpty()) return;
//
//        Position<V> dummy = s.pop();
//
//        try{
//            if(tr.hasRight(dummy))
//            {
//                s.push(tr.getRight(dummy));}}
//
//        catch (InvalidPositionException e){}
//
//        try{
//            if(tr.hasLeft(dummy))
//            {
//                s.push(tr.getLeft(dummy));
//            }
//
//        }
//
//        catch (InvalidPositionException e){}
//
//    }
//}

///**
// * DO NOT MODIFY
// */
//interface Position<V> {
//    /**
//     * @return the key of this position.
//     */
//    public int getKey();
//
//    /**
//     * @return the value of the position.
//     */
//    public V getValue();
//}
//
//interface BTree<V> {
//    /**
//     * @return the root of the tree
//     */
//    public Position<V> getRoot();
//
//    /**
//     * Get the left child of a position.
//     *
//     * @param v
//     * the position to get the child of.
//     * @return the child of the position iff hasLeft(v) is true.
//     * @throws InvalidPositionException
//     * else
//     */
//    public Position<V> getLeft(Position<V> v) throws InvalidPositionException;
//
//    /**
//     * Get the right child of a position.
//     *
//     * @param v
//     * the position to get the child of.
//     * @return the child of the position iff hasRight(v) is true.
//     * @throws InvalidPositionException
//     * else
//     */
//    public Position<V> getRight(Position<V> v) throws InvalidPositionException;
//
//    /**
//     * Check if a position has a left child.
//     *
//     * @param v
//     * position to check.
//     * @return true iff v has a left child.
//     * @throws InvalidPositionException
//     * if v is not valid (e.g. null)
//     */
//    public boolean hasLeft(Position<V> v) throws InvalidPositionException;
//
//    /**
//     * Check if a position has a right child.
//     *
//     * @param v
//     * position to check.
//     * @return true iff v has a right child.
//     * @throws InvalidPositionException
//     * if v is not valid (e.g. null)
//     */
//    public boolean hasRight(Position<V> v) throws InvalidPositionException;
//
//    /**
//     * Adds a new entry to the tree.
//     *
//     * @param key
//     * to use.
//     * @param value
//     * to add.
//     */
//    public void add(int key, V value);
//}

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


