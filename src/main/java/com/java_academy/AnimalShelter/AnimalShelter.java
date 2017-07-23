package com.java_academy.AnimalShelter;

import com.java_academy.AnimalShelter.Exceptions.AnimalShelterFullException;

import java.util.LinkedList;
import java.util.List;

public class AnimalShelter {
    final int capacity;
    private int freePlacesNo;
    private List<Animal> animals;

    public AnimalShelter(int capacity) {
        this.capacity = capacity;
        this.freePlacesNo = capacity;
        animals = new LinkedList<>();
    }

    public void acceptAnimal(Animal animal) throws AnimalShelterFullException {
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
}
