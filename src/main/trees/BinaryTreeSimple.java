package main.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSimple<T> {

    private T element;
    private BinaryTreeSimple<T> left;
    private BinaryTreeSimple<T> right;

    public BinaryTreeSimple(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeSimple<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeSimple<T> left) {
        this.left = left;
    }

    public BinaryTreeSimple<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeSimple<T> right) {
        this.right = right;
    }


    /**
     * Node is visited before its children.
     **/
    public void preorder() {
        System.out.println(this.element.toString()); // visit performs some operation at the node, e.g. print its element
        if (this.left != null) {
            this.left.preorder();
            if (this.right != null) {
                this.right.preorder();
            }
        }
    }

    /**
     * Node is visited after its children.
     **/
    public void postorder() {
        if (this.left != null) {
            this.left.postorder();
            if (this.right != null) {
                this.right.postorder();
            }
        }
        System.out.println(this.element.toString());
    }

    /**
     * Visits nodes per level (depth).
     **/
    public void breadthfirst() {
        Queue<BinaryTreeSimple<T>> q = new LinkedList<BinaryTreeSimple<T>>();
        q.add(this);
        while (!q.isEmpty()) {
            BinaryTreeSimple<T> p = q.remove();
            System.out.println(p.element.toString());
            if (p.left != null) {
                q.add(p.left);
                if (p.right != null) {
                    q.add(p.right);
                }
            }
        }
    }

    public void inorder(){
        this.inorder(this);
    }

    /** Node is visited after left child and before right child. **/
    public void inorder(BinaryTreeSimple<T> p) {
        if(p.getLeft() != null) inorder(p.getLeft());
        System.out.println(p.element.toString());
        if(p.getRight() != null) inorder(p.getRight());
    }

}
