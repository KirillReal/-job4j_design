package ru.job4j.map;

import java.util.*;

public class User {
    private final String name;
    private final int age;
    private final Calendar birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

   @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public User(String name, int age, Calendar birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Ivan", 23, new GregorianCalendar(1996, Calendar.APRIL, 5));
        User user2 = new User("Ivan", 23, new GregorianCalendar(1996, Calendar.APRIL, 5));
        User user3 = new User("Ivan", 23, new GregorianCalendar(1996, Calendar.APRIL, 5));
        Map<User, Object> map = new HashMap<>();
        map.put(user1,1);
        map.put(user2,2);
        for (Map.Entry<User,Object> entry:  map.entrySet()) {
            User key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
