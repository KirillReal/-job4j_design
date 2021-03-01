package ru.job4j.ood.lsp.parking;

public class TruckCar implements AbstractCar {
    private String name;
    private final int size;

    public TruckCar(String name, int size) {
        this.name = name;
        this.size = size;
    }


    @Override
    public int getParkingSize() {
        return this.size;
    }
}
