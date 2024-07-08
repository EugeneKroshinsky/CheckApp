package main.java.ru.clevertec.check.validators.arg;

import main.java.ru.clevertec.check.dto.ValidationError;

import java.util.Optional;

public class DiscountCardArgValidation implements ArgValidation {
    @Override
    public Optional<ValidationError> validate(String[] args) {
        try {
            String[] part = args[args.length - 2].split("=");
            int result = Integer.parseInt(part[1]);
            if (!part[0].equals("discountCard")) {
                return Optional.of(new ValidationError("BAD REQUEST"));
            }
        } catch (Exception e) {
            return Optional.of(new ValidationError("BAD REQUEST"));
        }
        return Optional.empty();
    }
}
