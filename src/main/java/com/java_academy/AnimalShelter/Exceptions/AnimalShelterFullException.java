package com.java_academy.AnimalShelter.Exceptions;

public class AnimalShelterFullException extends RuntimeException {
    //should be RuntimeException or Exception?

    public AnimalShelterFullException(String message) {
        super(message);
    }
}
