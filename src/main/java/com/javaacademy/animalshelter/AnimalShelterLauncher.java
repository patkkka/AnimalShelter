package com.javaacademy.animalshelter;

import com.javaacademy.animalshelter.exceptions.AnimalShelterFullException;
import com.javaacademy.animalshelter.io.AnimalListReader;
import com.javaacademy.animalshelter.io.AnimalShelterStatePrinter;
import com.javaacademy.animalshelter.io.TxtAnimalListReader;
import org.apache.commons.cli.*;
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
        Options options = createCmdOptions();
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            int shelterCapacity = parseShelterCapacity(cmd);

            AnimalShelter animalShelter = new AnimalShelter(shelterCapacity);
            AnimalShelterLauncher launcher = new AnimalShelterLauncher(animalShelter);
            launcher.startAnimalShelter(cmd);
        } catch (ParseException | IllegalArgumentException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "animalshelter", options );
        } catch (AnimalShelterFullException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private static Path parseAnimalsListFilePath(CommandLine cmd) {
        Path animalsListPath = Paths.get("src/main/resources/list_of_animals");

        return animalsListPath;
    }

    private static Options createCmdOptions() {
        Options options = new Options();
        options.addOption("c", "capacity", true, "animal shelter capacity - positive integer number");
        options.addOption("f", "filepath", true, "path to the file with animals list");
        options.addOption("p", "printanimals", false, "prints animals in shelter");
        options.addOption("q", "freeplaces", false, "prints how many free places are in the shelter");
        return options;
    }

    private static int parseShelterCapacity(CommandLine cmd) {
        int shelterCapacity = 0;
        if (cmd.hasOption("c")) {
             shelterCapacity = Integer.parseInt(cmd.getOptionValue("c"));
        }
        return shelterCapacity;
    }

    private void startAnimalShelter(CommandLine cmd) {
        AnimalShelterStatePrinter.printWelcomeMessage();
        Path animalsListPath = parseAnimalsListFilePath(cmd);
        //get animals from file
        AnimalListReader animalListReader = new TxtAnimalListReader();
        List<Animal> animals = animalListReader.readAnimalsFromFile(animalsListPath);
        //accept animals to shelter
        acceptAnimalsToShelter(animals);
        //print information
        if (cmd.hasOption("p")) {
            printAnimalsList();
        }
        if (cmd.hasOption("q")) {
            printFreePlacesNo();
        }
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
