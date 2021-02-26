package ru.job4j.ood.lsp;

import java.util.Calendar;
import java.time.LocalDate;

public class Food {
    private String name;
    private Calendar expiryDate;
    private Calendar createDate;
    private int price;
    private double discount;

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", expiryDate=" + expiryDate +
                ", createDate=" + createDate +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }

    public Food(String name,Calendar expiryDate,Calendar createDate, int price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpireDate() {
        return expiryDate;
    }

    public void setExpireDate(Calendar expireDate) {
        this.expiryDate = expireDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
