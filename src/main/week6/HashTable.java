package main.week6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Entry objects are used to represent "Key-Value" pairs.
 * An entry can be created by using new Entry(String key, Integer Value)
 * The .equals() method of Entry will compare the keys only.
 */
class Entry {
    public final String key;
    public final Integer value;

    public Entry(String s, Integer v) {
        key = s;
        value = v;
    }

    public boolean equals(String s) {
        return s == null && key == null || key.equals(s);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && this.equals(((Entry) o).key);
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "(" + this.key + "," + this.value + ")";
    }
}

public abstract class HashTable {
    protected LinkedList<Entry>[] myTable;

    /**
     * Constructs a new HashTable.
     *
     * @param capacity to be used as capacity of the table.
     * @throws IllegalArgumentException if the input capacity is invalid.
     */
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        } else myTable = new LinkedList[capacity];
    }

    /**
     * Add a key value pair to the HashTable.
     *
     * @param key   to identify the value.
     * @param value that is identified by the key.
     */
    public void put(String key, Integer value) {
        Entry entry;
        if (key != null) {
            entry = new Entry(key, value);
        } else {
            entry = new Entry("", value);
            key = "";
        }
        if (myTable[hash(key)] == null) {
            myTable[hash(key)] = new LinkedList<>();
        }
        for (Entry e : myTable[hash(key)]) {
            if (e.getKey().equals(key)) {
                //e = new Entry(key, value);
                myTable[hash(key)].remove(e);
                break;
            }
        }
        myTable[hash(key)].add(entry);
    }

    /**
     * @param key to look for in the HashTable.
     * @return true iff the key is in the HashTable.
     */
    public boolean containsKey(String key) {

        if(key == null)
            key = "";

        if (myTable[hash(key)] == null) return false;
        if (myTable[hash(key)].isEmpty()) return false;
        for (Entry e : myTable[hash(key)]) {
            if (e.getKey().equals(key)) return true;
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

        if(key == null)
            key = "";

        if (myTable[hash(key)] == null || myTable[hash(key)].isEmpty()) {
            return null;
        }
        for (Entry e : myTable[hash(key)]) {
            if (e.getKey().equals(key)) return e.getValue();
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

    @Override
    public String toString() {
        return "HashTable{" +
                "myTable=" + Arrays.toString(myTable) +
                '}';
    }

    public void print() {
        System.out.println(this.toString());
    }
}
