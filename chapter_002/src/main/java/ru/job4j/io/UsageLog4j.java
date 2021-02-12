package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
       String str = "str";
       short s = 2;
       boolean b = false;
       int i = 23;
       char c = 'c';
       double d = 3.14;
       long l = 12423412;
       byte b1 = 1;
        LOG.debug("Variables info String : {},"
                +  " short : {}, int : {}, "
                + " boolean : {}, char : {}, "
                + " double : {}, long : {}, "
                + "byte : {}", str, s, i, b, c, d, l, b1);

    }
}
