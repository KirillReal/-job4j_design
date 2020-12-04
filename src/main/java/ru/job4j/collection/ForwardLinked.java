package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if(head == null){
            throw new NoSuchElementException();
        }
        final Node<T> node = head;
        head = node.next;
        node.next = null;
        size--;
        return node.value;
    }

    public T deleteLast() {
        Node<T> elem = head;
        T rsl;
        if(size == 1){
           rsl = deleteFirst();
        }else{
            for (int i = 0; i < size - 2;i++){
                elem = elem.next;
            }
            rsl = elem.next.value;
            elem.next = null;
            size--;
        }
        return rsl;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
