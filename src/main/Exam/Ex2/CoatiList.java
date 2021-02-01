package main.Exam.Ex2;

class CoatiList {

    private CoatiNode head;

    private CoatiNode tail;


    public CoatiList() {
    }


    public CoatiNode getHead() {
        return head;
    }

    public CoatiNode getTail() {
        return tail;
    }


    /**
     * Adds value v in a new node to the tail of the list.
     *
     * @param v Value to add.
     */
    public void addLast(int v) {

        if (tail != null) {
            //CoatiNode p = tail.getPrevious();
            CoatiNode n = new CoatiNode(v);

            n.setPrevious(tail);
            tail.setNext(n);

            //if(p != null) p.setNext(n);
            //n.setNext(null);
            tail = n;

            checkSkip(n);

        } else {
            CoatiNode n = new CoatiNode(v);
            head = n;
            tail = n;
        }

    }


    private void checkSkip(CoatiNode n) {
        CoatiNode p = n.getPrevious();

        int count = 0;
        while (p != null && count != 2) {
            p = p.getPrevious();
            count++;
        }

        if (count == 2 && p != null) {
            n.setSkipBack(p);
            if (p.getSkipAhead() != n) checkSkip(p);
        }


        p = n.getNext();
        count = 0;
        while (p != null && count != 2) {
            p = p.getNext();
            count++;
        }
        if (count == 2 && p != null) {
            n.setSkipAhead(p);
            if (p.getSkipBack() != n) checkSkip(p);
        }


    }


    /**
     * Remove the last node in the list and return its value.
     *
     * @return The value of the tail node.
     * @throws EmptyListException If the list is empty.
     */
    public int removeLast() {

        if (tail == null) throw new EmptyListException();

        CoatiNode last = tail;
        CoatiNode p = tail.getPrevious();

        if (p != null) {
            p.setNext(null);
            tail = p;

            if (last.getSkipBack() != null) {
                last.getSkipBack().setSkipAhead(null);
            }


        } else {
            tail = null;
            head = null;
        }
        return last.getValue();
    }

    /**
     * Returns the value of node at the given position.
     *
     * @param pos Position to look for.
     * @return The value of the node at the given position.
     * @throws IllegalIndexException If there is no node at this index.
     */
    public int getValueAtPosition(int pos) {


        if (tail == null) throw new IllegalIndexException();


        CoatiNode pointer = getHead();
        int count = 0;

        while (count < pos - 3 && pointer.getSkipAhead() != null) { // use skip ahead as much as we can
            pointer = pointer.getSkipAhead();
            count = count + 3;
        }

        if (pointer == null) throw new IllegalIndexException();


        while (count < pos && pointer != null) { // should be at most called 2 times
            count++;
            pointer = pointer.getNext();
        }

        if (count == pos) {
            if (pointer != null) return pointer.getValue();
        }

        throw new IllegalIndexException();
    }
}


