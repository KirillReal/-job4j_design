package ru.job4j.email;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserEmailTest {
    @Test
    public void convert() {
        List<UserEmail> users = new ArrayList<>();
        List<String> userEmails1 = List.of("xxx@ya.ru",
                "foo@gmail.com", "lol@mail.ru");
        UserEmail user1 = new UserEmail("Вася", userEmails1);
        List<String> userEmails2 = List.of("foo@gmail.com", "ups@pisem.net");
        UserEmail user2 = new UserEmail("Петя", userEmails2);
        List<String> userEmails3 = List.of("xyz@pisem.net", "vasya@pupkin.com");
        UserEmail user3 = new UserEmail("Женя", userEmails3);
        List<String> userEmails4 = List.of("foo@gmail.com", "ups@pisem.net");
        UserEmail user4 = new UserEmail("Витя", userEmails4);
        List<String> userEmails5 = List.of("xyz@pisem.net");
        UserEmail user5 = new UserEmail("Даня", userEmails5);
        List<String> userEmails6 = List.of("vasya@pupkin.com", "aaa@bbb.ru", "ups@pisem");
        UserEmail user6 = new UserEmail("Андрей", userEmails6);
        List<String> userEmails7 = List.of("vasya@pupkin.com", "aaa@bbb.ru", "ups@pisem");
        UserEmail user7 = new UserEmail("Стас", userEmails7);
        List<String> userEmails8 = List.of("vasya@pupkin.com");
        UserEmail user8 = new UserEmail("Саша", userEmails8);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        Map<String, Set<String>> usersNew = UserEmail.convert(users);
        assertEquals(1,usersNew.size());
    }
}