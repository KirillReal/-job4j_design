package ru.job4j.ood.ocp;

import java.util.ArrayList;

public class Example {
    //ссылка не абстрактного типа а конкретной реализации
    private Truck truck;

    public interface Transport {

    }

    private static class Truck implements Transport {

    }
    //для самолета и корабля можно было создать метод move() в интерфейсе транспорт

    private static class Plane {
        public String move() {
            return "fly";
        }
    }

    private static class Ship {
        public String move() {
            return "sail";
        }
    }

    // Возвращаем реализацию а не абстракцию
    public ArrayList<String> getArrayList() {
        return new ArrayList<>();
    }
}
