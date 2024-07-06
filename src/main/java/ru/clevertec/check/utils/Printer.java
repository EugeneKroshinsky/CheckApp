package main.java.ru.clevertec.check.utils;

import main.java.ru.clevertec.check.dto.Check;

public class Printer {
    private CheckWriter checkWriter;

    public Printer(CheckWriter checkWriter) {
        this.checkWriter = checkWriter;
    }

    public Printer() {
    }

    public void setCheckWriter(CheckWriter checkWriter) {
        this.checkWriter = checkWriter;
    }

    public void print(Check check) {
         if (checkWriter != null) {
             checkWriter.write(check);
         } else {
             //TODO: create exception
         }
     }
}
