package com.sigmaproject.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Service class for salary-related operations.
 */
public class SalaryService {

    /**
     * Parses a salary string and converts it to a Double.
     *
     * @param salaryStr the salary string to parse
     * @return the parsed salary as a Double, or null if the input is invalid
     */
    public static Double parseSalary(String salaryStr) {
        if (salaryStr == null || salaryStr.isBlank()) {
            return null;
        }
        try {
            double val = Double.parseDouble(salaryStr);
            if (val <= 0) return null;
            return val;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Rounds up a given value to two decimal places.
     *
     * @param value the value to round up
     * @return the rounded value as a String
     */
    public static String roundUp2(double value) {
        BigDecimal bd = BigDecimal.valueOf(value).setScale(2, RoundingMode.CEILING);
        return bd.toString();
    }

}
