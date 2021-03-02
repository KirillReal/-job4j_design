package ru.job4j.ood.isp;

public interface Message {
    void Send();
    String Text();
    String Subject();
    String ToAddress ();
    String FromAddress ();
}
