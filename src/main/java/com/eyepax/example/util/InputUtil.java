package com.eyepax.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.eyepax.example.exception.InvalidFileFormatException;

public class InputUtil {

    /**
     * This method reads the file and return {@link List} of Strings pertaining to the lines.
     * Performs validations of the file.
     * 
     * @param fileName
     * @return
     * @throws IOException, InvalidFileFormatException, NoSuchFileException
     */
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

    /**
     * This method checks whether two Strings are empty and return a boolean.
     * 
     * @param line1 - String line one
     * @param line2 - String line two
     * @return - boolean true if one or both lines are empty
     */
    public static boolean isRoverCommandLinesEmpty(String line1, String line2) {
        return line1.trim().isEmpty() || line2.trim().isEmpty();
    }

}
