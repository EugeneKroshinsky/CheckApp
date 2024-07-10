package main.java.ru.clevertec.check.dto;

import java.util.StringJoiner;

public class ValidationError {
    String name;

    public ValidationError(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(",", ValidationError.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
