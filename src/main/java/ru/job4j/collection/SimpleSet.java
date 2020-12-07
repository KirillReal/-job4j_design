package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable{
    private int size;
    private final SimpleArray<T> array = new SimpleArray<>(size);

    public SimpleSet(int size) {
        this.size = size;
    }

    public void add(T value) {
        for (T t : array) {
            if (!Objects.equals(t, value)) {
                array.add(value);
            }
        }
    }

    @Override
    public Iterator iterator() {
        return array.iterator();
    }
}
