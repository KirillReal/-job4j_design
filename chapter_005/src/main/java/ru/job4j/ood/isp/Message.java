package ru.job4j.ood.isp;

public interface Message {
    void send();

    String text();

    String subject();

    String toAddress();

    String fromAddress();
}
