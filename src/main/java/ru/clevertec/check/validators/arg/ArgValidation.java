package main.java.ru.clevertec.check.validators.arg;

import main.java.ru.clevertec.check.dto.ValidationError;

import java.util.Optional;

public interface ArgValidation {
    Optional<ValidationError> validate(String[] args);
}
