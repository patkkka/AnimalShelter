package com.java_academy.AnimalShelter;

public class Main {
    static AnimalShelter animalShelter;

    public static void main(String[] args) {
        int shelterCapacity = Integer.parseInt(args[0]);
        animalShelter = new AnimalShelter(shelterCapacity);
        System.out.println("Welcome to animal shelter!");
    }
}
