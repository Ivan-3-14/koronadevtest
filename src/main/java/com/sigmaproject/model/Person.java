package com.sigmaproject.model;

import lombok.Data;

import java.text.DecimalFormat;


/**
 * Abstract class representing a person.
 * <p>
 * This class serves as a base for different types of people (e.g., employees, managers)
 * and contains common attributes such as ID, name, and salary.
 * </p>
 */
@Data
public abstract class Person {

    /**
     * The unique identifier for the person.
     */
    private final String id;

    /**
     * The name of the person.
     */
    private final String name;

    /**
     * The salary of the person.
     */
    private final Double salary;

    /** Default constructor. */
    public Person() {
        this.id = null;
        this.name = null;
        this.salary = null;
    }

    /**
     * Constructs a Person instance with the specified parameters.
     *
     * @param id     the unique identifier for the person
     * @param name   the name of the person
     * @param salary the salary of the person
     */
    public Person(String id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * Formats a {@code double} value by removing trailing zeros after the decimal point
     * if the value is an integer. If the value has a fractional part, it will be displayed
     * with a maximum of two decimal places.
     *
     * @param value the {@code double} value to be formatted
     * @return a string representation of the formatted value
     *         without unnecessary zeros after the decimal point
     */
    private String formatDouble(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        String result = df.format(value);

        if (result.endsWith(".00")) {
            result = result.substring(0, result.length() - 3);
        }

        return result;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + formatDouble(salary != null ? salary : 0.0) ;
    }
}