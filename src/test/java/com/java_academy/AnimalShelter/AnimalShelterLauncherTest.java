package com.java_academy.AnimalShelter;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class AnimalShelterLauncherTest {
    final int animalShelterCapacity = 10;
    @Test
    public void testAnimalShelterLauncherWithGivenCapacity() {
        //given
        String[] mainArgs = new String[1];
        mainArgs[0] = String.valueOf(animalShelterCapacity);
        //when
        AnimalShelterLauncher.main(mainArgs);
        //then
        assertEquals(AnimalShelterLauncher.launcher.animalShelter.capacity, animalShelterCapacity);
    }

    @Test
    public void testReadAnimalsFromFile() {
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
    public void testReadAnimalsFromEmptyFile() {
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

    @Test
    public void testAnimalShelterLauncher() {
        //given
        String[] mainArgs = new String[1];
        mainArgs[0] = String.valueOf(animalShelterCapacity);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //when
        AnimalShelterLauncher.main(mainArgs);
        String expectedOutput  = "Welcome to animal shelter!\n" +
                "Animals in shelter:\n" +
                "Baki\n" +
                "Pola\n" +
                "Rudolf\n" +
                "Fruczak gołąbek\n" +
                "Rzęsorek rzeczek\n" +
                "Balto\n" +
                "Chester\n" +
                "Futrzak\n" +
                "Test\n" +
                "Number of free places in animal shelter: 1\n";
        //then
        assertEquals(outContent.toString(), expectedOutput);
    }
}
