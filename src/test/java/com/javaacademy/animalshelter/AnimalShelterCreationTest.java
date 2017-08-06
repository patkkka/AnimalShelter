package com.javaacademy.animalshelter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AnimalShelterCreationTest {

    @DataProvider
    public Object[][] illegalCapacity() {
        return new Object[][] {
                {0},
                {-1},
        };
    }

    @DataProvider
    public Object[][] legalCapacity() {
        return new Object[][] {
                {1},
                {10},
        };
    }

    @Test(dataProvider = "illegalCapacity", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCreatedWithNegativeCapacity(int illegalCapacity) {
        AnimalShelter animalShelter = new AnimalShelter(illegalCapacity);
    }

    @Test(dataProvider = "legalCapacity")
    public void shouldCreateAnimalShelterWithGivenCapacity(int legalCapacity) {
        //when
        AnimalShelter animalShelter = new AnimalShelter(legalCapacity);
        //then
        assertEquals(animalShelter.calculateFreePlacesNo(), legalCapacity);
    }
}
