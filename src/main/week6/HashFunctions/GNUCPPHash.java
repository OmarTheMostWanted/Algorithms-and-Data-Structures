package main.week6.HashFunctions;

import main.week6.HashTable;

public class GNUCPPHash extends HashTable {
    public GNUCPPHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if(item == null || item.isEmpty()) return 0;
        int n = item.length();
        int hash = 0;

        for (int i = 0; i < n; i++) {
            hash = 4*hash + (int) item.charAt(i);
        }

        return (((hash << 1) >>> 1) % super.getCapacity());
    }
}
