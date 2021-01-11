package ru.job4j.search;

import java.io.File;

public class ArgsSearch {
    private final String[] args;

    public ArgsSearch(String[] args) {
        this.args = args;
    }

    public boolean checkValid () {
       File file = new File(directory());
       return file.isDirectory();
    }
    public String directory() {
        return args[1];
    }

    public String name() {
        return args[3];
    }

    public String type() {
        return args[4].substring(1);
    }

    public String output() {
        return args[6];
    }

}
