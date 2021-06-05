package ru.job4j.ood.dip;

import java.lang.module.Configuration;

public class Book {
    public void print(String text) {
        System.out.print(text);
    }
}

//Класс Book, представляющий книгу, использует для печати класс ConsolePrinter.
// При подобном определении класс Book зависит от класса ConsolePrinter.
// Более того мы жестко определили, что печать книгу можно только на
// консоли с помощью класса ConsolePrinter.
// Другие же варианты, например, вывод на принтер, вывод в файл
// - все это в данном случае исключено.
// Абстракция печати книги не отделена от деталей класса ConsolePrinter.
// Все это является нарушением принципа инверсии зависимостей.
class ConsolePrinter extends Book {
    public void print(String text) {
        System.out.println(text);
    }
}

class ConcreteDependency {

}

// ConcreteClass он зависит от "композиции" - ConsoleDependency!Нарушение принципа DIP
class ConcreteClass extends ConcreteDependency {
    public ConcreteClass(ConcreteDependency dependency) {

    }
}

//В приведенном выше классе LightBulb мы написали методы turnOn ()
// и turnOff () для включения и выключения лампочки.

class LightBulb {

    public void turnOn() {
        System.out.println("LightBulb: Bulb turned on...");
    }

    public void turnOff() {
        System.out.println("LightBulb: Bulb turned off...");
    }
}

//Наш высокоуровневый класс ElectricPowerSwitch напрямую зависит от низкоуровневого
// класса LightBulb.
//класс LightBulb жестко запрограммирован в ElectricPowerSwitch.
// Но выключатель не должен быть привязан к лампочке. Он должен иметь возможность включать
// и выключать другие приборы и устройства, например вентилятор, кондиционер
// и тд. Теперь представьте, какие модификации нам потребуются в классе ElectricPowerSwitch каждый
// раз, когда мы добавляем новое устройство.
// Мы можем сделать вывод, что наш дизайн ошибочен, и нам необходимо пересмотреть его,
// следуя принципу инверсии зависимостей.
class ElectricPowerSwitch extends LightBulb {
    private LightBulb lightBulb;
    private boolean on;

    public ElectricPowerSwitch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
        this.on = false;
    }

    public boolean isOn() {
        return this.on;
    }

    public void press() {
        boolean checkOn = isOn();
        if (checkOn) {
            lightBulb.turnOff();
            this.on = false;
        } else {
            lightBulb.turnOn();
            this.on = true;
        }
    }
}