package com.javaacademy.animalshelter;

public class Animal {
    private final String breed;
    private final String name;

    public Animal(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.breed + ": " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;

        Animal animal = (Animal) o;

        if (!breed.equals(animal.breed)) return false;
        return name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        int result = breed.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
