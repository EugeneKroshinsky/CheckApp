package main.java.ru.clevertec.check.utils.wrtiters;
import main.java.ru.clevertec.check.dto.check.Check;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class ConsoleWriter implements CheckWriter{
    private final SimpleDateFormat dateFormat;
    private final SimpleDateFormat timeFormat;
    private final DecimalFormat decimalFormat;

    public ConsoleWriter(String dateFormat, String timeFormat, String decimalFormat) {
        this.dateFormat = new SimpleDateFormat(dateFormat);
        this.timeFormat = new SimpleDateFormat(timeFormat);
        this.decimalFormat = new DecimalFormat(decimalFormat);
    }

    @Override
    public void write(Check check) {
        if (check.hasErrors()) {
            System.out.println("ERROR");
            System.out.println(check.getErrors().getFirst());
        } else {
            System.out.println("Date:");
            System.out.println(dateFormat.format(check.getDate()));
            System.out.println("Time:");
            System.out.println(timeFormat.format(check.getDate()));
            System.out.println("------------------------------");
            check.getCheckItems().forEach(System.out::println);
            System.out.println("------------------------------");
            if (check.hasDiscountCard()) {
                System.out.println("Discount card:");
                System.out.println(check.getDiscountCard());
                System.out.println("Discount percentage:");
                System.out.println(check.getDiscountPercentage() + "%");
                System.out.println("------------------------------");
            }
            System.out.println("TOTAL PRICE:");
            System.out.println(decimalFormat.format(check.getTotalPrice()));
            System.out.println("TOTAL DISCOUNT:");
            System.out.println(decimalFormat.format(check.getTotalDiscount()));
            System.out.println("TOTAL WITH DISCOUNT:");
            System.out.println(decimalFormat.format(check.getTotalWithDiscount()));
        }

    }
}
