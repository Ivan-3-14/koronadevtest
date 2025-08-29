package com.sigmaproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a department within an organization.
 * <p>
 * This class holds information about the department's name, its manager,
 * and a list of employees working in the department.
 * </p>
 */
@Builder
@Data
@AllArgsConstructor
public class Department {

    /**
     * The name of the department.
     */
    private final String name;

    /**
     * The manager of the department.
     */
    private Manager manager;

    /**
     * The list of employees in the department.
     */
    private final List<Employee> employees = new ArrayList<>();

}
