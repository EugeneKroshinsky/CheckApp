package main.java.ru.clevertec.check.dto;

import java.text.DecimalFormat;
import java.util.StringJoiner;

public class CheckItem {
    private int quantity;
    private double price;
    private double discount;
    private double total;
    private int quantityInShop;
    private String description;

    public CheckItem() {
    }

    public CheckItem(int quantity, double price, double discount, double total, int quantityInShop, String description) {
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.total = total;
        this.quantityInShop = quantityInShop;
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotal() {
        return total;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantityInShop() {
        return quantityInShop;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setQuantityInShop(int quantityInShop) {
        this.quantityInShop = quantityInShop;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return new StringJoiner(", ", CheckItem.class.getSimpleName() + "[", "]")
                .add("quantity=" + quantity)
                .add("description='" + description + "'")
                .add("price=" + decimalFormat.format(price))
                .add("discount=" + decimalFormat.format(discount))
                .add("total=" + decimalFormat.format(total))
                .toString();
    }
}