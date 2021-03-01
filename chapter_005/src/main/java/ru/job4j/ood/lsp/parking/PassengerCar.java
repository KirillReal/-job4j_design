package ru.job4j.ood.lsp.parking;

public class PassengerCar implements AbstractCar {
    private final String name;
    private final int size;

    public PassengerCar(String name) {
        this.name = name;
        this.size = 1;
    }

    public String getName() {
        return name;
    }
    @Override
    public int getParkingSize() {
        return size;
    }
}
