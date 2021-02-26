package ru.job4j.ood.lsp;

public class MakeDiscount {
    private static final int discount = 25;

    public void makeDiscount (Food food) {
        food.setDiscount(discount);
        makeNewPrice(food);
    }

    public void makeNewPrice (Food food) {
        food.setPrice(food.getPrice() * (100 - discount) / 100);
    }
}
