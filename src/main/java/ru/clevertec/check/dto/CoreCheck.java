package main.java.ru.clevertec.check.dto;

import java.util.List;

public class CoreCheck {
    List<ValidationError> errors;

    public CoreCheck(List<ValidationError> errors) {
        this.errors = errors;
    }

    public CoreCheck() {
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }
}
