/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication61;

import java.util.Scanner;

/**
 *
 * @author Michael Singh
 */
public class JavaApplication61 {

   public static void main(String[] args) {
        CarInventory carInventory = new CarInventory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Car Management System\n------------------------");
        boolean continueApp = true;

        while (continueApp) {
            System.out.println("1. Add a Car");
System.out.println("2. Search for a Car");
System.out.println("3. List Cars");
System.out.println("4. Delete a Car");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    carInventory.addCar(scanner);
                    break;
                case 2:
                    Car foundCar = carInventory.searchCar(scanner);
                    if (foundCar != null) {
                        System.out.println("Car found");
                        System.out.println("Make: " + foundCar.getMake());
                        System.out.println("Model: " + foundCar.getModel());
                        System.out.println("Year: " + foundCar.getYear());
                    }
                    break;
                case 3:
                    carInventory.listCars();
                    break;
                case 4: carInventory.deleteCar(scanner);
                    break;
                case 5:
                    continueApp = false;
                    System.out.println("Exiting the Car Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}