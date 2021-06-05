package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Fruit extends Food {
    public Fruit(String name, Calendar expiryDate, Calendar createDate, int price,
                 double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
