package main.java.ru.clevertec.check.dto.request;

import java.util.StringJoiner;

public class DebitCard {
    private double balance;

    public DebitCard(double balance) {
        this.balance = balance;
    }

    public DebitCard() {
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DebitCard.class.getSimpleName() + "[", "]")
                .add("balance=" + balance)
                .toString();
    }
}
