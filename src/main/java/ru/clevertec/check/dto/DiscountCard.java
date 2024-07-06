package main.java. ru.clevertec.check.dto;

import java.util.StringJoiner;

public class DiscountCard {
    public DiscountCard(int number) {
        this.number = number;
    }

    public DiscountCard() {
    }

    private int number;

    @Override
    public String toString() {
        return new StringJoiner(", ", DiscountCard.class.getSimpleName() + "[", "]")
                .add("number=" + number)
                .toString();
    }
}
