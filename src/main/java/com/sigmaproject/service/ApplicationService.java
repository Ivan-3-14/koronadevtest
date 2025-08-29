package com.sigmaproject.service;

import com.sigmaproject.model.Department;
import com.sigmaproject.model.Employee;
import com.sigmaproject.model.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The ApplicationService class is responsible for executing the main logic
 * of the application. It orchestrates the reading of files, processing of
 * data, and writing of output, while handling errors encountered during
 * execution.
 */
public class ApplicationService {

    /**
     * Runs the main logic of the application.
     *
     * <p>This method performs the following tasks:</p>
     * <ol>
     *     <li>Reads manager and employee data from files.</li>
     *     <li>Creates departments based on the managers.</li>
     *     <li>Distributes employees to their respective managers.</li>
     *     <li>Removes any empty departments.</li>
     *     <li>Sorts employees within departments.</li>
     *     <li>Writes output files for the departments.</li>
     *     <li>Logs any errors encountered during processing.</li>
     *     <li>If statistics are requested, generates and writes statistics.</li>
     * </ol>
     *
     * @param params the command line arguments and parameters used for
     *               configuration and control of the application logic
     */
    public static void runApplication(CommandLineArgsService params) {

        Map<String, Manager> allManagersById = new HashMap<>();
        Map<String, Employee> allEmployeesById = new HashMap<>();
        List<String> errorLines = new ArrayList<>();

        FileService.readFiles(allManagersById, allEmployeesById, errorLines);

        Map<String, Department> departments = DepartmentService.createDepartments(allManagersById, errorLines);

        EmployeeService.distributeEmployees(allEmployeesById, allManagersById, departments, errorLines);

        DepartmentService.removeEmptyDepartments(departments);

        EmployeeService.sortEmployees(departments, params);

        FileService.writeOutputFiles(departments);

        FileService.writeErrorLog(errorLines);

        if (params.isStat()) {
            StatisticsService.writeStatistics(departments, params);
        }
    }
}
