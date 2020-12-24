package ru.job4j.io;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zip {
    public void packFiles(List<File> sources, File target) throws IOException {
        try(ZipOutputStream zin = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target))))
        {
            Iterator<File> it = sources.iterator();
            while(it.hasNext()) {
                zin.putNextEntry((new ZipEntry(it.next().toPath().toFile().getPath())));
                try (BufferedInputStream tar = new BufferedInputStream(new FileInputStream(it.next().toPath().toFile()))) {
                    zin.write(tar.readAllBytes());
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Zip().packSingleFile(
                new File("./chapter_005/pom.xml"),
                new File("./chapter_005/pom.zip")
        );
    }
}
