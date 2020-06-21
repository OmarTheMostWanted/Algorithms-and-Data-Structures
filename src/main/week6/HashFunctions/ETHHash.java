package main.week6.HashFunctions;

import main.week6.HashTable;

public class ETHHash extends HashTable {
    public ETHHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null || item.isEmpty()) return 0;
        int n = item.length();
        int hash = 1;
        for (int i = 0; i < n; i++) {
            hash = ((int) item.charAt(i)) * ((hash % 257) + 1);
        }
        return hash % (super.getCapacity());
    }
}
