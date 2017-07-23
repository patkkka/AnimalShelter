package com.java_academy.AnimalShelter;

import com.java_academy.AnimalShelter.Exceptions.AnimalShelterFullException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class AnimalShelterTest {
    private final int shelterCapacity = 3;
    private AnimalShelter animalShelter;

    @BeforeMethod
    public void createNewAnimalShelter() {
        animalShelter = new AnimalShelter(shelterCapacity);
    }

    @Test
    public void testCalculateFreePlacesNoJustAfterCreation() {
        //given
        //when
        int freePlacesNo = animalShelter.calculateFreePlacesNo();
        //then
        assertEquals(freePlacesNo, shelterCapacity, "Wrong initialization of shelter capacity");
    }

    @Test
    public void testCalculateFreePlacesNoWithSomeAnimalsInsideShelter() {
        //given
        List<Animal> animals = createAnimalList(new String[]{"Baki","Mruczek"});
        //when
        animals.forEach(animalShelter::acceptAnimal);
        int freePlacesNo = animalShelter.calculateFreePlacesNo();
        //then
        assertEquals(freePlacesNo, (shelterCapacity - animals.size()), "Wrong calculation of free places");
    }

    @Test
    public void testAcceptAnimal() {
        //given
        Animal dogBaki = new Animal("Baki");
        //when
        animalShelter.acceptAnimal(dogBaki);
        //then
        assertEquals(animalShelter.animals.size(), 1, "Animals list size is other than 1, when a dog was accepted");
        assertTrue(animalShelter.animals.contains(dogBaki));
    }

    @Test(expectedExceptions = AnimalShelterFullException.class)
    public void testAcceptAnimalWhenShelterFull() {
        //given
        List<Animal> animals = createAnimalList(new String[]{"Baki","Pola","Rudolf","Futrzak"});
        //when
        //add 4 animals when shelter capacity is 3
        animals.forEach(animalShelter::acceptAnimal);
        //then
    }

    @Test
    public void testPrintAnimals() {
        //given
        List<Animal> animals = createAnimalList(new String[]{"Baki","Pola","Rudolf"});
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //when
        animals.forEach(animalShelter::acceptAnimal);
        animalShelter.printAnimalsList();
        String expectedOutput  = "Animals in shelter:\n" +
                                 "Baki\n" +
                                 "Pola\n" +
                                 "Rudolf\n";
        //then
        assertEquals(outContent.toString(), expectedOutput, "Wrong animals list printing");
    }

    @Test
    public void testPrintFreePlacesNo() {
        //given
        List<Animal> animals = createAnimalList(new String[]{"Baki","Mruczek"});
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //when
        animals.forEach(animalShelter::acceptAnimal);
        animalShelter.printFreePlacesNo();
        int freePlacesNo = animalShelter.calculateFreePlacesNo();
        String expectedOutput  = String.format(
                "Number of free places in animal shelter: %d\n", freePlacesNo);
        //then
        assertEquals(outContent.toString(), expectedOutput, "Wrong free places number printing");
    }

    public List<Animal> createAnimalList (String[] names){
        List<Animal> animals = Arrays
                                    .stream(names)
                                    .map(Animal::new)
                                    .collect(Collectors.toList());
        return animals;
    }
}
