package main.week6;

public class HashTableImpl extends HashTable {

    /**
     * Constructs a new HashTable.
     *
     * @param capacity to be used as capacity of the table.
     * @throws IllegalArgumentException if the input capacity is invalid.
     */
    public HashTableImpl(int capacity) {
        super(capacity);
    }

    @Override
    public int hash(String item) {
        return Math.abs(item.hashCode() % this.getCapacity());
    }
}