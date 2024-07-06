package main.java.ru.clevertec.check.validators;

import main.java.ru.clevertec.check.dto.ValidationError;

import java.util.Optional;

public class NumberOfArgsValidation implements Validation{
    @Override
    public Optional<ValidationError> validate(String[] args) {
        return args.length > 2
                ? Optional.empty()
                : Optional.of(new ValidationError("Недостаточно аргументов"));
    }

}
