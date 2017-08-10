package com.javaacademy.animalshelter;

import com.javaacademy.animalshelter.exceptions.AnimalShelterFullException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AnimalShelterTest {
    private final int shelterCapacity = 3;
    private AnimalShelter animalShelter;

    @BeforeMethod
    public void setUp() {
        animalShelter = new AnimalShelter(shelterCapacity);
    }

    @Test
    public void shouldReturnShelterCapacityForFreePlacesNoCalc() {
        //given
        //when
        int freePlacesNo = animalShelter.calculateFreePlacesNo();
        //then
        assertEquals(freePlacesNo, shelterCapacity, "Wrong initialization of shelter capacity");
    }

    @Test
    public void shouldCalculateFreePlacesNoWhenSomeAnimalsInsideShelter() {
        //given
        Set<Animal> animals = createAnimalSet(new String[]{"Baki", "Mruczek"});
        //when
        animals.forEach(animalShelter::acceptAnimal);
        int freePlacesNo = animalShelter.calculateFreePlacesNo();
        //then
        assertEquals(freePlacesNo, (shelterCapacity - animals.size()), "Wrong calculation of free places");
    }

    @Test
    public void shouldAcceptAnimal() {
        //given
        Animal dogBaki = new Animal("pies", "Baki");
        //when
        animalShelter.acceptAnimal(dogBaki);
        //then
        assertEquals(animalShelter.animals.size(), 1, "Animals list size is other than 1, when a dog was accepted");
        assertTrue(animalShelter.animals.contains(dogBaki));
    }

    @Test(expectedExceptions = AnimalShelterFullException.class)
    public void shouldNotAcceptAnimalWhenShelterIsFull() {
        //given
        Set<Animal> animals = createAnimalSet(new String[]{"Baki", "Pola", "Rudolf", "Futrzak"});
        //when
        //add 4 animals when shelter capacity is 3
        animals.forEach(animalShelter::acceptAnimal);
        //then
    }

    public Set<Animal> createAnimalSet(String[] names) {
        Set<Animal> animals = Arrays
                .stream(names)
                .map(name -> new Animal("pies", name))
                .collect(Collectors.toSet());
        return animals;
    }
}
