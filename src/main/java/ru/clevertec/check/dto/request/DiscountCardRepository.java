package main.java.ru.clevertec.check.dto.request;

import java.util.StringJoiner;

public class DiscountCardRepository extends DiscountCard{
    double percentage; //TODO
    int id;

    public DiscountCardRepository() {
    }

    public DiscountCardRepository(int number, double percentage, int id) {
        super(number);
        this.percentage = percentage;
        this.id = id;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setId(int name) {
        this.id = id;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DiscountCardRepository.class.getSimpleName() + "[", "]")
                .add("percentage=" + percentage)
                .add("id=" + id)
                .add("number=" + this.getNumber())
                .toString();
    }
}
