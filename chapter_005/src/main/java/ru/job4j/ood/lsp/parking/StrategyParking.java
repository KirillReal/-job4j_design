package ru.job4j.ood.lsp.parking;

public interface StrategyParking {
    boolean parkingCar (AbstractCar car);
    void remove (AbstractCar car);
}
