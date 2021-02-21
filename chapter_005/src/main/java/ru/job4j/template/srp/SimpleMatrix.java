package ru.job4j.template.srp;

import java.io.FileOutputStream;

public class SimpleMatrix implements MatrixExample{
    //Первая проблема в том что возвращается строка вместо массива
    @Override
    public String Matrix(int size) {
        StringBuilder rsl = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rsl.append((i + 1) * (j + 1));
                if (j + 1 != size) {
                    rsl.append(" ");
                }
            }
            rsl.append(System.lineSeparator());
        }
        return rsl.toString();
    }
    //Вторая проблема - разные абстракции:создание таблицы и её сохранение
    //Третья проблема - источник для сохранения таблицы создается в методе
    @Override
    public void saveMatrix(String matrix) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(matrix.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

