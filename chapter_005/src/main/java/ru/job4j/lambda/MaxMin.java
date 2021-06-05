package ru.job4j.lambda;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return find(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return find(value, comparator.reversed());
    }

    private <T> T find(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (T t: value) {
            if (comparator.compare(t, rsl) > 0) {
                rsl = t;
            }
        }
        return rsl;
    }
}
