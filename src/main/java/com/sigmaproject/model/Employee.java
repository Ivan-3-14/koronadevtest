package com.sigmaproject.model;

import lombok.*;

/**
 * Represents an employee in an organization.
 * <p>
 * This class extends the {@link Person} class and includes a manager ID
 * to indicate the manager to whom the employee reports.
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends Person {

    /**
     * The unique identifier of the manager that the employee reports to.
     */
    private final String managerId;

    /**
     * Constructs an Employee instance with the specified parameters.
     *
     * @param id        the unique identifier for the employee
     * @param name      the name of the employee
     * @param salary    the salary of the employee
     * @param managerId the unique identifier of the manager that the employee reports to
     */
    public Employee(String id, String name, Double salary, String managerId) {
        super(id, name, salary);
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee," + super.toString() + "," + managerId;
    }
}
