package ru.job4j.ood.lsp;

import java.util.List;

public class ControlQuality {

     private final List<Strategy> strategyList;


    public  ControlQuality(List<Strategy> strategyList) {
        this.strategyList = strategyList;
    }

    public void executeStrategy(Food food) {
        for(Strategy strategy : strategyList) {
            if(strategy.check(food)) {
                strategy.add(food);
            }
        }
        throw new IllegalStateException("Нет подходящего хранилища");
    }

    public List<Strategy> getStrategyList() {
        return strategyList;
    }
}
