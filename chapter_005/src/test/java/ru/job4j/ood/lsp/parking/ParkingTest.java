package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {

    @Test
    public void whenCarParkingThenTrue() {
        PassengerCar car = new PassengerCar("Lada 1");
        Parking park = new Parking(10, 10);
        assertThat(park.parkingCar(car), is(true));
    }

    @Test
    public void whenCarParkingThenFalse() {
        PassengerCar car = new PassengerCar("Kia 1");
        PassengerCar carAnother = new PassengerCar("Nissan 2");
        Parking park = new Parking(10, 1);
        park.parkingCar(carAnother);
        assertThat(park.parkingCar(car), is(false));
    }

    @Test
    public void whenTruckParkingThenTrue() {
        TruckCar truck = new TruckCar("VOLVO 1", 5);
        Parking park = new Parking(10, 1);
        assertThat(park.parkingCar(truck), is(true));
    }

    @Test
    public void whenTrackParkingThenFalse() {
        TruckCar truck = new TruckCar("VOLVO 1", 5);
        PassengerCar car = new PassengerCar("BMW 1");
        Parking park = new Parking(0, 1);
        park.parkingCar(car);
        assertThat(park.parkingCar(truck), is(false));
    }

    @Test
    public void whenTrackParkingThenTrueInCarParking() {
        TruckCar truck = new TruckCar("VOLVO 1", 6);
        TruckCar truckTwo = new TruckCar("VOLVO 2", 6);
        PassengerCar car = new PassengerCar("Nissan 1");
        Parking park = new Parking(1, 12);
        park.parkingCar(car);
        park.parkingCar(truck);
        assertThat(park.parkingCar(truckTwo), is(true));
    }

    @Test
    public void whenCarRemove() {
        PassengerCar car = new PassengerCar("Nissan 1");
        Parking park = new Parking(1, 10);
        park.parkingCar(car);
        park.remove(car);
        assertThat(park.parkingCar(car), is(true));
    }

    @Test
    public void whenTruckRemoveFromParkTruck() {
        TruckCar truck = new TruckCar("VOLVO 1", 5);
        Parking park = new Parking(1, 1);
        park.parkingCar(truck);
        park.remove(truck);
        assertThat(park.parkingCar(truck), is(true));
    }

    @Test
    public void whenTruckRemoveFromParkCar() {
        TruckCar truck = new TruckCar("VOLVO 1", 5);
        Parking park = new Parking(0, 5);
        park.parkingCar(truck);
        park.remove(truck);
        assertThat(park.parkingCar(truck), is(true));
    }
}