package ru.job4j.ood.isp.menu;

import java.util.Optional;

public interface AbstractMenu<K,V> {
    boolean add(K parent,K element,V action);
    boolean remove(K element);
    boolean update(K element,V action);
    Optional<V> get(K element);}
