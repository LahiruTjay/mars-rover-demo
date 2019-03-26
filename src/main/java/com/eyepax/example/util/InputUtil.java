package com.eyepax.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.eyepax.example.exception.InvalidFileFormatException;

public class InputUtil {

    public static List<String> readTextFile(String fileName) throws IOException {
        try {
            List<String> lines = Files.lines(Paths.get(fileName)).collect(Collectors.toList());
            if (lines.size() > 0) {
                if (lines.size() % 2 == 0) {
                    throw new InvalidFileFormatException("Incorrect file format found");
                }
                return lines;
            } else {
                throw new InvalidFileFormatException("Empty file found");
            }
        } catch (NoSuchFileException e) {
            throw new NoSuchFileException(String.format("%s - file not found", fileName));
        }
    }

    public static boolean isRoverCommandLinesEmpty(String line1, String line2) {
        return line1.trim().isEmpty() || line2.trim().isEmpty();
    }

}
