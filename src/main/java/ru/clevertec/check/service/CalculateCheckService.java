package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.dto.check.Check;
import main.java.ru.clevertec.check.dto.check.CheckItem;
import main.java.ru.clevertec.check.dto.request.Request;

import java.util.Date;

public class CalculateCheckService {
    public Check calculate(Request request) {
        Check check = new Check();
        check.setDate(new Date());
        check.setCheckItems(request.getCheckItems());
        check.setDebitCard(request.getDebitCard());
        check.setProducts(request.getProducts());
        if (request.getDiscountCard() != null) {
            check.setDiscountCard(request.getDiscountCard().getNumber());
            check.setDiscountPercentage((int)(request.getDiscountCard().getPercentage() * 100));
        }
        check.setTotalPrice(getTotalPrice(check));
        check.setTotalDiscount(getTotalDiscount(check));
        check.setTotalWithDiscount(check.getTotalPrice() - check.getTotalWithDiscount());
        return check;
    }
    private double getTotalPrice(Check check) {
        return check.getCheckItems().stream()
                .map(CheckItem::getTotal)
                .reduce(Double::sum).orElse(0d);
    }
    private double getTotalDiscount(Check check) {
        return check.getCheckItems().stream()
                .map(CheckItem::getDiscount)
                .reduce(Double::sum).orElse(0d);
    }
}
