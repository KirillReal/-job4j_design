package ru.job4j.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    @SuppressWarnings("DeclarationOrder")

    private final List<String> answers = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public String getBotAnswer() {
        if (answers.isEmpty()) {
            try (BufferedReader in = new BufferedReader(
                    new FileReader(botAnswers))) {
                in.lines().forEach(answers::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return answers.get((int) (Math.random() * answers.size()));
    }

    public void run() throws FileNotFoundException {
        boolean running = true;
        boolean stop = false;
        StringBuilder log = new StringBuilder();
        try (BufferedReader consoleReader = new BufferedReader(
                new InputStreamReader(System.in))) {
            while (running) {
                String input = consoleReader.readLine();
                String bot = getBotAnswer();
                if (input.equals(OUT)) {
                    running = false;
                    log.append(input).append(System.lineSeparator());
                } else if (input.equals(STOP)) {
                    stop = true;
                    log.append(input).append(System.lineSeparator());
                } else if (stop && input.equals(CONTINUE)) {
                    stop = false;
                }
                if (!stop && running) {
                    System.out.println(bot);
                    log.append(input).append(System.lineSeparator()).
                            append(bot).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(path)))) {
            out.write(String.valueOf(log));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ConsoleChat cc = new ConsoleChat("./src/data/log.txt",
                "./src/data/text.txt");
        cc.run();
    }
}
