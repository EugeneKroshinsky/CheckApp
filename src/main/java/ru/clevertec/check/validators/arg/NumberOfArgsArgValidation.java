package main.java.ru.clevertec.check.validators.arg;

import main.java.ru.clevertec.check.dto.ValidationError;

import java.util.Optional;

public class NumberOfArgsArgValidation implements ArgValidation {
    @Override
    public Optional<ValidationError> validate(String[] args) {
        return args.length < 3
                ? Optional.of(new ValidationError("BAD REQUEST"))
                : Optional.empty();
    }

}
