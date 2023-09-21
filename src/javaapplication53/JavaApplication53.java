/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication53;

import java.util.Scanner;
import static javaapplication53.student.scanner;

/**
 *
 * @author Michael Singh
 */
public class JavaApplication53 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {

        Welcome();

    }

    public static void Welcome() {

        System.out.println("""
                           
        STUDENT MANAGEMENT APPLICATION  εїз
        ***************         
                           """);

        Asking();
    }

    public static void Asking() {

        System.out.println("Enter (1) to launch menu or any other key to exit");
        int launchChoice = scanner.nextInt();

        if (launchChoice == 1) {

            reAsking();

        } else {
            System.out.println("You have exited the program! Bye ฅ^•ﻌ•^ฅ ");
            System.exit(0);
        }

    }

    public static void reAsking() {
        student Student = new student();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Menu:");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. View student report");
            System.out.println("5. Exit the application");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            //scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Student.saveStudent();
                    break;
                case 2:
                    Student.searchStudent();
                    break;
                case 3:
                    Student.deleteStudent();
                    break;
                case 4:
                    Student.studentReport();
                    break;
                case 5:
                    Student.exitStudentApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

}// end of main
