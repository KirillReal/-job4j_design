package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable{
    private int size;
    private final SimpleArray<T> array = new SimpleArray<>(size);

    public SimpleSet(int size) {
        this.size = size;
    }

    boolean contains(T value) {
        Iterator<T> it = array.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), value)) {
                return false;
                //
                // break;
            }
        }
        return true;
    }

    public void add(T value) {
            if (!contains(value)) {
                array.add(value);
            }
    }

    @Override
    public Iterator iterator() {
        return array.iterator();
    }
}
