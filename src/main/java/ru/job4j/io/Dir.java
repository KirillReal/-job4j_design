package ru.job4j.io;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Dir {
    public static void main(String[] args) {
        if(args.length == 0) {
            throw new NoSuchElementException();
        }
        File file = new File(args[0]);
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
