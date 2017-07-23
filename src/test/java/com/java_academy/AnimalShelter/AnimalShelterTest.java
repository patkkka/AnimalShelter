package com.java_academy.AnimalShelter;

import com.java_academy.AnimalShelter.Exceptions.AnimalShelterFullException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

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
        assertEquals(freePlacesNo, shelterCapacity);
    }

    @Test
    public void testCalculateFreePlacesNoWithSomeAnimalsInsideShelter() {
        //given
        List<Animal> animals = new LinkedList<>();
        animals.add(new Animal("Baki"));
        animals.add(new Animal("Mruczek"));
        //when
        animals.forEach(animalShelter::acceptAnimal);
        int freePlacesNo = animalShelter.calculateFreePlacesNo();
        //then
        assertEquals(freePlacesNo, (shelterCapacity - animals.size()));
    }

    @Test(expectedExceptions = AnimalShelterFullException.class)
    public void testAcceptAnimalWhenShelterFull() {
        //given
        List<Animal> animals = new LinkedList<>();
        animals.add(new Animal("Baki"));
        animals.add(new Animal("Mruczek"));
        animals.add(new Animal("Pola"));
        animals.add(new Animal("Rudolf"));
        //when
        animals.forEach(animalShelter::acceptAnimal);
        //then
    }
}
