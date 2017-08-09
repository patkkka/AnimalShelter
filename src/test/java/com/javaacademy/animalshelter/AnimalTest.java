package com.javaacademy.animalshelter;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AnimalTest {
    @Test
    public void shouldReturnAnimalAsString() {
        //given
        Animal animal = new Animal("pies", "Pola");
        //when
        String animalAsString = animal.toString();
        //then
        assertEquals(animalAsString, "pies: Pola");
    }

    @Test
    public void animalsShouldBeEqual() {
        //given
        Animal animal1 = new Animal("pies", "Pola");
        Animal animal2 = new Animal("pies", "Pola");
        //when
        //then
        assertTrue(animal1.equals(animal2));
    }

    @Test
    public void animalsWithDifferentNamesShouldBeDifferent() {
        //given
        Animal animal1 = new Animal("pies", "Pola");
        Animal animal2 = new Animal("pies", "Baki");
        //when
        //then
        assertFalse(animal1.equals(animal2));
    }

    @Test
    public void animalsWithDifferentBreedsShouldBeDifferent() {
        //given
        Animal animal1 = new Animal("pies", "Pola");
        Animal animal2 = new Animal("tarsier", "Pola");
        //when
        //then
        assertFalse(animal1.equals(animal2));
    }

    @Test
    public void theSameAnimalsShouldHaveTheSameHashCode() {
        //given
        Animal animal1 = new Animal("pies", "Pola");
        Animal animal2 = new Animal("pies", "Pola");
        //when
        //then
        assertEquals(animal1.hashCode(), animal2.hashCode());
    }
}