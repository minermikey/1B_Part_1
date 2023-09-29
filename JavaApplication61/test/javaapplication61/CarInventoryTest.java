/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package javaapplication61;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Michael Singh
 */
public class CarInventoryTest {
 
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

   
  @Test
public void testAddCar() {
    CarInventory carInventory = new CarInventory();
   
    Scanner scanner = new Scanner("CarRef\nHonda\nCivic\n2022\n");
    
    // Add a car to the car inventory
    carInventory.addCar(scanner);
    
    scanner = new Scanner("CarRef\n"); //actual
    
    
    // Check if the car was added successfully
    String expectedOutput = "Car added successfully!\n";
    assertEquals(1, carInventory.getCarInventory());
}


    @Test
public void testSearchCar() {
    CarInventory carInventory = new CarInventory();
    String carReference = "CarRef";
    String make = "Honda";
    String model = "Civic";
    int year = 2022;
    
    // Add a car to the car inventory
    Scanner scanner = new Scanner("CarRef\nHonda\nCivic\n2022\n");
    carInventory.addCar(scanner);

    // Search for the added car
    scanner = new Scanner("Civic\n"); // Simulate user input for searching
    Car foundCar = carInventory.searchCar(scanner);

    // Search for a car --> check if the found car matches the added car
    assertNotNull(foundCar);
    assertEquals(carReference, foundCar.getReference());
    assertEquals(make, foundCar.getMake());
    assertEquals(model, foundCar.getModel());
    assertEquals(year, foundCar.getYear());
}


    @Test
    public void testSearchCarNotFound() {
        CarInventory carInventory = new CarInventory();
        carInventory.addCar(new Scanner(new ByteArrayInputStream("CarRef\nHonda\nCivic\n2022\n".getBytes())));

        String input = "Toyota\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Car foundCar = carInventory.searchCar(new Scanner(System.in));

        assertNull(foundCar);
        String expectedOutput = "Car Not found\n";
        assertEquals(expected

    
}
    
}
