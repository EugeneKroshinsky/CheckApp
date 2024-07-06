package main.java.ru.clevertec.check.utils;

import main.java.ru.clevertec.check.dto.Check;
import main.java.ru.clevertec.check.utils.CheckWriter;

public class ConsoleWriter implements CheckWriter {
    @Override
    public void write(Check check) {
        if(check.hasErrors()) {
            System.out.println(check.getErrors().getFirst());
        } else {
            System.out.println("Date | Time");
            System.out.println(check.getDate() + "|" + check.getDate().getTime());

            System.out.println("QTY | DESCRIPTION | PRICE | DISCOUNT | TOTAL");
            check.getCheckItems().forEach(System.out::println);

            System.out.println("DISCOUNT CARD | DISCOUNT PERCENTAGE");
            System.out.println(check.getDiscountCard() + "|" + check.getDiscountPercentage());

            System.out.println("TOTAL PRICE | TOTAL DISCOUNT | TOTAL WITH DISCOUNT");
            System.out.println(check.getTotalPrice() + "|" + check.getTotalDiscount() + "|" + check.getTotalWithDiscount());
        }

    }
}
