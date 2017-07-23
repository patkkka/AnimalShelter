package com.java_academy.AnimalShelter;

import org.testng.annotations.Test;

@Test
public class AnimalShelterCreationTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAnimalShelterCreationWithIllegalCapacity() {
        //given
        int illegalCapacity = -1;
        //when
        AnimalShelter animalShelter = new AnimalShelter(illegalCapacity);
        //then
    }
}
