package main.week4;


public class ArrayStack {
    private Object[] elements;
    private int size;
    private int capacity;

    /**
     * Creates an empty ArrayStack with capacity 1.
     */
    public ArrayStack() {
        elements = new Object[1];
        size = 0;
        capacity = 1;
    }

    /**
     * @return The size of this ArrayStack.
     */
    public int size() {
        return elements.length;
    }

    /**
     * @return `true` iff this ArrayStack is empty, `false` otherwise.
     */
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * @return `true` iff the size is equal to the capacity, `false` otherwise.
     */
    public boolean isFull() {

        return capacity == size;
    }

    /**
     * @return the top element of the stack without removing it
     */
    public Object peek() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return this.elements[size - 1];
    }

    /**
     * Adds `o` to the stack.
     * If capacity of stack was too small, capacity is doubled and `o` is added.
     *
     * @param o the element to add to the stack.
     */
    public void push(Object o) {
        if (isFull()) {
            Object newer[] = new Object[capacity * 2];
            for (int i = 0; i < this.elements.length; i++) {
                newer[i] = this.elements[i];
            }
            this.capacity *= 2;
            this.elements = newer;
        }
        this.elements[size] = o;
        size++;
    }

    /**
     * Removes the top element from the stack.
     * If removing top would make the stack use less than 25% of its capacity,
     * then the capacity is halved.
     *
     * @return the element which was at the top of the stack.
     * @throws EmptyStackException iff the stack is empty
     */
    public Object pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();

        if (size * 4 <= capacity) {
            Object newer[] = new Object[capacity / 2];
            for (int i = 0; i < newer.length; i++) {
                newer[i] = this.elements[i];
            }
            this.capacity /= 2;
            this.elements = newer;
        }

        Object o = this.elements[size - 1];
        elements[size - 1] = null;
        size--;
        return o;
    }

    /**
     * @return a String representation of the ArrayStack
     * Example output for ArrayStack with 2 elements and capacity 5:
     * <ArrayStack[1,2]>(Size=2, Cap=5)
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ArrayStack[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(this.elements[i].toString());
            stringBuilder.append(',');
        }

        if (this.size != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        stringBuilder.append("]>(Size=");
        stringBuilder.append(this.size);
        stringBuilder.append(", Cap=");
        stringBuilder.append(this.capacity);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    // For testing, do not remove or change.
    public Object[] getElements() {
        return elements;
    }
}


