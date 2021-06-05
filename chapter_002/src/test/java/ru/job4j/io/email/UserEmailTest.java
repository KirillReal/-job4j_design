package ru.job4j.io.email;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class UserEmailTest {
    @Test
    public void convert() {
        ru.job4j.email.UserEmail test = new ru.job4j.email.UserEmail();
        List<ru.job4j.email.UserEmail> source = Arrays.asList(
                new ru.job4j.email.UserEmail("user1", new HashSet<>(Arrays.asList(
                        "xxx@ya.ru",
                        "foo@gmail.com",
                        "lol@mail.ru"))),
                new ru.job4j.email.UserEmail("user2", new HashSet<>(Arrays.asList(
                        "foo@gmail.com",
                        "ups@pisem.net"))),
                new ru.job4j.email.UserEmail("user3", new HashSet<>(Arrays.asList(
                        "xyz@pisem.net",
                        "vasya@pupkin.com"))),
                new ru.job4j.email.UserEmail("user4", new HashSet<>(Arrays.asList(
                        "ups@pisem.net",
                        "aaa@bbb.ru"))),

                new ru.job4j.email.UserEmail("user5", new HashSet<>(Collections.singletonList(
                        "xyz@pisem.net")))
        );
        test.convert(source);
    }
}