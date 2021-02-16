package ru.job4j.gc.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cache {
    private static Map<String,SoftReference<String>> storage;
    private final String pathTofile;

    public Cache(String pathTofile) {
        this.pathTofile = pathTofile;
        storage = new HashMap<>();
    }

    public String get(String filename) throws IOException {
        SoftReference<String> file = storage.get(filename);
        if(file == null || file.get() == null) {
            return load(filename);
        }
        String result = file.get();
        if(result == null) {
            result = load(filename);
        }
        return result;
    }

    private String load(String filename) throws IOException {
        String content;
        try(BufferedReader reader = new BufferedReader(new FileReader(pathTofile + "/" + filename) )) {
            content = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            storage.put(filename,new SoftReference<>(content));
        }
        return content;
    }
}
