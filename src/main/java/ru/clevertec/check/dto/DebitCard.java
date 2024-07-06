package main.java.ru.clevertec.check.dto;

import java.util.StringJoiner;

public class DebitCard {
    public DebitCard(double balance) {
        this.balance = balance;
    }

    public DebitCard() {
    }

    double balance;

    @Override
    public String toString() {
        return new StringJoiner(", ", DebitCard.class.getSimpleName() + "[", "]")
                .add("balance=" + balance)
                .toString();
    }
}
