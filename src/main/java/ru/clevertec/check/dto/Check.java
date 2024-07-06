package main.java.ru.clevertec.check.dto;

import java.util.Date;
import java.util.List;

public class Check {
    private Date date;

    public Check() {
    }

    public Check(Date date, List<CheckItem> checkItems,
                 int discountCard,
                 int discountPercentage,
                 double totalPrice,
                 double totalDiscount,
                 double totalWithDiscount) {
        this.date = date;
        this.checkItems = checkItems;
        this.discountCard = discountCard;
        this.discountPercentage = discountPercentage;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalWithDiscount = totalWithDiscount;
    }

    public Date getDate() {
        return date;
    }

    public List<CheckItem> getCheckItems() {
        return checkItems;
    }

    public int getDiscountCard() {
        return discountCard;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTotalWithDiscount() {
        return totalWithDiscount;
    }

    private List<CheckItem> checkItems;

    private int discountCard;
    private int discountPercentage;

    private double totalPrice;
    private double totalDiscount;
    private double totalWithDiscount;
}
