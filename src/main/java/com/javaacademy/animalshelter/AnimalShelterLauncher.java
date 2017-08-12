package com.javaacademy.animalshelter;

import com.javaacademy.animalshelter.exceptions.AnimalShelterFullException;
import com.javaacademy.animalshelter.fileio.*;
import com.javaacademy.animalshelter.userio.AnimalShelterParametersParser;
import com.javaacademy.animalshelter.userio.AnimalShelterStatePrinter;
import org.apache.commons.cli.*;
import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class AnimalShelterLauncher {
    public static final Path ANIMALS_FILE_PATH = Paths.get("src/main/resources/list_of_animals");
    final static Logger logger = Logger.getLogger(AnimalShelterLauncher.class);
    AnimalShelter animalShelter;
    AnimalShelterParametersParser parametersParser;

    public AnimalShelterLauncher() {
        this.parametersParser = new AnimalShelterParametersParser();
    }

    public static void main(String[] args) {
        AnimalShelterLauncher launcher = new AnimalShelterLauncher();
        try {
            launcher.parseAnimalShelterParameters(args);
            launcher.startAnimalShelter();
        } catch (ParseException | IllegalArgumentException e) {
            launcher.printHelpOptions();
        }
    }

    private void parseAnimalShelterParameters(String[] args) throws ParseException {
        parametersParser.parseArgs(args);
    }

    private void startAnimalShelter() throws IllegalArgumentException {
        createNewAnimalShelter();
        acceptAnimalsFromFile();
        printAnimalsList();
        printFreePlacesNo();
        storeAnimalsToFile();
    }

    private void printHelpOptions() {
        parametersParser.printHelpOptions();
    }

    private void createNewAnimalShelter() {
        AnimalShelterStatePrinter.printWelcomeMessage();
        animalShelter = new AnimalShelter(parametersParser.parseShelterCapacity());
    }

    private void acceptAnimalsFromFile() {
        Path animalsListPath = parametersParser.parseAnimalsListFilePath();
        Collection<Animal> animals = readAnimalsFromFile(animalsListPath);
        acceptAnimalsToShelter(animals);
    }

    private void storeAnimalsToFile() {
        Path animalsListPath = parametersParser.parseAnimalsListFilePath();
        if (!animalsListPath.equals(ANIMALS_FILE_PATH)) {
            AnimalListWriter animalListWriter = new TxtAnimalListWriter();
            animalListWriter.writeAnimalsToFile(animalShelter.getAnimals(), ANIMALS_FILE_PATH);
        }
    }

    private Collection<Animal> readAnimalsFromFile(Path animalsListPath) {
        AnimalListReader animalListReader = new TxtAnimalListReader();
        return animalListReader.readAnimalsFromFile(animalsListPath);
    }

    private void acceptAnimalsToShelter(Collection<Animal> animals) {
        try {
            animals.forEach(animalShelter::acceptAnimal);
        } catch (AnimalShelterFullException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void printAnimalsList() {
        if (parametersParser.isPrintAnimalsListOptionEnabled()) {
            animalShelter.printAnimalsList();
        }
    }

    private void printFreePlacesNo() {
        if (parametersParser.isPrintFreePlacesOptionEnabled()) {
            animalShelter.printFreePlacesNo();
        }
    }
}
