package main.java.ru.clevertec.check.validators.check;

import main.java.ru.clevertec.check.dto.ValidationError;
import main.java.ru.clevertec.check.dto.check.Check;

import java.util.Optional;

public interface CheckValidation {
    Optional<ValidationError> validate(Check check);
}
