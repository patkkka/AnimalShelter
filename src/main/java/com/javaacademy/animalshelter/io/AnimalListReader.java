package com.javaacademy.animalshelter.io;

import com.javaacademy.animalshelter.Animal;

import java.nio.file.Path;
import java.util.List;

public abstract class AnimalListReader {

    public abstract List<Animal> readAnimalsFromFile(Path filePath);

    protected static Animal parseAnimal(String animalLine) {
        String[] words = animalLine.split(";");
        return new Animal(words[0], words[1], words[2]);
    }
}
