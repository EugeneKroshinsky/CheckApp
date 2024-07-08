package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.dto.*;
import java.util.Date;

public class CalculateCheckService {
    public Check calculate(Request request) {
        Check check = new Check();
        check.setDate(new Date());
        check.setCheckItems(request.getProducts());

        double totalPrice = check.getCheckItems().stream()
                .map(CheckItem::getTotal)
                .reduce(Double::sum).orElse(0d);
        check.setTotalPrice(totalPrice);

/*        double totalDiscount = check.getCheckItems().stream()
                .map(CheckItem::getDiscount)
                .reduce(Double::sum).orElse(0d);
        check.setTotalDiscount(totalDiscount);

        double totalWithDiscount = totalPrice - totalDiscount;*/

        return check;
    }
}
