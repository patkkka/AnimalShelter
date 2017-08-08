package com.javaacademy.animalshelter;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AnimalShelterLauncherTest {
    final int animalShelterCapacity = 10;

    @Test
    public void shouldReadAnimalsFromFile() {
        //given
        AnimalShelter animalShelter = new AnimalShelter(animalShelterCapacity);
        AnimalShelterLauncher launcher = new AnimalShelterLauncher(animalShelter);
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("list_of_animals").getPath(); //file with 9 animals
        int animalsNoInFile = 9;
        //when
        List<Animal> animals = launcher.readAnimalsFromFile(path);
        //then
        assertTrue(animals.contains(new Animal("Baki")));
        assertTrue(animals.contains(new Animal("Fruczak gołąbek")));
        assertTrue(animals.contains(new Animal("Test")));
        assertEquals(animals.size(), animalsNoInFile);
    }

    @Test
    public void shouldReadAnimalsFromEmptyFile() {
        //given
        AnimalShelter animalShelter = new AnimalShelter(animalShelterCapacity);
        AnimalShelterLauncher launcher = new AnimalShelterLauncher(animalShelter);
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("list_of_animals_empty").getPath();
        //when
        List<Animal> animals = launcher.readAnimalsFromFile(path);
        //then
        assertTrue(animals.isEmpty());
    }
}
