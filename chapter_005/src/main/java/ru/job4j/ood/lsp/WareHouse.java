package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class WareHouse implements Strategy {
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    @Override
    public boolean check(Food food) {
        return percentOfDate(food) < 25;
    }

    @Override
    public List<Food> clear() {
        List<Food> foodReturn = new ArrayList<>(foodList);
        foodList.clear();
        return foodReturn;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
