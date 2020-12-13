package ru.job4j.tree;

import java.util.*;
import java.util.function.BiPredicate;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(child).isEmpty()) {
            Optional<Node<E>> node = findBy(parent);
            if (node.isPresent()) {
               node.get().children.add(new Node<>(child));
               return true;
            }
        }
        return false;
    }


    public boolean isBinary() {
        BiPredicate<Node<E>, E> func = (node, val) -> node.children.size() > 2;
        return findElem(func, null).isEmpty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        BiPredicate<Node<E>, E> func = (node, val) -> node.value.equals(val);
        return findElem(func, value);
    }

    public Optional<Node<E>> findElem(BiPredicate<Node<E>, E> func,E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
