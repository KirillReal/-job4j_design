package ru.job4j.email;

import java.util.*;

public class UserEmail {
    private String name;
    private Set<String> address;

    public UserEmail(String name, Set<String> address) {
        this.name = name;
        this.address = address;
    }

    public UserEmail() {

    }

    public String getName() {
        return name;
    }

    public Set<String> getAddress() {
        return address;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void convert(List<UserEmail> input) {
        Map<String, UserEmail> emails = new HashMap<>();
        Map<UserEmail, UserEmail> temp = new HashMap<>();
        Set<UserEmail> unique = new HashSet<>();
        for (UserEmail userEmail : input) {
            boolean rsl = true;
            for (String s: userEmail.getAddress()) {
                UserEmail prevUser = emails.putIfAbsent(s, userEmail);
                if (prevUser != null) {
                    prevUser = temp.getOrDefault(prevUser, prevUser);
                    prevUser.setAddress(userEmail.getAddress());
                    temp.put(userEmail, prevUser);
                    rsl = false;
                }
        }
            if (rsl) {
                unique.add(userEmail);
            }
        }
        for (UserEmail user: unique) {
            System.out.println(user.getName() + " " + user.getAddress());
        }
    }

}
