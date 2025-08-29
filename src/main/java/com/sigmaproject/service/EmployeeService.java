package com.sigmaproject.service;

import com.sigmaproject.model.Department;
import com.sigmaproject.model.Employee;
import com.sigmaproject.model.Manager;
import com.sigmaproject.model.enums.OrderValue;
import com.sigmaproject.model.enums.SortValue;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sigmaproject.exception.CustomIllArgException.printErrorMessage;
import static com.sigmaproject.utils.Constant.SORT_ERROR_MESSAGE;

/**
 * Service class for handling employee-related operations.
 */
public class EmployeeService {

    /**
     * Creates a manager and adds it to the manager map.
     *
     * @param id              manager's ID
     * @param name            manager's name
     * @param salaryStr       manager's salary as string
     * @param last            manager's last name
     * @param allManagersById map to store managers
     * @param errorLines      list to collect error messages
     * @param lineRaw         raw line from the file
     */
    public static void createManager(String id,
                                     String name,
                                     String salaryStr,
                                     String last,
                                     Map<String, Manager> allManagersById,
                                     List<String> errorLines,
                                     String lineRaw
    ) {
        Double salary = SalaryService.parseSalary(salaryStr);
        if (salary == null || last.isEmpty() || allManagersById.containsKey(id)) {
            errorLines.add(lineRaw);
            return;
        }
        Manager manager = new Manager(id, name, salary, last);
        allManagersById.put(id, manager);
    }

    /**
     * Creates an employee and adds it to the employee map.
     *
     * @param id               employee's ID
     * @param name             employee's name
     * @param salaryStr        employee's salary as string
     * @param allEmployeesById map to store employees
     * @param errorLines       list to collect error messages
     * @param last             raw line from the file
     */
    public static void createEmployee(String id,
                                      String name,
                                      String salaryStr,
                                      Map<String, Employee> allEmployeesById,
                                      List<String> errorLines,
                                      String last
    ) {
        Double salary = SalaryService.parseSalary(salaryStr);
        if (allEmployeesById.containsKey(id)) {
            errorLines.add(last);
            return;
        }
        Employee employee = new Employee(id, name, salary, last);
        allEmployeesById.put(id, employee);
    }

    /**
     * Distributes employees to their respective departments.
     *
     * @param allEmployeesById map of all employees
     * @param allManagersById  map of all managers
     * @param departments      map of departments
     * @param errorLines       list to collect error messages
     */
    public static void distributeEmployees(Map<String, Employee> allEmployeesById,
                                           Map<String, Manager> allManagersById,
                                           Map<String, Department> departments,
                                           List<String> errorLines
    ) {
        for (Employee e : allEmployeesById.values()) {
            Manager manager = allManagersById.get(e.getManagerId());

            if (manager == null) {
                errorLines.add(e.toString());
                continue;
            }
            Department dept = departments.get(manager.getDepartment());

            if (dept == null) {
                errorLines.add(e.toString());
                continue;
            }
            dept.getEmployees().add(e);
        }
    }

    /**
     * Sorts employees in departments based on specified criteria.
     *
     * @param departments map of departments
     * @param params      command line parameters
     */
    public static void sortEmployees(Map<String, Department> departments, CommandLineArgsService params) {
        if (params.getSortBy() != null) {
            Comparator<Employee> comparator = createComparator(params);
            for (Department dept : departments.values()) {
                List<Employee> sorted = dept.getEmployees().stream()
                        .sorted(comparator)
                        .collect(Collectors.toList());
                dept.getEmployees().clear();
                dept.getEmployees().addAll(sorted);
            }
        } else if (params.getOrder() != null) {
            printErrorMessage(SORT_ERROR_MESSAGE);
        }
    }

    /**
     * Creates a comparator for sorting employees.
     *
     * @param params command line parameters
     * @return a Comparator for Employee
     */
    private static Comparator<Employee> createComparator(CommandLineArgsService params) {
        Comparator<Employee> comparator;
        if (SortValue.NAME.getValue().equals(params.getSortBy())) {
            comparator = Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER);
        } else {
            comparator = Comparator.comparing(e -> e.getSalary() == null ? Double.NaN : e.getSalary());
        }
        if (OrderValue.DESC.getValue().equals(params.getOrder())) {
            comparator = comparator.reversed();
        }
        return comparator;
    }
}
