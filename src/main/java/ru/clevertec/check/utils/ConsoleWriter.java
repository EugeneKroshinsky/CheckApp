package main.java.ru.clevertec.check.utils;

import main.java.ru.clevertec.check.dto.Check;
import main.java.ru.clevertec.check.utils.CheckWriter;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ConsoleWriter implements CheckWriter {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    @Override
    public void write(Check check) {
        if (check.hasErrors()) {
            System.out.println("ERROR");
            System.out.println(check.getErrors().getFirst());
        } else {
            System.out.println("   Date   |   Time   ");
            System.out.println(dateFormat.format(check.getDate()) + " | " + timeFormat.format(check.getDate()));
            System.out.println();

            System.out.println("*********| QTY | DESCRIPTION | PRICE | DISCOUNT | TOTAL");
            check.getCheckItems().forEach(System.out::println);
            System.out.println();

            System.out.println("TOTAL PRICE | TOTAL DISCOUNT | TOTAL WITH DISCOUNT");
//            System.out.println(check.getTotalPrice() + "|" + check.getTotalDiscount() + "|" + check.getTotalWithDiscount());
            System.out.println(decimalFormat.format(check.getTotalPrice()));
        }

    }
}
