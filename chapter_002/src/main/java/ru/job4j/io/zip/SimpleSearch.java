package ru.job4j.zip;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SimpleSearch {
    public static List<Path> search(Path root, String exc) throws IOException {
        SearchFiles searcher = new SearchFiles(exc);
        Files.walkFileTree(root, searcher);
        return searcher.getPath();
    }

    public static class SearchFiles extends SimpleFileVisitor<Path> {
        private final List<Path> pathsList = new ArrayList<>();
        private final String str;

        public SearchFiles(String exc) {
            this.str = exc;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!file.getFileName().toString().endsWith(str)) {
                pathsList.add(file);
            }
            return super.visitFile(file, attrs);
        }

        public List<Path> getPath() {
            return pathsList;
        }
    }
}
