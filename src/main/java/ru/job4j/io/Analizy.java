package ru.job4j.io;

import java.io.*;

public class Analizy {
    public static void unavailable(String source, String target) {
        try (BufferedReader reader =
                new BufferedReader(
                        new FileReader(source)); PrintWriter writer =
                new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))
        ){
            String serverUnavailable = null;
            while (reader.ready()) {
                String status = reader.readLine();
                if(serverUnavailable == null && status.startsWith("400") || status.startsWith("500")) {
                    writer.write(status.split(" ")[1] + ";");
                    serverUnavailable = status;
                }else if(serverUnavailable != null && (!status.isEmpty() && !status.startsWith("400") && !status.startsWith("500"))) {
                    writer.write(status.split(" ")[1]);
                    serverUnavailable = null;
                    writer.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
