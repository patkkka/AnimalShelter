package com.javaacademy.animalshelter.userio;

import com.javaacademy.animalshelter.AnimalShelterLauncher;
import org.apache.commons.cli.*;
import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AnimalShelterParametersParser {
    final static Logger logger = Logger.getLogger(AnimalShelterLauncher.class);
    private CommandLine cmd;
    private Options options;

    public AnimalShelterParametersParser() {
        options = createCmdOptions();
    }

    public void parseArgs(String [] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        cmd = parser.parse(options, args);
    }

    public int parseShelterCapacity() {
        int shelterCapacity = 0;
        if (cmd.hasOption("c")) {
            shelterCapacity = Integer.parseInt(cmd.getOptionValue("c"));
        }
        return shelterCapacity;
    }
    
    public Path parseAnimalsListFilePath() {
        Path animalsListPath = AnimalShelterLauncher.ANIMALS_FILE_PATH;
        if (cmd.hasOption("f")) {
            animalsListPath = Paths.get(cmd.getOptionValue("f"));
        }
        return animalsListPath;
    }

    public Options createCmdOptions() {
        Options options = new Options();
        options.addOption("c", "capacity", true, "<arg> is animal shelter capacity - positive integer number");
        options.addOption("f", "filepath", true, "<arg> is path to the file with animals list");
        options.addOption("p", "printanimals", false, "prints animals in shelter");
        options.addOption("q", "freeplaces", false, "prints how many free places are in the shelter");
        return options;
    }

    public void printHelpOptions() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("animalshelter", options);
    }

    public boolean isPrintFreePlacesOptionEnabled() {
        return cmd.hasOption("q");
    }

    public boolean isPrintAnimalsListOptionEnabled() {
        return cmd.hasOption("p");
    }
}
