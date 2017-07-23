package com.java_academy.AnimalShelter;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class AnimalShelterLauncherTest {
    @Test
    public void testAnimalShelterLauncherWithGivenCapacity() {
        //given
        int shelterCapacity = 10;
        String[] mainArgs = new String[1];
        mainArgs[0] = String.valueOf(shelterCapacity);
        //when
        AnimalShelterLauncher.main(mainArgs);
        //then
        assertEquals(AnimalShelterLauncher.launcher.animalShelter.capacity, shelterCapacity);
    }
}
