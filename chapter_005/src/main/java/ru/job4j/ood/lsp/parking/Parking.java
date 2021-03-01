package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements StrategyParking{
    private List<AbstractCar> parkTruck;
    private List<AbstractCar> parkCar;
    private int cellsTruck;
    private int cellsCar;

    public Parking(int cellsTruck, int cellsCar) {
        this.cellsTruck = cellsTruck;
        this.cellsCar = cellsCar;
        this.parkTruck = new ArrayList<>(cellsTruck);
        this.parkCar = new ArrayList<>(cellsCar);
    }
    @Override
    public boolean parkingCar(AbstractCar car) {
        return false;
    }

    @Override
    public void remove(AbstractCar car) {

    }
}
