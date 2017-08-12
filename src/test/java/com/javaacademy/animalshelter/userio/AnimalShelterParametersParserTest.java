package com.javaacademy.animalshelter.userio;

import org.apache.commons.cli.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class AnimalShelterParametersParserTest {
    private AnimalShelterParametersParser parametersParser;

    @DataProvider
    public Object[][] capacityArgs() {
        return new Object[][] {
                {new String[] {"-c", "10"}, 10},
                {new String[] {}, 0},
        };
    }

    @DataProvider
    public Object[][] animalsListFilePathArgs() {
        return new Object[][] {
                {new String[] {"-f", "src/test/resources/list_of_animals"}, Paths.get("src/test/resources/list_of_animals")},
                {new String[] {}, Paths.get("src/main/resources/list_of_animals")},
        };
    }

    @DataProvider
    public Object[][] printFreePlacesArgs() {
        return new Object[][] {
                {new String[] {"-q"}, true},
                {new String[] {}, false},
        };
    }

    @DataProvider
    public Object[][] printAnimalsListArgs() {
        return new Object[][] {
                {new String[] {"-p"}, true},
                {new String[] {}, false},
        };
    }

    @BeforeClass
    public void setUp() throws ParseException {
        parametersParser = new AnimalShelterParametersParser();
    }

    @Test(dataProvider = "capacityArgs")
    public void shouldParseShelterCapacity(String[] args, int expectedCapacity) throws ParseException {
        //given
        //when
        parametersParser.parseArgs(args);
        int parsedCapacity = parametersParser.parseShelterCapacity();
        //then
        assertEquals(parsedCapacity, expectedCapacity);
    }

    @Test(dataProvider = "animalsListFilePathArgs")
    public void shouldParseAnimalsListFilePath(String[] args, Path expectedAnimalsListFilePath) throws ParseException {
        //given
        //when
        parametersParser.parseArgs(args);
        Path parsedAnimalsListFilePath = parametersParser.parseAnimalsListFilePath();
        //then
        assertEquals(parsedAnimalsListFilePath, expectedAnimalsListFilePath);
    }

    @Test(dataProvider = "printFreePlacesArgs")
    public void shouldReturnIfPrintFreePlacesOptionIsEnabled(String[] args, boolean expectedResult) throws ParseException {
        //given
        //when
        parametersParser.parseArgs(args);
        boolean isPrintFreePlacesOptionEnabled = parametersParser.isPrintFreePlacesOptionEnabled();
        //then
        assertEquals(isPrintFreePlacesOptionEnabled, expectedResult);
    }

    @Test(dataProvider = "printAnimalsListArgs")
    public void shouldReturnIfPrintAnimalsListOptionIsEnabled(String[] args, boolean expectedResult) throws ParseException {
        //given
        //when
        parametersParser.parseArgs(args);
        boolean isPrintAnimalsListOptionEnabled = parametersParser.isPrintAnimalsListOptionEnabled();
        //then
        assertEquals(isPrintAnimalsListOptionEnabled, expectedResult);
    }

}