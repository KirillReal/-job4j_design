package ru.job4j.ood.isp;

public class ExampleISP {
    static class SMSMessage implements Message {
        //У нас есть интерфейс отправки сообщениям.Интерфейс определяет все основное,
        //что нужно для отправки сообщения:сообщение,тему, адрес отправителя и получателя,
        // метод отправки
        //пусть есть класс SMSMessage,который реализует отправку сообщений
        // по почте
        //Здесь мы сталкиваемся с нарушением принципа ISP: свойство Subject,
        // которое определяет тему сообщения,
        // при отправке смс не указывается, поэтому оно в данном классе не нужно.
        @Override
        public void send() {

        }

        @Override
        public String text() {
            return null;
        }

        @Override
        public String subject() {
            return null;
        }

        @Override
        public String toAddress() {
            return null;
        }

        @Override
        public String fromAddress() {
            return null;
        }
    }

    //Пусть у нас есть интерфейс Phone и класс Camera,реализующий этот интерфейс
    // здесь мы опять сталкиваемся с тем, что клиент - класс Camera зависит от методов,
    // которые он не использует - то есть методов Call, MakeVideo, BrowseInternet.
    static class Camera implements Phone {
        public void call() { }

        public void takePhoto() {
            System.out.println("Photo");
        }

        public void makeVideo() { }

        public void browseInternet() { }
    }

    //У нас есть интерфейс Shop и класс BookShop,реализующий этот интерфейс
    //Здесь нарушение принципа ISP  в функциях setColor() и setSize() - методы,
    // которые в данном классе
    // не будут использоваться
    static class BookShop implements Shop {

        @Override
        public void applyDiscount() {

        }

        @Override
        public void setColor() {

        }

        @Override
        public void setSize() {

        }

        @Override
        public void setCondition() {

        }

        @Override
        public void setPrice() {

        }
    }
}
