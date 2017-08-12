package com.javaacademy.animalshelter.userio;

import com.javaacademy.animalshelter.Animal;

import java.util.Set;

public class AnimalShelterStatePrinter {
    public static void printAnimalsInShelter(Set<Animal> animals) {
        System.out.println("Animals in shelter:");
        animals.forEach(System.out::println);
    }

    public static void printFreePlacesNoInShelter(int freePlaces) {
        System.out.println(String.format("Number of free places in animal shelter: %d", freePlaces));
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to Animal Shelter!");
    }
}
