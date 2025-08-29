package com.sigmaproject.service;

import com.sigmaproject.model.Department;
import com.sigmaproject.model.Employee;
import com.sigmaproject.model.enums.OutputValue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static com.sigmaproject.exception.CustomIllArgException.printErrorMessage;
import static com.sigmaproject.utils.Constant.*;

/**
 * Service class for handling statistics generation.
 */
public class StatisticsService {

    /**
     * Writes statistics for each department.
     *
     * @param departments map of departments
     * @param params command line parameters
     */
    public static void writeStatistics(Map<String, Department> departments, CommandLineArgsService params) {
        List<Department> sortedDepartments = departments.values().stream()
                .sorted(Comparator.comparing(Department::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        List<String> statsLines = new ArrayList<>();
        statsLines.add(STAT_HEAD_LINE);
        for (Department d : sortedDepartments) {
            List<Double> salaries = d.getEmployees().stream()
                    .map(Employee::getSalary)
                    .filter(Objects::nonNull)
                    .filter(s -> s > 0)
                    .sorted()
                    .collect(Collectors.toList());

            String min = DEFAULT_SALARY_VAL_STR;
            String max = DEFAULT_SALARY_VAL_STR;
            String mid = DEFAULT_SALARY_VAL_STR;

            if (!salaries.isEmpty()) {
                min = SalaryService.roundUp2(salaries.get(0));
                max = SalaryService.roundUp2(salaries.get(salaries.size() - 1));
                double average = salaries.stream().mapToDouble(Double::doubleValue).average().orElse(0);
                mid = SalaryService.roundUp2(average);
            }
            statsLines.add(String.format(STAT_LINE_STRING_FORMAT, d.getName(), min, max, mid));
        }

        if (OutputValue.FILE.getValue().equals(params.getOutput())) {
            writeStatsToFile(statsLines, params);
        } else {
            printStatsToConsole(statsLines);
        }
    }

    /**
     * Writes statistics to a file.
     *
     * @param statsLines list of statistics lines
     * @param params command line parameters
     */
    private static void writeStatsToFile(List<String> statsLines, CommandLineArgsService params) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(params.getPath()))) {
            for (String line : statsLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            printErrorMessage(ERR_REC_STATS + e.getMessage());
        }
    }

    /**
     * Prints statistics to the console.
     *
     * @param statsLines list of statistics lines
     */
    private static void printStatsToConsole(List<String> statsLines) {
        for (String line : statsLines) {
            System.out.println(line);
        }
    }
}
