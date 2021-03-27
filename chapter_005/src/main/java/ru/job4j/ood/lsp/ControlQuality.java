package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

     private final List<Strategy> strategyList;

    public  ControlQuality(List<Strategy> strategyList) {
        this.strategyList = strategyList;
    }

    public void executeStrategy(Food food) {
            for(Strategy strategy : strategyList) {
                if(strategy.check(food)){
                    strategy.add(food);
                    break;
                }
            }
        }

    public void sort(Food item) {
        for (Strategy strategy : strategyList) {
            if (strategy.check(item)) {
                strategy.add(item);
                break;
            }
        }
    }

    public void resort() {
        List<Food> containerFood = new ArrayList<>();
        for (Strategy strategy: strategyList) {
            containerFood.addAll(strategy.clear());
        }
        containerFood.forEach(this::sort);
    }
}


