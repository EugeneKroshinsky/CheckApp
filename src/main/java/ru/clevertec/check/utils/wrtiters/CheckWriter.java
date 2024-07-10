package main.java.ru.clevertec.check.utils.wrtiters;

import main.java.ru.clevertec.check.dto.check.Check;

import java.io.IOException;

public interface CheckWriter  {
    void write(Check check) throws IOException;
}
