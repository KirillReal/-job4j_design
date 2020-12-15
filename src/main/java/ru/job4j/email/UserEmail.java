package ru.job4j.email;

import java.util.*;

public class UserEmail {
    private String name;
    private final List<String> address;

    public UserEmail (String name, List<String> address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Map<String, Set<String>> convert(List<UserEmail> input) {
        Map<String, Set<String>> first = new HashMap<>();

        for(UserEmail userEmail : input) {
            Iterator<String> iterator = userEmail.getAddress().iterator();
            Set<String> second = new HashSet<>(userEmail.getAddress());
            if(!first.isEmpty()) {
                for (Set<String> s : first.values()) {
                    if (s.contains(iterator.next())) {
                        s.addAll(userEmail.getAddress());
                    }
                }
            }else {
                first.put(userEmail.getName(), second);
            }
        }
        return first;
    }
}
