package com.javaacademy.animalshelter;

import com.javaacademy.animalshelter.exceptions.AnimalShelterFullException;

import java.util.LinkedList;
import java.util.List;

public class AnimalShelter {
    final int capacity;
    List<Animal> animals;

    public AnimalShelter(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Animal shelter capacity cannot be less or equal to 0");
        }
        this.capacity = capacity;
        animals = new LinkedList<>();
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
}
