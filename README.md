# About
Simple Animal Shelter application, which takes argument for shelter capacity and accepts animals from file.
It is not possible to accept more animals than shelter capacity.
When file with animals list isn't given as a parameter - application uses default list.
All exceptions are logged to file.

# How to run the program?
- To test: mvn test 
- To execute: mvn exec:java -Dexec.mainClass="com.javaacademy.animalshelter.AnimalShelterLauncher"
-Dexec.args="-c capacity -p -q -f "animals_list_filepath"", where:
    * -c,--capacity <arg>   <arg> is animal shelter capacity - positive integer
                       number
    * -f,--filepath <arg>   <arg> is path to the file with animals list
    * -p,--printanimals     prints animals in shelter
    * -q,--freeplaces       prints how many free places are in the shelter
- To modify default animals list or display proper file format: go to *src/main/resources/list\_of\_animals* in project directory
- To check logs: go to *logs* folder in project directory

# TODO List
https://trello.com/b/dlK6mvme/schronisko

# Tests list
- [x] Check animal shelter creation, when capacity is legal
- [x] Check animal shelter creation, when capacity is illegal
- [x] Accept animal, when there are free places
- [x] Accept animal, when there are no more free places
- [x] Calculate free places number just after animal shelter creation
- [x] Calculate free places number, when animal shelter is partially filled
- [x] Read animals list from text file
- [x] Read animals list from empty text file
- [x] Animals with the same name and breed are equal
- [x] Animals with the same name and different breed are different
- [x] Animals with the same breed and different name are different
- [x] Equal animals have the same hashCode
- [x] Animal toString()
- [x] Parsing Animal to text (to store in file)
- [x] Parsing "animal shelter capacity" parameter from command line
- [x] Parsing "animals list filepath" parameter form command line
- [x] Parsing "print animals list" parameter form command line
- [x] Parsing "print free places in animal shelter" parameter form command line

# Questions
