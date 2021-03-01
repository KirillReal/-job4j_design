package ru.job4j.ood.lsp;

import java.util.Calendar;
import java.util.GregorianCalendar;

public interface Strategy {
    void add(Food food);
    boolean check(Food food);

    default double percentOfDate (Food food) {
        long lifetime = (food.getExpireDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis());
        long livedTime = (new GregorianCalendar().getTimeInMillis() - food.getCreateDate().getTimeInMillis());
        //long now = Calendar.getInstance().getTimeInMillis();
        //long expired = food.getExpireDate().getTimeInMillis();
        //long created = food.getCreateDate().getTimeInMillis();
        return (double) (livedTime / lifetime);
    }
}
