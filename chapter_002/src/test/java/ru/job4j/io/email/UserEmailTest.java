package ru.job4j.email;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class UserEmailTest {
    @Test
    public void convert() {
        UserEmail test = new UserEmail();
        List<UserEmail> source = Arrays.asList(
                new UserEmail("user1", new HashSet<>(Arrays.asList(
                        "xxx@ya.ru",
                        "foo@gmail.com",
                        "lol@mail.ru"))),
                new UserEmail("user2", new HashSet<>(Arrays.asList(
                        "foo@gmail.com",
                        "ups@pisem.net"))),
                new UserEmail("user3", new HashSet<>(Arrays.asList(
                        "xyz@pisem.net",
                        "vasya@pupkin.com"))),
                new UserEmail("user4", new HashSet<>(Arrays.asList(
                        "ups@pisem.net",
                        "aaa@bbb.ru"))),

                new UserEmail("user5", new HashSet<>(Collections.singletonList(
                        "xyz@pisem.net")))
        );
        test.convert(source);
    }
}