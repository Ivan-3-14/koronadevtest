package com.sigmaproject.model.enums;

import lombok.Getter;

/**
 * Enum representing the possible output values for the application.
 * <p>
 * This enum provides two options for output destinations:
 * <ul>
 *     <li><b>CONSOLE</b>: Output to the console.</li>
 *     <li><b>FILE</b>: Output to a file.</li>
 * </ul>
 * </p>
 */
@Getter
public enum OutputValue {
    CONSOLE("console"),
    FILE("file");

    /**
     * The string representation of the output value
     */
    private final String value;

    /**
     * Constructs an OutputValue enum with the specified string representation.
     *
     * @param value the string representation of the output value
     */
    OutputValue(String value) {
        this.value = value;
    }
}
