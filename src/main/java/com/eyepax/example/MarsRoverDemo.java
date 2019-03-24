package com.eyepax.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.eyepax.example.model.Plateau;

public class MarsRoverDemo {

    public static void main(String[] args) throws IOException {

        String fileName = "input.txt";
        List<String> commandList = Files.lines(Paths.get(fileName)).collect(Collectors.toList());

        Plateau plateau = Plateau.intializePlateau(commandList.get(0));

        for (int i = 1; i < commandList.size(); i += 2) {
            System.out.println(commandList.get(i) + " " + commandList.get(i + 1));
        }

    }

}
