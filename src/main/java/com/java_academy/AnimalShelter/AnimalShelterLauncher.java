package com.java_academy.AnimalShelter;

import com.java_academy.AnimalShelter.Exceptions.AnimalShelterFullException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    private void startAnimalShelter() {
        System.out.println("Welcome to animal shelter!");
        //get animals from file
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("list_of_animals").getPath();
        List<Animal> animals = readAnimalsFromFile(path);
        //accept animals to shelter and print animal shelter state
        acceptAnimalsToShelter(animals);
        printAnimalsList();
        printFreePlacesNo();
    }

    List<Animal> readAnimalsFromFile(String filePath) {
        List<Animal> animals = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null){
                animals.add(new Animal(line));
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return animals;
    }

    private void acceptAnimalsToShelter(List<Animal> animals) {
        try{
            animals.forEach(animalShelter::acceptAnimal);
        } catch (AnimalShelterFullException e){
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
