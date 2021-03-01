package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements StrategyParking {
    private final List<AbstractCar> parkTruck;
    private final List<AbstractCar> parkCar;
    private final int cellsTruck;
    private final int cellsCar;

    public Parking(int cellsTruck, int cellsCar) {
        this.cellsTruck = cellsTruck;
        this.cellsCar = cellsCar;
        this.parkTruck = new ArrayList<>(cellsTruck);
        this.parkCar = new ArrayList<>(cellsCar);
    }

    @Override
    public boolean parkingCar(AbstractCar car) {
        if (parkCar.contains(car) || parkTruck.contains(car)) {
            throw new IllegalStateException("Уже существует машина с таким именем");
        }
        if (car.getParkingSize() != 1) {
            if (this.parkTruck.size() != this.cellsTruck) {
                this.parkTruck.add(car);
                return true;
            } else if (this.cellsCar - this.parkCar.size() >= car.getParkingSize()) {
                parkCar.add(car);
                return true;
            } else {
                return false;
            }
        } else if (this.parkCar.size() != this.cellsCar) {
            parkCar.add(car);
            return true;
        }
        return false;
    }

        @Override
        public void remove (AbstractCar car){
            int size = car.getParkingSize();
            if(this.parkCar.contains(car)) {
                if (size == 1) {
                    this.parkCar.remove(car);
                }else {
                    this.parkCar.removeIf(p -> p.equals(car));
                }
            }else if (this.parkTruck.contains(car)){
                this.parkTruck.remove(car);
            }else {
                throw new IllegalStateException("Нет машины с таким именем");
            }
        }

    public List<AbstractCar> getParkTruck() {
        return this.parkTruck;
    }

    public List<AbstractCar> getParkCar() {
        return this.parkCar;
    }
    }

