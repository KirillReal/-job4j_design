package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;

public class Dublicate  {
    public Dublicate() {
        super();
    }

    public static void main(String[] args) {
        final Map<File,List<File>> duplicates = new HashMap<>();
        Dublicate.handleDirectory(duplicates, new File("[path to base directory]"));
    }
    private static void handleDirectory(final Map<File, List<File>> duplicates, final File directory) {
        final Iterator<Entry<File, List<File>>> iterator = duplicates.entrySet().iterator();
        while (iterator.hasNext()) {
            final Entry<File, List<File>> next = iterator.next();
            if(next.getValue().size() == 0) {
                iterator.remove();
            } else {
                if (directory.isDirectory()) {
                    final File[] files = directory.listFiles();
                    assert files != null;
                    for (final File file : files) {
                        if (file.isDirectory()) {
                            continue;
                        }
                        final File myFile = new File(file.getAbsolutePath());
                        if (!duplicates.containsKey(myFile)) {
                            duplicates.put(myFile, new Vector<>());
                        } else {
                            duplicates.get(myFile).add(myFile);
                        }
                    }
                }
                System.out.println(next.getKey() + " - " + next.getKey().getAbsolutePath());
                for(final File file : next.getValue()) {
                    System.out.println(file.getName() + " - " + file.getAbsolutePath());
                }
            }
        }

    }
}
