package com.java_academy.AnimalShelter;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class LaunchingAnimalShelterTest {
    @Test
    public void testLaunchingAnimalShelterWithGivenCapacity() {
        //given
        int shelterCapacity = 3;
        String[] mainArgs = new String[1];
        mainArgs[0] = String.valueOf(shelterCapacity);
        //when
        Main.main(mainArgs);
        //then
        assertEquals(Main.animalShelter.capacity, shelterCapacity);
    }
}
