package com.javaacademy.animalshelter.fileio;

import com.javaacademy.animalshelter.Animal;

import java.nio.file.Path;
import java.util.Collection;

public abstract class AnimalListReader {

    public abstract Collection<Animal> readAnimalsFromFile(Path filePath);

    protected static Animal parseAnimal(String animalLine) {
        String[] words = animalLine.split(";");
        return new Animal(words[0], words[1], words[2]);
    }
}
