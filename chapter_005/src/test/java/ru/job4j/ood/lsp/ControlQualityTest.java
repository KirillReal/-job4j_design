package ru.job4j.ood.lsp;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void executeStrategyTrash() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.FEBRUARY, 30);
        dateExpired.set(2021, Calendar.FEBRUARY, 28);
        Food milk = new Milk("milk", dateCreated, dateExpired, 1000, 0);
        List<Strategy> strategyList = new ArrayList<>();
        ControlQuality control = new ControlQuality(strategyList);
        control.executeStrategy(milk);
        assertThat(milk, is(strategyList.get(0)));
    }

    @Test
    public void executeStrategyWarehouse() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.JANUARY, 30);
        dateExpired.set(2021, Calendar.FEBRUARY, 15);
        Food bread = new Bread("bread", dateCreated, dateExpired, 100, 0);
        List<Strategy> strategyList = new ArrayList<>();
        ControlQuality control = new ControlQuality(strategyList);
        control.executeStrategy(bread);
        assertThat(bread, is(strategyList.get(0)));
    }

    @Test
    public void executeStrategyShopNoDiscount() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.FEBRUARY, 5);
        dateExpired.set(2021, Calendar.FEBRUARY, 20);
        Food bread = new Bread("bread", dateCreated, dateExpired, 100, 0);
        List<Strategy> strategyList = new ArrayList<>();
        ControlQuality control = new ControlQuality(strategyList);
        control.executeStrategy(bread);
        assertThat(bread, is(strategyList.get(0)));
    }

    @Ignore
    public void executeStrategyShopDiscount() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.JANUARY, 10);
        dateExpired.set(2021, Calendar.FEBRUARY, 2);
        Food bread = new Bread("bread", dateCreated, dateExpired, 100, 0);
        List<Strategy> strategyList = new ArrayList<>();
        ControlQuality control = new ControlQuality(strategyList);
        control.executeStrategy(bread);
        assertThat(75, is(strategyList.get(0)));
    }
}