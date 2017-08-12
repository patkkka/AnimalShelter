package com.javaacademy.animalshelter.fileio;

import com.javaacademy.animalshelter.Animal;

import java.nio.file.Path;
import java.util.Collection;

public abstract class AnimalListWriter {

    public abstract void writeAnimalsToFile(Collection<Animal> animals, Path filePath);

    protected static String parseAnimal(Animal animal) {
        return animal.parseAnimalToTxt();
    }
}
