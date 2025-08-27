package com.sigmaproject.model;

import lombok.*;

/**
 * Represents a manager in an organization.
 * <p>
 * This class extends the {@link Person} class and adds a department attribute
 * to represent the specific department that the manager oversees.
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Manager extends Person {

    /**
     * The department that the manager oversees.
     */
    private final String department;

    /**
     * Constructs a Manager instance with the specified parameters.
     *
     * @param id         the unique identifier for the manager
     * @param name       the name of the manager
     * @param salary     the salary of the manager
     * @param department the department that the manager oversees
     */
    Manager(String id, String name, Double salary, String department) {
        super(id, name, salary);
        this.department = department;
    }
}
