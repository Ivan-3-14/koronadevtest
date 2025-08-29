package com.sigmaproject.model.enums;

import lombok.Getter;

/**
 * Enum representing the possible order values for sorting.
 * <p>
 * This enum provides two options for sorting order:
 * <ul>
 *     <li><b>ASC</b>: Ascending order.</li>
 *     <li><b>DESC</b>: Descending order.</li>
 * </ul>
 * </p>
 */
@Getter
public enum OrderValue {
    ASC("asc"),
    DESC("desc");

    /**
     * The string representation of the order value
     */
    private final String value;

    /**
     * Constructs an OrderValue enum with the specified string representation.
     *
     * @param value the string representation of the order value
     */
    OrderValue(String value) {
        this.value = value;
    }
}
