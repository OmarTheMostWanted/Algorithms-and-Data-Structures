package main.Week6.MainMatter.HashTable;

import java.util.LinkedList;

abstract class HashTable {
    protected LinkedList<Entry>[] myTable;

    /**
     * Constructs a new HashTable.
     *
     * @param capacity to be used as capacity of the table.
     * @throws IllegalArgumentException if the input capacity is invalid.
     */
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.myTable = new LinkedList[capacity];
    }

    /**
     * Add a key value pair to the HashTable.
     *
     * @param key   to identify the value.
     * @param value that is identified by the key.
     */
    public void put(String key, Integer value) {

        if (key == null) return;

        int index = hash(key);

        if (myTable[index] == null) {
            myTable[index] = new LinkedList<>();
            myTable[index].add(new Entry(key, value));
        } else {

            int put = -1;
            int counter = 0;
            for (Entry e : myTable[index]) {
                if (e.getKey().equals(key)) {
                    put = counter;
                    break;
                }
                counter++;
            }
            if (put == -1) myTable[index].add(new Entry(key, value));
            else myTable[index].set(put, new Entry(key, value));
        }

    }

    /**
     * @param key to look for in the HashTable.
     * @return true iff the key is in the HashTable.
     */
    public boolean containsKey(String key) {

        if (key == null) return false;

        int index = hash(key);
        if (myTable[index] == null) return false;
        else {
            for (Entry entry : myTable[index]) {
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get a value from the HashTable.
     *
     * @param key that identifies the value.
     * @return the value associated with the key or `null` if the key is not in the HashTable.
     */
    public Integer get(String key) {

        if (key == null) return null;

        int index = hash(key);
        if (myTable[index] == null) return null;
        else {
            for (Entry entry : myTable[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    /**
     * @return the capacity of the HashTable.
     */
    public int getCapacity() {
        return myTable.length;
    }

    /**
     * Hashes a string/key.
     *
     * @param item to hash.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public abstract int hash(String item);
}