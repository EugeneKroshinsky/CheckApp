package main.java.ru.clevertec.check.utils.wrtiters;

import main.java.ru.clevertec.check.dto.check.Check;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class CsvWriter implements EnhancedWriter {
    private final SimpleDateFormat dateFormat;
    private final SimpleDateFormat timeFormat;
    private final DecimalFormat decimalFormat;
    private final String DELIMITER;

    public CsvWriter(String dateFormat, String timeFormat, String decimalFormat, String delimiter) {
        this.dateFormat = new SimpleDateFormat(dateFormat);
        this.timeFormat = new SimpleDateFormat(timeFormat);
        this.decimalFormat = new DecimalFormat(decimalFormat);
        this.DELIMITER = delimiter;
    }
    @Override
    public void write(Check check, String path) {
        try (PrintWriter fileWriter = new PrintWriter(new File(path))) {
            if (check.hasErrors()) {
                fileWriter.println("ERROR");
                fileWriter.println(check.getErrors().getFirst());
            } else {
                fileWriter.println("Date;Time;");
                fileWriter.println(dateFormat.format(check.getDate()) + DELIMITER + timeFormat.format(check.getDate()));
                fileWriter.println();
                fileWriter.print("QTY" + DELIMITER);
                fileWriter.print("DESCRIPTION" + DELIMITER);
                fileWriter.print("PRICE" + DELIMITER);
                fileWriter.print("DISCOUNT" + DELIMITER);
                fileWriter.println("TOTAL");

                check.getCheckItems().forEach(el -> {
                            fileWriter.print(el.getQuantity() + DELIMITER);
                            fileWriter.print(el.getDescription() + DELIMITER);
                            fileWriter.print(decimalFormat.format(el.getPrice()) + DELIMITER);
                            fileWriter.print(decimalFormat.format(el.getDiscount()) + DELIMITER);
                            fileWriter.println(decimalFormat.format(el.getTotal()));
                        }
                );
                if (check.hasDiscountCard()) {
                    fileWriter.println();
                    fileWriter.println("DISCOUNT CARD" + DELIMITER + "DISCOUNT PERCENTAGE");
                    fileWriter.println(check.getDiscountCard() + DELIMITER + check.getDiscountPercentage() + "%");
                }
                fileWriter.println();
                fileWriter.println("TOTAL PRICE" + DELIMITER + "TOTAL DISCOUNT" + DELIMITER + "TOTAL WITH DISCOUNT");
                fileWriter.print(decimalFormat.format(check.getTotalPrice()) + DELIMITER);
                fileWriter.print(decimalFormat.format(check.getTotalDiscount()) + DELIMITER);
                fileWriter.println(decimalFormat.format(check.getTotalWithDiscount()));
                fileWriter.close();
                fileWriter.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void write(Check check) {
        String defaultPath = "C:/github/check/src/main/java/ru/clevertec/check/result.csv";
        write(check, defaultPath);
    }
}
