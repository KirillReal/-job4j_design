package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> linesFilter = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
             in.lines().filter(b -> {
                String[] array = b.split(" ");
                return array[array.length - 2].equals("404");
            }).forEach(linesFilter :: add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linesFilter;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String str : log) {
                out.write(str + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        save(log, "404.txt");
    }
}
