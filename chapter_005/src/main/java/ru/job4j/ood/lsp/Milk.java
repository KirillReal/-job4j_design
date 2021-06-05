package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Milk extends Food {
    public Milk(String name, Calendar expiryDate, Calendar createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
