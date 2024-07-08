package main.java.ru.clevertec.check.utils;

import java.io.File;
import java.util.List;

public interface FileReader {
    List<List<String>> read(File file, String delimiter);
}
