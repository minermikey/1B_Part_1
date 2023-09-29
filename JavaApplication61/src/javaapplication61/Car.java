/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication61;

/**
 *
 * @author Michael Singh
 */
class Car {
    private String make, model;
    private int year;
    private String reference;

    public Car(String make, String model, int year, String reference) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.reference = reference;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getReference() {
        return reference;
    }
}