package com.sigmaproject.service;

import com.sigmaproject.model.Department;
import com.sigmaproject.model.Employee;
import com.sigmaproject.model.Manager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.sigmaproject.exception.CustomIllArgException.printErrorMessage;
import static com.sigmaproject.utils.Constant.*;

/**
 * Service class for handling file operations.
 */
public class FileService {

    /**
     * Reads employee and manager data from .sb files.
     *
     * @param allManagersById  map to store managers
     * @param allEmployeesById map to store employees
     * @param errorLines       list to collect error messages
     */
    public static void readFiles(Map<String, Manager> allManagersById,
                                 Map<String, Employee> allEmployeesById,
                                 List<String> errorLines
    ) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."), FILE_EXTENSION_PATTERN)) {
            for (Path path : stream) {
                List<String> lines = Files.readAllLines(path);
                processLines(lines, allManagersById, allEmployeesById, errorLines);
            }
        } catch (IOException e) {
            printErrorMessage(ERR_READ_INPUT_FILES + e.getMessage());
        }
    }

    /**
     * Writes output files for each department.
     *
     * @param departments map of departments
     */
    public static void writeOutputFiles(Map<String, Department> departments) {

        Path outputDirectory = getPath();
        if (outputDirectory == null) return;

        for (Department dept : departments.values()) {
            try (BufferedWriter writer = Files.newBufferedWriter(outputDirectory.resolve(dept.getName() + POINT_S_B))) {
                writer.write(dept.getManager().toString());
                writer.newLine();
                for (Employee e : dept.getEmployees()) {
                    writer.write(e.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                printErrorMessage(FILE_WRITE_ERR + dept.getName() + POINT_S_B + e.getMessage());
            }
        }
    }


    /**
     * Writes error log to a file.
     *
     * @param errorLines list of error messages
     */
    public static void writeErrorLog(List<String> errorLines) {
        if (!errorLines.isEmpty()) {

            try (BufferedWriter writer = Files.newBufferedWriter(
                    Objects.requireNonNull(getPath()).resolve(ERROR_LOG),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            )) {
                for (String line : errorLines) {
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                printErrorMessage(ERR_WRITING_ERR_LOG + e.getMessage());
            }
        }
    }

    /**
     * Processes each line of the input files.
     *
     * @param lines            list of lines from the file
     * @param allManagersById  map to store managers
     * @param allEmployeesById map to store employees
     * @param errorLines       list to collect error messages
     */
    private static void processLines(List<String> lines,
                                     Map<String, Manager> allManagersById,
                                     Map<String, Employee> allEmployeesById,
                                     List<String> errorLines
    ) {
        for (String lineRaw : lines) {
            String line = lineRaw.trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(CSV_DELIMITER, -1);
            if (parts.length != 5) {
                errorLines.add(lineRaw);
                continue;
            }
            String position = parts[0].trim();
            String id = parts[1].trim();
            String name = parts[2].trim();
            String salaryStr = parts[3].trim();
            String last = parts[4].trim();

            if (!isValidSalary(salaryStr)) {
                errorLines.add(lineRaw);
                return;
            }

            if (MANAGER.equalsIgnoreCase(position)) {
                EmployeeService.createManager(id, name, salaryStr, last, allManagersById, errorLines, lineRaw);
            } else if (EMPLOYEE.equalsIgnoreCase(position)) {
                EmployeeService.createEmployee(id, name, salaryStr, allEmployeesById, errorLines, last);
            } else {
                errorLines.add(lineRaw);
            }
        }
    }

    /**
     * Checks whether the provided string is a valid salary value.
     *
     * <p>A valid salary value is a positive floating-point number.
     * If the string cannot be parsed as a number or if the value
     * is less than or equal to zero, the method returns {@code false}.</p>
     *
     * @param salaryStr the string representing the salary value
     * @return {@code true} if the string contains a valid salary value,
     * {@code false} otherwise
     */
    private static boolean isValidSalary(String salaryStr) {
        try {
            double salary = Double.parseDouble(salaryStr);
            return salary > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Retrieves the path to the output directory.
     * If the directory does not exist, it attempts to create it.
     *
     * @return the path to the output directory, or null if the directory could not be created.
     */
    private static Path getPath() {
        Path outputDirectory = Paths.get(OUTPUT);
        try {
            if (!Files.exists(outputDirectory)) {
                Files.createDirectory(outputDirectory);
            }
        } catch (IOException e) {
            printErrorMessage(ERR_CREATE_DIR + e.getMessage());
            return null;
        }
        return outputDirectory;
    }
}
