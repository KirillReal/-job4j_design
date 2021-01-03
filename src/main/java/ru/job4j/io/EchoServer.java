package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if(str.equals("http://localhost:9000/?msg=Hello")) {
                        out.write("Hello".getBytes());
                    } else if (str.equals("http://localhost:9000/?msg=Exit")) {
                        in.close();
                        out.close();
                        socket.close();
                        server.close();
                    }else {
                        str = Stream.of(str.split(" "))
                                .filter(s -> s.contains("msg"))
                                .findFirst()
                                .orElse("");
                        System.out.println("msg: " + str);
                    }
                    String[] arrStr = str.split("=");
                    str = arrStr[1];
                    out.write("HTTP/1.1 200 OK\r\n\r\n".concat(str).getBytes());
                }
            }
    }
}
}
