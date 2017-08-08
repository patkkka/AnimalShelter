package com.javaacademy.animalshelter;

import com.javaacademy.animalshelter.exceptions.AnimalShelterFullException;
import com.javaacademy.animalshelter.io.AnimalListReader;
import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AnimalShelterLauncher {
    AnimalShelter animalShelter;
    final static Logger logger = Logger.getLogger(AnimalShelterLauncher.class);

    public AnimalShelterLauncher(AnimalShelter animalShelter) {
        this.animalShelter = animalShelter;
    }

    public static void main(String[] args) {
        try {
            int shelterCapacity = Integer.parseInt(args[0]);
            Path animalsListPath = Paths.get(args[1]);
            AnimalShelter animalShelter = new AnimalShelter(shelterCapacity);
            AnimalShelterLauncher launcher = new AnimalShelterLauncher(animalShelter);
            launcher.startAnimalShelter(animalsListPath);
        } catch (AnimalShelterFullException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void startAnimalShelter(Path animalsListPath) {
        System.out.println("Welcome to animal shelter!");
        //get animals from file
        List<Animal> animals = AnimalListReader.readAnimalsFromFile(animalsListPath);
        //accept animals to shelter and print animal shelter state
        acceptAnimalsToShelter(animals);
        printAnimalsList();
        printFreePlacesNo();
    }

    private void acceptAnimalsToShelter(List<Animal> animals) {
        try {
            animals.forEach(animalShelter::acceptAnimal);
        } catch (AnimalShelterFullException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void printAnimalsList() {
        animalShelter.printAnimalsList();
    }

    private void printFreePlacesNo() {
        animalShelter.printFreePlacesNo();
    }
}
