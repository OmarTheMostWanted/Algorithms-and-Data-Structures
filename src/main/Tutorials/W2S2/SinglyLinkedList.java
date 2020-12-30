package main.Tutorials.W2S2;

public class SinglyLinkedList {
    class SLList {

        // Each object in SLList has one field head, which points to the starting Node of SLList.
        private Node head;

        /**
         * Constructor: initialises the head field as null
         */
        public SLList() {
            head = null;
        }

        /**
         * @return The element in the head Node of the SLL
         */
        public Object getHead() {
            if (head == null) return null;
            return head.getElement();
        }

        /**
         * Adds element e in a new Node to the head of the list.
         *
         * @param e The element to add.
         */
        public void addFirst(Object e) {
            Node n = new Node(e, this.head);
            this.head = n;
        }

        /**
         * Remove the first Node in the list and return its element.
         *
         * @return The element of the head Node. If the list is empty, this method returns null.
         */
        public Object removeFirst() {
            if (head == null) return null;
            Object o = this.head.getElement();
            this.head = this.head.getNext();
            return o;
        }

        /**
         * Adds element e in a new Node to the tail of the list.
         *
         * @param e The element to add.
         */
        public void addLast(Object e) {

            if (head == null) addFirst(e);

            Node n = head;
            while (n.getNext() != null) {
                n = n.getNext();
            }

            Node last = new Node(e, null);
            n.setNext(last);
        }

        /**
         * Remove the last Node in the list and return its element.
         *
         * @return The element of the tail Node. If the list is empty, this method returns null.
         */
        public Object removeLast() {
            if (head == null) return null;

            Node n = head;
            Node it = n;

            while (n.getNext() != null) {
                it = n;
                n = n.getNext();
            }

            it.setNext(null);
            return n.getElement();
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
            if (head == null) return null;
            int c = 0;
            Node n = head;
            while (n.getNext() != null) {
                if (c == pos) break;
                else {
                    n = n.getNext();
                    c++;
                }
            }

            if (c != pos) return null;
            else return n.getElement();
        }

        class Node {

            // Each node object has these two fields
            private Object element;

            private Node next;

            // Constructor: Creates a Node object with element = e and next = n
            Node(Object e, Node n) {
                element = e;
                next = n;
            }

            // This function returns the element variable of the Node
            public Object getElement() {
                return element;
            }

            // This function gets Object e as input and sets e as the element of the Node
            public void setElement(Object e) {
                element = e;
            }

            // This function returns the next Node
            public Node getNext() {
                return next;
            }

            // This function gets Node n as input and sets the next variable of the current Node object as n.
            public void setNext(Node n) {
                next = n;
            }
        }
    }


}
