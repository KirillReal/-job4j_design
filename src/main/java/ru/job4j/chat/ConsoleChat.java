package ru.job4j.chat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private final String botAnswer;
    private final  List<String> botAnswers;
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    @SuppressWarnings("DeclarationOrder")
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswer) {
        this.botAnswer = botAnswer;
        this.botAnswers = getBotAnswer();
    }

    public List<String> getBotAnswer () {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswer,CHARSET))
        ){
            reader.lines().forEach(answers :: add);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return answers;
    }

    private String getAnswer () {
        Random rand = new Random();
        return botAnswers.get(rand.nextInt(botAnswers.size()));
    }

    public void run() throws FileNotFoundException {
        boolean run = true;
        boolean pause = false;
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                String input = bufferedReader.readLine();
                String bot = getAnswer();
                if(input.equals(OUT)) {
                    run = false;
                    list.add(input);
                }else if (input.equals(STOP)) {
                    pause = true;
                    list.add(input);
                }else if(pause && input.equals(CONTINUE)) {
                    pause = false;
                }
                if (!pause && run) {
                    System.out.println(bot);
                    list.add(input + System.lineSeparator()
                            + bot + System.lineSeparator());
                }

            }while (run);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ConsoleChat cc = new ConsoleChat("./src/data/log.txt",
                "./src/data/text.txt");
        cc.run();
    }
}
