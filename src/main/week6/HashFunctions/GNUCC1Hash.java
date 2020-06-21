package main.week6.HashFunctions;

import main.week6.HashTable;

public class GNUCC1Hash extends HashTable {
    public GNUCC1Hash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null || item.isEmpty()) return 0;
        int n = item.length();
        int hash =  n;
        for (int i = 0; i < n; i++) {
            hash = 613 * hash + (int) item.charAt(i);
        }

        return (((hash << 2) >>> 2) % super.getCapacity());
    }
}