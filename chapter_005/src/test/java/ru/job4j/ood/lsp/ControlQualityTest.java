package ru.job4j.ood.lsp;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void executeStrategyTrash() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.FEBRUARY, 27);
        dateExpired.set(2021, Calendar.FEBRUARY, 8);
        Food milk = new Milk("milk", dateCreated, dateExpired, 1000, 0);
        WareHouse warehouse = new WareHouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality control = new ControlQuality(List.of(shop, trash, warehouse));
        control.executeStrategy(milk);
        assertThat(milk.getName(), is(trash.getFoodList().get(0).getName()));
    }

    @Test
    public void executeStrategyWarehouse() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.JANUARY, 30);
        dateExpired.set(2021, Calendar.FEBRUARY, 30);
        Food bread = new Bread("bread", dateCreated, dateExpired, 100, 0);
        WareHouse warehouse = new WareHouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality control = new ControlQuality(List.of(shop, trash, warehouse));
        control.executeStrategy(bread);
        assertThat(bread.getName(), is(warehouse.getFoodList().get(0).getName()));
    }

}