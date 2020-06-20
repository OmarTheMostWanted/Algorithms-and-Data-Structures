package main.lists;


public class CLL<T> {

    class Node<E> {

        private Node<E> next;
        private E element;

        public Node(Node<E> nex, E element) {
            this.element = element;
            this.next = nex;
        }


        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }


    }

    private Node<T> tail;
    private int size;

    public CLL() {
        this.tail = new Node<T>(null, null);
        this.size = 0;

    }

    public void addFirst(T element) {

        if (this.size == 0) {
            this.tail = new Node(null, element);
            this.tail.next = this.tail;
        } else {

            Node<T> node = new Node<T>(this.tail.next, element);
            this.tail.next = node;
        }
        this.size++;
    }

    public void addLast(T element) {
        this.addFirst(element);
        this.rotate();
    }

    public void rotate() {

        if (size == 0 || size == 1) {
            return;
        }

        this.tail = this.tail.next;

    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T element = this.tail.next.getElement();

        this.tail.next = this.tail.next.next;

        size--;

        return element;
    }

    public T removeLast() {
        this.rotate();
        return this.removeFirst();
    }

    public int getSize() {
        return size;
    }

    public T getFirst() {
        if (size == 0)
            return null;
        return this.tail.next.getElement();
    }

    public T getLast() {
        return this.tail.getElement();
    }

    @Override
    public boolean equals(Object that) {

        if (this == that) {
            return true;
        }
        if (that instanceof CLL) {
            CLL<T> other = (CLL<T>) that;

            if (this.getSize() == ((CLL) other).size) {
                Node<T> thisIt = this.tail.next;
                Node<T> otherIt = other.tail.next;
                int counter = this.size;

                while (counter != 0) {
                    if (!thisIt.getElement().equals(otherIt.getElement())) {
                        return false;
                    }
                }

                return true;

            }
        }

        return false;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append('[');


        Node<T> current = this.tail.next;
        int counter = this.size;

        while (current != null && counter != 0) {
            stringBuilder.append(current.getElement().toString());
            stringBuilder.append(' ');
            current = current.next;
            counter--;
        }

        if (size != 0)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        stringBuilder.append(']');

        return stringBuilder.toString();
    }

    private void printListToConsole() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        CLL<Integer> CLL = new CLL<>();
        CLL.addLast(0);
        CLL.addLast(1);
        CLL.addLast(2);
        CLL.addLast(4);

        CLL.printListToConsole();

        CLL.rotate();

        CLL.printListToConsole();
        CLL.rotate();

        CLL.printListToConsole();
        CLL.rotate();

        CLL.printListToConsole();

    }
}

