package main.Week3;

import java.util.Iterator;

/**
 * Iterates lazily over a binary tree in a depth-first manner. For instance a tree
 * with 8 as it's root and 4 and 10 as it's children should be iterated as: 8 ->
 * 4 -> 10.
 */
class BinaryTreeIterator<V> implements Iterator<V> {
    /**
     * Constructor.
     * Should reset on a new tree.
     *
     * @param tree takes the tree
     */
    public BinaryTreeIterator(BTree<V> tree) {
        // TODO
    }

    /**
     * @return True if there is a next element in the iterator, else False
     */
    @Override
    public boolean hasNext() {
        // TODO
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
        // TODO
    }

    /**
     * Skip a single element of the iterator.
     *
     * @post iterator is moved to next element.
     */
    @Override
    public void remove() {
        // TODO
    }


    /**
     * DO NOT MODIFY
     */
    interface Position<V> {
        /**
         * @return the key of this position.
         */
        public int getKey();

        /**
         * @return the value of the position.
         */
        public V getValue();
    }

    interface BTree<V> {
        /**
         * @return the root of the tree
         */
        public main.Week3.Position<V> getRoot();

        /**
         * Get the left child of a position.
         *
         * @param v the position to get the child of.
         * @return the child of the position iff hasLeft(v) is true.
         * @throws main.Week3.InvalidPositionException else
         */
        public main.Week3.Position<V> getLeft(main.Week3.Position<V> v) throws main.Week3.InvalidPositionException;

        /**
         * Get the right child of a position.
         *
         * @param v the position to get the child of.
         * @return the child of the position iff hasRight(v) is true.
         * @throws main.Week3.InvalidPositionException else
         */
        public main.Week3.Position<V> getRight(main.Week3.Position<V> v) throws main.Week3.InvalidPositionException;

        /**
         * Check if a position has a left child.
         *
         * @param v position to check.
         * @return true iff v has a left child.
         * @throws main.Week3.InvalidPositionException if v is not valid (e.g. null)
         */
        public boolean hasLeft(main.Week3.Position<V> v) throws main.Week3.InvalidPositionException;

        /**
         * Check if a position has a right child.
         *
         * @param v position to check.
         * @return true iff v has a right child.
         * @throws main.Week3.InvalidPositionException if v is not valid (e.g. null)
         */
        public boolean hasRight(main.Week3.Position<V> v) throws main.Week3.InvalidPositionException;

        /**
         * Adds a new entry to the tree.
         *
         * @param key   to use.
         * @param value to add.
         */
        public void add(int key, V value);
    }

    class BTNode<V> implements main.Week3.Position<V> {
        private int key;
        private V value;
        private main.Week3.Position<V> parent, left, right;

        /**
         * Simple constructor.
         *
         * @param key   to set as key.
         * @param value to set as value.
         */
        public BTNode(int key, V value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        /**
         * @param value to set.
         */
        public void setValue(V value) {
            this.value = value;
        }

        /**
         * @return the parent.
         */
        public main.Week3.Position<V> getParent() {
            return parent;
        }

        /**
         * @param parent to set
         */
        public void setParent(main.Week3.Position<V> parent) {
            this.parent = parent;
        }

        /**
         * @return the left child.
         */
        public main.Week3.Position<V> getLeft() {
            return left;
        }

        /**
         * @param left to set
         */
        public void setLeft(main.Week3.Position<V> left) {
            this.left = left;
        }

        /**
         * @return the right child.
         */
        public main.Week3.Position<V> getRight() {
            return right;
        }

        /**
         * @param right to set
         */
        public void setRight(main.Week3.Position<V> right) {
            this.right = right;
        }

        @Override
        public V getElement() {
            return getValue();
        }
    }

    class BinaryTree<V> implements BTree<V> {
        private main.Week3.Position<V> root;

        /**
         * Simple constructor.
         */
        public BinaryTree() {
            this.root = null;
        }

        @Override
        public main.Week3.Position<V> getRoot() {
            return root;
        }

        @Override
        public main.Week3.Position<V> getLeft(main.Week3.Position<V> v) throws main.Week3.InvalidPositionException {
            BTNode<V> node = checkPosition(v);
            return node.getLeft();
        }

        @Override
        public main.Week3.Position<V> getRight(main.Week3.Position<V> v) throws main.Week3.InvalidPositionException {
            BTNode<V> node = checkPosition(v);
            return node.getRight();
        }

        @Override
        public boolean hasLeft(main.Week3.Position<V> v) throws main.Week3.InvalidPositionException {
            BTNode<V> node = checkPosition(v);
            return node.getLeft() != null;
        }

        @Override
        public boolean hasRight(main.Week3.Position<V> v) throws main.Week3.InvalidPositionException {
            BTNode<V> node = checkPosition(v);
            return node.getRight() != null;
        }

        @Override
        public void add(int key, V value) {
            if (root == null) {
                root = new BTNode<>(key, value);
            } else {
                this.add((BTNode<V>) root, new BTNode<>(key, value));
            }
        }

        /**
         * Adds the newNode recursively at the right position.
         *
         * @param node    currently examining this node to see if the newnode goes here
         * @param newNode to place somewhere.
         */
        private void add(BTNode<V> node, BTNode<V> newNode) {
            if (node.getKey() == newNode.getKey()) {
                node.setValue(newNode.getValue());
            } else {
                if (node.getKey() > newNode.getKey()) {
                    if (node.getLeft() == null) {
                        newNode.setParent(node);
                        node.setLeft(newNode);
                    } else {
                        this.add((BTNode<V>) node.getLeft(), newNode);
                    }
                } else {
                    if (node.getRight() == null) {
                        newNode.setParent(node);
                        node.setRight(newNode);
                    } else {
                        this.add((BTNode<V>) node.getRight(), newNode);
                    }
                }
            }
        }

        /**
         * Checks if the position is valid
         *
         * @param v position to check
         * @return v iff v instanceof BTNode.
         * @throws main.Week3.InvalidPositionException else
         */
        private BTNode<V> checkPosition(main.Week3.Position<V> v) throws main.Week3.InvalidPositionException {
            if (!(v instanceof BTNode)) {
                throw new main.Week3.InvalidPositionException("Position was null");
            }
            BTNode<V> result = (BTNode<V>) v;
            return result;
        }
    }


}
