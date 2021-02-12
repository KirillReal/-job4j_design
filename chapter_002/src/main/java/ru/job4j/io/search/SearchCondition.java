package ru.job4j.search;

import ru.job4j.io.SearchFiles;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchCondition {
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPath();
    }

    public static void save(List<Path> log, String file) {
        try (
            PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(new
                            FileOutputStream(file))
            )) {
            log.forEach(out :: println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Predicate<Path> createPredicate(String name, String type) {
        Predicate<Path> predicate = path -> path.getFileName().toString().equals(name);
        switch (type) {
            case "r":
                Pattern pattern = Pattern.compile(name);
                predicate = path -> pattern.matcher(path.getFileName().toString()).find();
                break;
            case "f":
                break;
            case "m":
                String fileName = name.replace("*", "");
                predicate = path -> path.getFileName().toString().contains(fileName);
                break;
            default:
                System.out.println("Введён неправильный ключ");
                break;
        }
        return predicate;
    }

    public static void main(String[] args) throws IOException {
        ArgsSearch argsSearch = new ArgsSearch(args);
        if (!argsSearch.checkValid()) {
            Predicate<Path> predicate = createPredicate(argsSearch.name(), argsSearch.type());
            Path start = Paths.get(argsSearch.directory());
            List<Path> files = search(start, predicate);
            save(files, argsSearch.output());
        }
    }
}


