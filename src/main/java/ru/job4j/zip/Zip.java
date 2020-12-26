package ru.job4j.zip;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zip {
    public void packFiles(List<Path> sources, File target) throws IOException {
        try (ZipOutputStream zin = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            Iterator<Path> it = sources.iterator();
            while (it.hasNext()) {
                zin.putNextEntry((new ZipEntry(it.next().toFile().getPath())));
                try (BufferedInputStream tar = new BufferedInputStream(new FileInputStream(it.next().toFile()))) {
                    zin.write(tar.readAllBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*
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
    */
    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        argZip.setValue();
        List<Path> list = SimpleSearch.search(Paths.get(argZip.getValue("d")),(argZip.getValue("e")));
        new Zip().packFiles(list, new File(argZip.output()));
    }

}
