package main.java.ru.clevertec.check.dto.request;

import java.util.Objects;
import java.util.StringJoiner;

public class DiscountCard {
    public DiscountCard(int number) {
        this.number = number;
    }

    public DiscountCard() {
    }

    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DiscountCard.class.getSimpleName() + "[", "]")
                .add("number=" + number)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
