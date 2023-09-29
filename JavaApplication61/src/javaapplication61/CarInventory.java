/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication61;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Michael Singh
 */
public class CarInventory {
 private List<Car> carInventory;

    public CarInventory() {
        this.carInventory = carInventory;
    }
    
    public int getCarInventory(){
        return carInventory.size();
    }

    public void addCar(Scanner scanner) {
        System.out.println("Add a New Car");
        System.out.println("Entre the Car reffrence");
        String reference = scanner.next();
        System.out.println("Enter the Car Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter the Car Model: ");
        String model = scanner.nextLine();
        System.out.println("Enter the Car Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        carInventory.add(new Car(make, model, year, reference));
        System.out.println("Car added successfully!");
    }

    public Car searchCar(Scanner scanner) {
        System.out.println("Search for a Car");
        System.out.println("Enter the Car Make or Model: ");
        String searchTerm = scanner.nextLine();

        for (Car car : carInventory) {
            if (car.getMake().equalsIgnoreCase(searchTerm) || car.getModel().equalsIgnoreCase(searchTerm)) {
                return car;
            }
        }
        System.out.println("Car Not found");
        return null;
    }

    public void listCars() {
        if (carInventory.isEmpty()) {
            System.out.println("No cars in the inventory.");
        } else {
            System.out.println("List of Cars:");
            for (Car car : carInventory) {
                System.out.println("Make: " + car.getMake());
                System.out.println("Model: " + car.getModel());
                System.out.println("Year: " + car.getYear());
                System.out.println("--------------------------------");
            }
        }
    }
    
     public void deleteCar(Scanner scanner) {
    System.out.println("Enter the Car Make, Model, or Reference to delete: ");
    String searchTerm = scanner.nextLine();

    boolean carDeleted = false;

    for (int i = 0; i < carInventory.size(); i++) {
        Car car = carInventory.get(i);
        if (car.getMake().equalsIgnoreCase(searchTerm) ||
            car.getModel().equalsIgnoreCase(searchTerm) ||
            car.getReference().equalsIgnoreCase(searchTerm)) {
            carInventory.remove(i);
            carDeleted = true;
            System.out.println("Car deleted successfully.");
            break;
        }
    }

    if (!carDeleted) {
        System.out.println("Car Not found for deletion.");
    }
}
    
}
