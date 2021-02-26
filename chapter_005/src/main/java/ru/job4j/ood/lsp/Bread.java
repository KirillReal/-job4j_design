package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Bread extends Food{
    public Bread(String name, Calendar expiryDate, Calendar createDate, int price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
