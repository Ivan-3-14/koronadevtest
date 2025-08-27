package com.sigmaproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

}
