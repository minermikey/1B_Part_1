/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication53;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Michael Singh
 */
public class student {

    final static Scanner scanner = new Scanner(System.in);

    private ArrayList<String> studentList = new ArrayList<>();

    

    public ArrayList<String> getStudentList() {
        return studentList;
    }
    public void setStudentList(ArrayList<String> studentList) {
        this.studentList = studentList;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    private String Id;
    private String name;
    private int age;
    private String email;
    private String course;

    public void saveStudent() {

        System.out.println("Entre student Id");// asking the user for the students ID
        Id = scanner.next();

        System.out.println("Enter student name: "); //asking the user for the students name
        name = scanner.next();

        System.out.println("Enter student age: "); //asking the user for the students age
        age = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        while (age < 16) { // checks to see if the age is less than 16 and if it is then it reasks for a age greater than
            // 15
            System.out.println("Invalid age. Please enter a valid age (>= 16): "); // the prompt that is displayed if the age is not corrext
            age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }

        System.out.println("Entre the students E-mail: "); // asking the user for the students E-mail
        email = scanner.nextLine();

        System.out.println("Entre the students course: "); // asking the user for the students course
        course = scanner.nextLine();

        String studentInfo = "ID: " + Id + "\n"
                + " Name: " + name + "\n"
                + " Age: " + age + "\n"
                + " E-mail: " + email + "\n"
                + " Course: " + course; // saving all the information into a string 

        studentList.add(studentInfo); // saving the string into an array list 
        System.out.println("Student details saved successfully."); // outputting that it was successfully saved

    }

    public void searchStudent() {
        
        System.out.println("What is the ID of the student that you are looking for?"); // asking what the students id is 
        String searchId = scanner.next(); 
        boolean found = false;

        for (String studentInfo : studentList) {
            String[] infoLines = studentInfo.split("\n"); // splits studentInfo string into separate lines and stores it in infoLines
            String studentId = infoLines[0].split(":")[1].trim(); // 

            if (studentId.equals(searchId)) { // searching to see if there is a id that fits the provided one 
                System.out.println("-----------------------------------------------");
                System.out.println("Student found:"); // states that it is found
                System.out.println(studentInfo); // output the info 
                System.out.println("-----------------------------------------------");
                found = true;
                break; // Exit the loop once the student is found.
            }
        }

        if (!found) { // if it was not found then 
            System.out.println("-----------------------------------------------");
            System.out.println("Student with ID: " + searchId + " was not found!"); // it outputs this message
            System.out.println("-----------------------------------------------");
        }
    }

    public void deleteStudent() {
        
        System.out.println("Enter student ID to delete: "); // asking for the id of the student that they want to delete 
        String id = scanner.next();
        
        int numId = Integer.parseInt(id); // changes the string to an integer
        boolean found = false;

        for (int i = 0; i < studentList.size(); i++) { // cycles through the array 
            
            String studentInfo = studentList.get(i); 
            String[] infoLines = studentInfo.split("\n");
            String studentId = infoLines[0].split(":")[1].trim();

            if (studentId.equals(id)) { 
                System.out.println("-----------------------------------------------");
                System.out.println("Student found:");
                System.out.println(studentInfo); // if the info is found it displays it here 
                System.out.println("-----------------------------------------------");
                System.out.println("Are you sure you want to delete this student? (Y/N): "); // confirming the deketion if the student
                String confirmation = scanner.next();

                if (confirmation.equalsIgnoreCase("Y")) { // if y is typed student is deleted
                    studentList.remove(i);
                    System.out.println("Student deleted successfully.");
                } else { // if not then we display this message 
                    System.out.println("-----------------------------------------------");
                    System.out.println("Deletion cancelled.");
                    System.out.println("-----------------------------------------------");
                }

                found = true;
                break; // Exit the loop once the student is found and processed.
            }
        }

        if (!found) { // this is the message that is displayed if the student 
            System.out.println("-----------------------------------------------");
            System.out.println("Student not found.");
            System.out.println("-----------------------------------------------");
        }
    }

    public void studentReport() {

        System.out.println("Student Report:"); // outputting this message 
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("---------------------------------");
            System.out.println(studentList.get(i)); // outputs all the information and 
            System.out.println("---------------------------------");

        }

    }

    public void exitStudentApplication() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);
    }

    public void deleteStudent(String studentId, String confirmation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
