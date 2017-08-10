package com.javaacademy.animalshelter.io;

import com.javaacademy.animalshelter.Animal;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TxtAnimalListReaderTest {
    TxtAnimalListReader txtAnimalListReader;

    @BeforeClass
    public void setUp() {
        txtAnimalListReader = new TxtAnimalListReader();
    }

    @Test
    public void shouldReadAnimalsFromFile() throws URISyntaxException {
        //given
        Path path = Paths.get(ClassLoader.getSystemResource("list_of_animals").toURI()); //file with 10 animals
        int animalsNoInFile = 10;
        //when
        List<Animal> animals = txtAnimalListReader.readAnimalsFromFile(path);
        //then
        assertEquals(animals.size(), animalsNoInFile);
        assertTrue(animals.contains(new Animal("pies", "Baki")));
        assertTrue(animals.contains(new Animal("pies", "Balto")));
        assertTrue(animals.contains(new Animal("zimorodek", "Kuba")));
    }

    @Test
    public void shouldReadNoAnimalsFromEmptyFile() throws URISyntaxException {
        //given
        Path path = Paths.get(ClassLoader.getSystemResource("list_of_animals_empty").toURI());
        //when
        List<Animal> animals = txtAnimalListReader.readAnimalsFromFile(path);
        //then
        assertTrue(animals.isEmpty());
    }

}