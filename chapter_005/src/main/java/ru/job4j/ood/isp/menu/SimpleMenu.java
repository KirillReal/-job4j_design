package ru.job4j.ood.isp.menu;

import java.util.function.BiFunction;
import java.util.*;

public class SimpleMenu implements Menu {

    List<Node> roots;

    public boolean addRoot(String rootName, AbstractAction action) {
        boolean rsl = false;
        Node root = new Node(rootName, action);
        if (!roots.contains(root)) {
            roots.add(root);
            rsl = true;
        }
        return rsl;
    }


    private Optional<Node> findNode(String name) {
        Optional<Node> found = Optional.empty();
        Queue<Node> nodes = new LinkedList<>(roots);
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.name.equals(name)) {
                found = Optional.of(node);
                break;
            }
            nodes.addAll(node.children);
        }
        return found;
    }

    private boolean changeNode(
            String elementName, AbstractAction action, BiFunction<Node, AbstractAction, Boolean> function
    ) {
        Optional<Node> optionalNode = findNode(elementName);
        boolean rsl = false;
        if (optionalNode.isPresent()) {
            rsl = function.apply(optionalNode.get(), action);
        }
        return rsl;
    }

    @Override
    public boolean add(String parent, String element, AbstractAction action) {
        Optional<Node> parentNode = findNode(parent);
        if (parentNode.isEmpty()) {
            return false;
        }
        Optional<Node> elementNode = findNode(element);
        if (elementNode.isEmpty()) {
            parentNode.get().children.add(new Node(element,action,parentNode.get()));
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(String element) {
        BiFunction<Node, AbstractAction, Boolean> function = (node, act) -> {
            if (roots.contains(node)) {
                roots.remove(node);
            } else {
                Node parent = node.parent;
                parent.children.remove(node);
            }
            return true;
        };
        return changeNode(element, null, function);
    }

    @Override
    public boolean update(String element, AbstractAction action) {
        BiFunction<Node, AbstractAction, Boolean> function = (node, act) -> {
            node.action = action;
            return true;
        };
        return changeNode(element, action, function);
    }

    @Override
    public Optional<AbstractAction> get(String element) {
        Optional<AbstractAction> action = Optional.empty();
        Optional<Node> node = findNode(element);
        if (node.isPresent()) {
            action = Optional.of(node.get().action);
        }
        return action;
    }

    @Override
    public String ordered() {
        return ordered(roots, "", new StringBuilder()).toString();
    }
    private StringBuilder ordered(List<Node> nodes, String prefix, StringBuilder out) {
        String curPrefix;
        for (int i = 0; i < nodes.size(); i++) {
            curPrefix = String.format("%s%s", prefix, ((i + 1) + "."));
            out.append(curPrefix).append(" ").append(nodes.get(i).name);
            out.append(System.lineSeparator());
            if (nodes.get(i).children.size() != 0) {
                ordered(nodes.get(i).children, curPrefix, out);
            }
        }
        return out;
    }


    @Override
    public String unOrdered() {
        return unOrdered(roots, 0, new StringBuilder()).toString();
    }

    private StringBuilder unOrdered(List<Node> nodes, int lvl, StringBuilder out) {
        String prefix = "-".repeat(lvl);
        for (Node node : nodes) {
            out.append(prefix).append(" ").append(node.name);
            out.append(System.lineSeparator());
            if (node.children.size() != 0) {
                unOrdered(node.children, lvl + 1, out);
            }
        }
        return out;
    }

    private static class Node {
            private final String name;
            private AbstractAction action;
            private Node parent;
            private final List<Node> children;

            private Node(String name, AbstractAction action) {
                this.name = name;
                this.action = action;
                this.children = new LinkedList<>();
            }

            public Node(String name, AbstractAction action, Node parent) {
                this(name, action);
                this.parent = parent;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Node node = (Node) o;
                return Objects.equals(name, node.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name);
            }
        }
    }

