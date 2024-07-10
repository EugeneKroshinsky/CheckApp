package main.java.ru.clevertec.check.utils.writers;

import main.java.ru.clevertec.check.dto.check.Check;

interface EnhancedWriter extends CheckWriter {
    void write(Check check, String path);
}
