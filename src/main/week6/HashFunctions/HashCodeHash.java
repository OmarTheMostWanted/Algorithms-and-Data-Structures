package main.week6.HashFunctions;

import main.week6.HashTable;

public class HashCodeHash extends HashTable {
    public HashCodeHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null) return 0;
        return Math.abs(item.hashCode()) % getCapacity();

    }
}