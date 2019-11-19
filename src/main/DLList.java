package main;

//week 2 ex 4

public class DLList {
    class Node {
        // Each node object has these three fields
        private Object element;
        private Node previous;
        private Node next;

        // Constructor: Creates a Node object with element = e, previous = p and next = n
        Node(Object e, Node p, Node n) {
            element = e;
            previous = p;
            next = n;
        }

        // This function gets Object e as input and sets e as the element of the Node
        public void setElement(Object e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public Object getElement() {
            return element;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(Node n) {
            next = n;
        }

        // This function returns the next Node
        public Node getNext() {
            return next;
        }

        // This function gets Node p as input and sets the previous variable of the current Node object as p.
        public void setPrevious(Node p) {
            previous = p;
        }

        // This function returns the previous Node
        public Node getPrevious() {
            return previous;
        }
    }

    // Each object in DLList has one field head, which points to the starting Node of DLList.
    private Node head;
    // Each object in DLList has one field tail, which points to the final Node of DLList.
    private Node tail;

    /**
     * Constructor: initialises the head and tail fields as null
     */
    public DLList() {
        head = null;
        tail = null;
    }

    /**                              
     * @return The element in the head Node of the DLL
     */
    public Object getHead() {
        if (this.head == null)
            return null;
        return head.getElement();
    }

    /**
     * @return The element in the tail Node of the DLL
     */
    public Object getTail() {
        if (this.head == null)
            return null;
        return tail.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(Object e) {
        if (this.head == null) {
            Node temp = new Node(e, null, null);
            this.head = temp;
            this.tail = temp;
        } else {
            Node newNode = new Node(e, null, this.head);
            this.head.previous = newNode;
            this.head = newNode;
        }
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        if (this.head == null) {
            return null;
        } else {
            Node remove = this.head;

            this.head = remove.next;
            if (remove.next != null) {
                this.head.previous = null;
            }
            remove.next = null; // Do I need this?
            return remove.element;
        }

    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e The element to add.
     */
    public void addLast(Object e) {
        if (this.head == null) {
            this.addFirst(e);
        } else {

            Node newTail = new Node(e, this.tail, null);
            this.tail.next = newTail;
            this.tail = newTail;

        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (this.head == null) {
            return null;
        } else {
            Node oldTail = this.tail;
            if (oldTail.previous == null) {
                return this.removeFirst();
            } else this.tail = oldTail.previous;
            this.tail.next = null;

            oldTail.previous = null; //need this?
            return oldTail.element;

        }
    }

    /**
     * @return the number of Nodes in the list
     */
    public int size() {
        if (this.head == null)
            return 0;

        int size = 0;
        Node it = this.head;
        while (it != null) {
            size++;
            it = it.next;
        }
        return size;
    }

    /**
     * Adds element e in a new Node which is inserted at position pos.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
     * If there is no Node in position pos, this method adds it to the last position.
     *
     * @param pos The position to insert the element at.
     * @param e   The element to add.
     */
    public void addAtPosition(int pos, Object e) {

        if (pos < 0) {
            return;
        }
        int size = this.size();

        if (size == 0 || pos == 0) {
            addFirst(e);
            return;
        }

        if (pos >= size) {
            this.addLast(e);
            return;
        }


        int count = 0;
        Node it = this.head;

        while (count < pos) {
            count++;
            it = it.next;
        }

        Node next = it;
        Node before = it.previous;
        Node newNode = new Node(e, before, next);

        next.previous = newNode;
        before.next = newNode;



    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        int size = this.size();
        if (size == 0 || pos >= size || pos < 0) {
            return null;
        }

        if (pos == 0) {
            return this.removeFirst();
        }

        if (pos == size - 1)
            return this.removeLast();

        int count = 0;
        Node it = this.head;

        while (count < pos) {
            count++;
            it = it.next;
        }

        Node next = it.next;
        Node before = it.previous;
        Node removed = it;
        before.next = next;
        next.previous = before;
        return removed.element;
    }

    /**
     * @return A new DLL that contains the elements of the current one in reversed order.
     */
    public DLList reverse() {

        DLList res = new DLList();

        Node it = this.head;


        while (it != null) {
            res.addFirst(it.element);
            it = it.next;
        }


        return res;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");

        if (this.head == null) {
            return "[]";
        }
        Node it = this.head;

        res.append('[');

        while (it != null) {
            res.append(it.element.toString());
            res.append(" ");
            it = it.next;
        }

        res.append(']');
        return res.toString();
    }

}
