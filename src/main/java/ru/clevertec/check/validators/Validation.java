package main.java.ru.clevertec.check.validators;

import main.java.ru.clevertec.check.dto.ValidationError;

import java.util.Optional;

public interface Validation {
    Optional<ValidationError> validate(String[] args);
}
