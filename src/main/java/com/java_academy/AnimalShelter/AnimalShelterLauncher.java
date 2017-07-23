package com.java_academy.AnimalShelter;

import com.java_academy.AnimalShelter.Exceptions.AnimalShelterFullException;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class AnimalShelterLauncher {
    static AnimalShelterLauncher launcher;
    AnimalShelter animalShelter;
    final static Logger logger = Logger.getLogger(AnimalShelterLauncher.class);

    public AnimalShelterLauncher(AnimalShelter animalShelter) {
        this.animalShelter = animalShelter;
    }

    public static void main(String[] args) {
        try {
            int shelterCapacity = Integer.parseInt(args[0]);
            AnimalShelter animalShelter = new AnimalShelter(shelterCapacity);
            launcher = new AnimalShelterLauncher(animalShelter);
            launcher.startAnimalShelter();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
    public void startAnimalShelter() {
        System.out.println("Welcome to animal shelter!");
        List<Animal> animals = readAnimalsFromFile();
        acceptAnimalsToShelter(animals);
        printAnimalsList();
        printFreePlacesNo();
    }

    public List<Animal> readAnimalsFromFile() {
        //TODO change to read from file
        List<Animal> animals = new LinkedList<>();
        animals.add(new Animal("Baki"));
        animals.add(new Animal("Pola"));
        animals.add(new Animal("Rudolf"));
        animals.add(new Animal("Fruczak gołąbek"));
        animals.add(new Animal("Rzęsorek rzeczek"));
        animals.add(new Animal("Balto"));
        animals.add(new Animal("Chester"));
        return animals;
    }

    public void acceptAnimalsToShelter(List<Animal> animals) {
        animals.forEach(animalShelter::acceptAnimal);
    }

    public void printAnimalsList() {
        animalShelter.printAnimalsList();
    }

    public void printFreePlacesNo() {
        animalShelter.printFreePlacesNo();
    }
}
