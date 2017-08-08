package com.javaacademy.animalshelter.io;

import com.javaacademy.animalshelter.Animal;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class AnimalListReader {
    final static Logger logger = Logger.getLogger(AnimalListReader.class);

    public static List<Animal> readAnimalsFromFile(Path filePath) {
        List<Animal> animals = new LinkedList<>();
        try (BufferedReader br = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                Animal animal = parseAnimal(line);
                animals.add(animal);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return animals;
    }

    private static Animal parseAnimal(String animalLine) {
        String[] words = animalLine.split("\\s+");
        return new Animal(words[0], words[1]);
    }
}
