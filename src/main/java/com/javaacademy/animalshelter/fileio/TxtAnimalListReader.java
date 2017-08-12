package com.javaacademy.animalshelter.fileio;

import com.javaacademy.animalshelter.Animal;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TxtAnimalListReader extends AnimalListReader{
    final static Logger logger = Logger.getLogger(AnimalListReader.class);

    @Override
    public Collection<Animal> readAnimalsFromFile(Path filePath) {
        Collection<Animal> animals = new LinkedList<>();
        try {
            List<String> animalsList = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            animalsList.forEach((animalLineString) -> {
                Animal animal = parseAnimal(animalLineString);
                animals.add(animal);
            });
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return animals;
    }
}
