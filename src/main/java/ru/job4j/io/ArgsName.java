package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {

        String validate = values.get(key);
        if(validate == null) {
            throw new IllegalArgumentException();
        }
        return validate;
    }

    private void parse(String[] args) {
        for(String s : args) {
            String[] arr = s.split("=");
            if (arr.length != 2) {
                throw new IllegalArgumentException();
            }
            values.put(arr[0].replaceFirst("-", ""),arr[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
