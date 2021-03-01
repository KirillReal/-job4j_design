package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Strategy{
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    @Override
    public boolean check(Food food) {
        double result = percentOfDate(food);
        if(result >= 25 && result < 1) {
            if (result > 0.75) {
                MakeDiscount mDiscount = new MakeDiscount();
                mDiscount.makeDiscount(food);
            }
            return true;
        }
        return false;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
