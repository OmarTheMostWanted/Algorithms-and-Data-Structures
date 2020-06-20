package test.week6;

import main.week6.HashTable;
import main.week6.HashTableImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    private static final int DEFAULT_SIZE = 4;

    @Test
    public void testHashTablePut3Items() {
        HashTable table = new HashTableImpl(DEFAULT_SIZE);
        table.put("Hello World!", 42);
        table.put("FortyTwo", 84);
        table.put("Arthur Dent", 123);
        assertTrue(table.containsKey("Hello World!"));
        assertTrue(table.containsKey("Arthur Dent"));
        assertTrue(table.containsKey("FortyTwo"));
        assertFalse(table.containsKey("Not In There!"));
        assertEquals(42, (int) table.get("Hello World!"));
        assertEquals(84, (int) table.get("FortyTwo"));
        assertEquals(123, (int) table.get("Arthur Dent"));
        assertNull(table.get("Not In There!"));
        table.print();
    }

    @Test
    public void testHashTableOverrideItem() {
        HashTable table = new HashTableImpl(DEFAULT_SIZE);
        table.put("Hello World!", 42);
        table.put("FortyTwo", 84);
        table.put("Arthur Dent", 123);
        assertTrue(table.containsKey("Hello World!"));
        assertFalse(table.containsKey("Not In There!"));
        assertEquals(42, (int) table.get("Hello World!"));
        assertNull(table.get("Not In There!"));
        table.put("Hello World!", 21);
        assertTrue(table.containsKey("Hello World!"));
        assertFalse(table.containsKey("Not In There!"));
        assertEquals(21, (int) table.get("Hello World!"));
        assertNull(table.get("Not In There!"));
        table.put("wazzaup Bitchs?", 69);
        assertEquals(69, (int) table.get("wazzaup Bitchs?"));
        assertEquals(123, (int) table.get("Arthur Dent"));
        table.put(null, 420);


        table.print();
    }
}