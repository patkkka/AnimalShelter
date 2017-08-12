package com.javaacademy.animalshelter.fileio;

import com.javaacademy.animalshelter.Animal;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

public class TxtAnimalListWriter extends AnimalListWriter {
    final static Logger logger = Logger.getLogger(AnimalListReader.class);

    @Override
    public void writeAnimalsToFile(Collection<Animal> animals, Path filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            animals.forEach(animal -> {
                try {
                    writer.write(animal.parseAnimalToTxt());
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            });
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
