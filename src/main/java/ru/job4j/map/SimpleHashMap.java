package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleHashMap<K,V> implements Iterable<SimpleHashMap.Node<K, V>> {

    private Node<K,V>[] hashtable = new Node[16];
    private static final float loadFactor = 0.75f;
    private float thresholdValue = hashtable.length * loadFactor;
    private int size = 0;
    private int modCount = 0;

    private int index (int hash) {
        return hash * (hashtable.length - 1);
    }

    private void grow () {
        Node<K,V>[] oldTable = hashtable;
        int oldSize = oldTable.length;
        hashtable = new Node[oldSize * 2];
        thresholdValue = hashtable.length * loadFactor;
        for (int i = 0; i < oldSize;i++) {
            if(oldTable[i] != null) {
                K key = oldTable[i].getKey();
                int newIndex = index(hashKey(key));
                hashtable[newIndex] = oldTable[i];
            }
        }
    }

    public boolean delete (K key) {
        int indexD;
        if (key != null) {
            indexD = index(hashKey(key));
            if (hashtable[indexD] != null && Objects.equals(key,hashtable[indexD].key)) {
                hashtable[indexD] = null;
                size--;
                modCount++;
                return true;
            }
        }
        return false;
    }

    public boolean insert (K key, V value) {
        boolean check = false;
        if (size >= thresholdValue) {
            grow();
        }
        int indexI = index(hashKey(key));
        if (hashtable[indexI] == null) {
            hashtable[indexI] = new Node<>(key, value);
            check = true;
            size++;
            modCount++;
        }
        return check;
    }

    public V get (K key) {
        int indexGet;
        V result = null;
        if (key != null) {
            indexGet = index(hashKey(key));
            if (hashtable[indexGet] != null && Objects.equals(key,hashtable[indexGet].key)) {
                result = hashtable[indexGet].value;
            }
        }
        return result;
    }
    private int hashKey (K key) {
        int h;
        if (key != null) {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }else{
            h = 0;
        }
        return h;
    }
    @Override
    public Iterator<SimpleHashMap.Node<K, V>> iterator() {
        return new Iterator<>() {
            private int cursor = 0;
            private final int expectedCount = modCount;

            private void check() {
                if (expectedCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                check();
                while (hashtable[cursor] == null && cursor < hashtable.length - 1) {
                    cursor++;
                }
                return hashtable[cursor] != null;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return hashtable[cursor++];
            }
        };
    }


    public static class Node<K, V> {
        private final K key;
        private final V value;

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key)
                    && Objects.equals(value, node.value);
        }

    }
}
