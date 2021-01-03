package ru.job4j.io;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.TreeSet;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream inStream = new FileInputStream("even.txt")) {
            Scanner scanner = new Scanner(System.in);
            scanner = new Scanner(inStream);
            TreeSet<Integer> set = new TreeSet<>();
            while (scanner.hasNext()) {
                int data = scanner.nextInt();
                if (data % 2 == 0) {
                    set.add(data);
                }
            }
            for (int i : set) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
