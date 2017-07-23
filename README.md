# About

Simple Animal Shelter application, which takes argument for shelter capacity and accepts animals from file.
It is not possible to accept more animals than capacity of shelter is.
All exceptions are logged to file.

# How to run the program?
- To test: mvn test 
- To execute: mvn exec:java -Dexec.mainClass="com.java_academy.AnimalShelter.AnimalShelterLauncher" -Dexec.args="10" (where argument 10 is example of animal shelter capacity)
- To check logs go to "logs" folder in project directory

# TODO List

https://trello.com/b/dlK6mvme/schronisko

# Tests list

- [x] Check if shelter capacity is equal to passed argument when launching program
- [] Check application, when given capacity is invalid
- [x] Accept animal, when there are free places
- [x] Accept animal, when there are no more free places
- [x] Calculate free places number just after animal shelter creation
- [x] Calculate free places number, when animal shelter is partially filled
- [x] Print animals in shelter
- [] Read animals list from file
-

# Questions
- I've made capacity and animals fields in AnimalShelter class package-private just for test it in testLaunchingAnimalShelterWithGivenCapacity() & testAcceptAnimal() methods. Is it right approach to test it making access to fields or is it better to create 'get' methods or something else?
- Should AnimalShelterFullException be RuntimeException or Exception...?


