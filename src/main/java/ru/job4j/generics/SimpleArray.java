package ru.job4j.generics;

import java.util.Objects;
import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int size = 0;
    private final Objects[] array;

    public SimpleArray(int size) {
        this.array =  new Objects[size];
    }

    public void add(T model){
        Objects.checkIndex(size,this.array.length);
        array[size++] = (Objects) model;
    }

    public void set(int index,T model){
        Objects.checkIndex(index,size);
        this.array[index] = (Objects) model;
    }

    public void remove(int index){
        Objects.checkIndex(index,size);
        array[index] = null;
        System.arraycopy(array,index + 1,array,size,size - index);
        array[index - 1] = null;
        size--;
    }

    public T get(int index){
        Objects.checkIndex(index,size);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[pos++];
            }
        };

    }
}
