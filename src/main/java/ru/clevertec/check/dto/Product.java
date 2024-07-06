package main.java.ru.clevertec.check.dto;

import java.util.StringJoiner;

public class Product {
    private int id;
    private int quantity;

    public Product() {
    }

    public Product(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("quantity=" + quantity)
                .toString();
    }
}