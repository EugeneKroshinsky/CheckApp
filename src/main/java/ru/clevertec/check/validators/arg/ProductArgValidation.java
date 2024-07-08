package main.java.ru.clevertec.check.validators.arg;

import main.java.ru.clevertec.check.dto.ValidationError;

import java.util.Optional;

public class ProductArgValidation implements ArgValidation {
    @Override
    public Optional<ValidationError> validate(String[] args) {
        for (int i = 0; i < args.length - 2; i++) {
            try {
                String[] parts = args[i].split("-");
                int id = Integer.parseInt(parts[0]);
                int quantity = Integer.parseInt(parts[1]);
            } catch (Exception e) {
                return Optional.of(new ValidationError("BAD REQUEST"));
            }
        }
        return Optional.empty();
    }
}
