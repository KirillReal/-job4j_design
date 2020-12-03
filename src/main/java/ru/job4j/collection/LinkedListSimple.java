package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedListSimple<E> implements Iterable<E> {
    private transient int size = 0;
    private transient Node<E> first;
    private transient Node<E> last;
    private int modCount = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkedListSimple(){
        this.first = new Node<>(null,null,null);
    }

    public void addLast(E e){
        final Node<E> l = last;
        final Node<E> newEl = new Node<>(l,e,null);
        last = newEl;
        if(l == null){
            first = newEl;
        }else
            l.next = newEl;
        size++;
        modCount++;
    }
    public E get(int index){
        Objects.checkIndex(index,size);
        Node<E> getEl = first;
        for(int i = 0; i < index;i++){
            getEl = first.next;
        }
        return getEl.item;
    }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private Node<E> result = first;
                private final int expectedModCount = modCount;
                @Override
                public boolean hasNext() {
                    if(expectedModCount != modCount){
                        throw new ConcurrentModificationException();
                    }
                    return result != null;
                }

                @Override
                public E next() {
                    if(!hasNext()){
                        throw new NoSuchElementException();
                    }
                     E value = result.item;
                     result = result.next;
                     return value;
                }
            };
        }
    public static void main(String[] args) {
        LinkedListSimple<String> data = new LinkedListSimple<>();
        data.addLast("A");
        Iterator<String> it = data.iterator();
        System.out.println(data.get(0));
    }
    }

