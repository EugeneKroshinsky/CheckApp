package main.java.ru.clevertec.check.validators.request;

import main.java.ru.clevertec.check.dto.request.Request;
import main.java.ru.clevertec.check.dto.ValidationError;

import java.util.List;

public interface RequestValidator {
    List<ValidationError> validate(Request request);
}
