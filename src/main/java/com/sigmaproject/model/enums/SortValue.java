package com.sigmaproject.model.enums;

import lombok.Getter;

/**
 * Enum representing the possible sorting values for the application.
 * <p>
 * This enum provides two options for sorting:
 * <ul>
 *     <li><b>NAME</b>: Sort by name.</li>
 *     <li><b>SALARY</b>: Sort by salary.</li>
 * </ul>
 * </p>
 */
@Getter
public enum SortValue {
    NAME("name"),
    SALARY("salary");

    /**
     * The string representation of the sorting value
     */
    private final String value;

    /**
     * Constructs a SortValue enum with the specified string representation.
     *
     * @param value the string representation of the sorting value
     */
    SortValue(String value) {
        this.value = value;
    }
}
