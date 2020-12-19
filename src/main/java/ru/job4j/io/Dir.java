package ru.job4j.io;

import java.io.File;
import java.util.Objects;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");

        if (!file.exists()) {
            throw new IllegalArgumentException("Not exist %s");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }

        for (File f: Objects.requireNonNull(file.listFiles())) {
            System.out.println(f.getName() + " - " +  f.length());
        }
    }
}
