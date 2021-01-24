package main.Week6.MainMatter.Multimaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MultiMap {

    int size;
    private Map<Integer, List<Integer>> map;

    /**
     * Creates a new MultiMap.
     */
    public MultiMap() {
        size = 0;
        this.map = new HashMap<>();
    }

    /**
     * @return The number of (key, value) pairs in the MultiMap.
     */
    public int size() {
        return size;
    }

    /**
     * @return True if the MultiMap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds the given (key, value) pair to the MultiMap.
     *
     * @param key   Key for the new item.
     * @param value New item to add to the MultiMap.
     */
    public void put(int key, int value) {


        this.map.computeIfAbsent(key, k -> new LinkedList<Integer>());

        //if(this.map.get(key).contains(value)) return;

        this.map.get(key).add(value);
        size++;

    }

    /**
     * Returns all values in the MultiMap for the given key.
     *
     * @param key Key to return all entries for.
     * @return A list of all entries for the given key.
     * If the key is not in the map, return an empty list.
     */
    public List<Integer> get(int key) {
        return this.map.get(key);
    }

    /**
     * Removes the given (key, value) pair from the MultiMap.
     *
     * @param key   Key for the value that should be removed.
     * @param value Value to remove.
     * @return True if removal was successful, false otherwise.
     */
    public boolean remove(int key, int value) {
        if (this.map.get(key) == null) {
            return false;
        } else if (this.map.get(key).contains(value)) {
            this.map.get(key).remove((Integer) value);
            size--;
            return true;
        } else return false;
    }
}