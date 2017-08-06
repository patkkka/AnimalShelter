package com.javaacademy.animalshelter;

import java.util.List;

public class AnimalShelterStatePrinter {
    public void printAnimalsInShelter(List<Animal> animals) {
        System.out.println("Animals in shelter:");
        animals.forEach(System.out::println);
    }

    public void printFreePlacesNoInShelter(int freePlaces) {
        System.out.println(String.format("Number of free places in animal shelter: %d", freePlaces));
    }
}
