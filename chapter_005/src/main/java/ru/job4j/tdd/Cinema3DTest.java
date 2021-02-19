package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class Cinema3DTest {
    @Ignore
    @Test
    public void find() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenFalseBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2019, Calendar.JANUARY, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Ignore
    @Test
    public void whenFindFalse() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.size(), is(0));
    }

    @Ignore
    @Test
    public void buy() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Collections.singletonList(new Session3D())));
    }
}