package main.java.ru.clevertec.check.dto;

public class CheckItem {
    private int quantity;
    private double price;
    private double discount;

    public CheckItem() {
    }

    public CheckItem(int quantity, double price, double discount) {
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckItem{");
        sb.append("  |  ").append(quantity);
        sb.append("  |  ").append(price);
        sb.append("  |  ").append(discount);
        sb.append('}');
        return sb.toString();
    }
}
