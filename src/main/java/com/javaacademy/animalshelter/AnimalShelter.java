package com.javaacademy.animalshelter;

import com.javaacademy.animalshelter.exceptions.AnimalShelterFullException;
import com.javaacademy.animalshelter.userio.AnimalShelterStatePrinter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AnimalShelter {
    final int capacity;
    Set<Animal> animals;

    public AnimalShelter(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Animal shelter capacity cannot be less or equal to 0");
        }
        this.capacity = capacity;
        animals = new HashSet<>();
    }

    public void acceptAnimal(Animal animal) {
        if (isShelterFull()) {
            throw new AnimalShelterFullException("Animal shelter is already full!");
        }
        animals.add(animal);
    }

    int calculateFreePlacesNo() {
        return (capacity - animals.size());
    }

    private boolean isShelterFull() {
        return (calculateFreePlacesNo() <= 0);
    }

    public void printAnimalsList() {
        new AnimalShelterStatePrinter().printAnimalsInShelter(this.animals);
    }

    public void printFreePlacesNo() {
        new AnimalShelterStatePrinter().printFreePlacesNoInShelter(calculateFreePlacesNo());
    }

    public Collection<Animal> getAnimals() {
        return new HashSet<Animal>(animals);
    }
}
