package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinkedReverse<T> implements Iterable {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        if (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void revert() {
        Node<T> reversedPart = null;
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = reversedPart;
            reversedPart = current;
            current = next;
        }
        head = reversedPart;
    }

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
               private Node<T> node = head;
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
            private T value;
           private Node<T> next;

            public Node(T value, Node<T> next) {
                this.value = value;
                this.next = next;
            }
        }
    }
