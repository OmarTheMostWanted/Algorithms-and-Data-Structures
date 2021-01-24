package main.code.Book.Ch10Maps;

import java.util.Iterator;
import java.util.Map.Entry;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    public Iterable<V> values() {
        return new ValueIterable();
    }

    //---------------- nested MapEntry class ----------------
    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K k; // key
        private V v; // value

        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }

        // public methods of the Entry interface
        public K getKey() {
            return k;
        }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) {
            k = key;
        }

        public V getValue() {
            return v;
        }

        public V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
    } //----------- end of nested MapEntry class -----------

    // Support for public keySet method...
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public K next() {
            return entries.next().getKey();
        } // return key!

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    // Support for public values method...
    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public V next() {
            return entries.next().getValue();
        } // return value!

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }
}

