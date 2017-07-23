# About

Simple Animal Shelter application, which takes argument for shelter capacity and accepts animals from file.
It is not possible to accept more animals than capacity of shelter is.
All exceptions are logged to file.

# How to run the program?
- To test: mvn test 
- To execute: mvn exec:java -Dexec.mainClass="com.java_academy.AnimalShelter.AnimalShelterLauncher" -Dexec.args="10" (where argument 10 is example of animal shelter capacity)
- To modify animals list: go to src/main/resources/list\_of\_animals in project directory
- To check logs: go to "logs" folder in project directory

# TODO List

https://trello.com/b/dlK6mvme/schronisko

# Tests list

- [x] Check if shelter capacity is equal to passed argument when launching program
- [x] Launch program and check if output is as expected
- [x] Check animal shelter creation, when capacity is illegal
- [x] Accept animal, when there are free places
- [x] Accept animal, when there are no more free places
- [x] Calculate free places number just after animal shelter creation
- [x] Calculate free places number, when animal shelter is partially filled
- [x] Print animals in shelter
- [x] Print number of free places in shelter
- [x] Read animals list from file
- [x] Read animals list from empty file

# Questions
- I've made capacity and animals fields in AnimalShelter class package-private just for test it in testLaunchingAnimalShelterWithGivenCapacity() & testAcceptAnimal() methods. Is it right approach to test it making access to fields or is it better to create 'get' methods or something else?
- Should AnimalShelterFullException be RuntimeException or Exception...? I started with checked Exception, but it was annoying and I couldn't use concise form of: animals.forEach(animalShelter::acceptAnimal);
- I really don't like testAnimalShelterLauncherWithGivenCapacity() test method, beacuse the only thing I want to check is capacity and I run whole application and also getting capacity wit "AnimalShelterLauncher.launcher.animalShelter.capacity" is terrible, but I stuck with ideas how to resolve this.
- Any hint for AnimalShelterLauncher refactoring?


