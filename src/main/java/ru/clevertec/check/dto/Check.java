package main.java.ru.clevertec.check.dto;

import javax.swing.text.ChangedCharSetException;
import java.util.Date;
import java.util.List;

public class Check extends CoreCheck{
    private Date date;
    private List<CheckItem> checkItems;

    private int discountCard;
    private int discountPercentage;

    private double totalPrice;
    private double totalDiscount;
    private double totalWithDiscount;

    public Check(List<ValidationError> errors) {
        super(errors);
    }
    public Check(Date date, List<CheckItem> checkItems,
                 int discountCard,
                 int discountPercentage,
                 double totalPrice,
                 double totalDiscount,
                 double totalWithDiscount) {
        super();
        this.date = date;
        this.checkItems = checkItems;
        this.discountCard = discountCard;
        this.discountPercentage = discountPercentage;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalWithDiscount = totalWithDiscount;
    }

    public Check() {
        super();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCheckItems(List<CheckItem> checkItems) {
        this.checkItems = checkItems;
    }

    public void setDiscountCard(int discountCard) {
        this.discountCard = discountCard;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public void setTotalWithDiscount(double totalWithDiscount) {
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



}
