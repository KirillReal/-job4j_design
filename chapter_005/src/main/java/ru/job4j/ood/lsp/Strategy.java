package ru.job4j.ood.lsp;

import java.util.Calendar;

public interface Strategy {
    void add(Food food);
    boolean check(Food food);

    default double percentOfDate (Food food) {
        long now = Calendar.getInstance().getTimeInMillis();
        long expired = food.getExpireDate().getTimeInMillis();
        long created = food.getCreateDate().getTimeInMillis();
        return (double) ((now - created) / (expired - created));
    }
}
