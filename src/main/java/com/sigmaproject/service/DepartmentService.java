package com.sigmaproject.service;

import com.sigmaproject.model.Department;
import com.sigmaproject.model.Manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sigmaproject.utils.Constant.*;

/**
 * Service class for handling department-related operations.
 */
public class DepartmentService {

    /**
     * Creates departments from the provided managers.
     *
     * @param allManagersById map of all managers
     * @param errorLines      list to collect error messages
     * @return a map of departments
     */
    public static Map<String, Department> createDepartments(Map<String, Manager> allManagersById,
                                                            List<String> errorLines
    ) {
        Map<String, Department> departments = new HashMap<>();

        for (Manager m : allManagersById.values()) {
            departments.putIfAbsent(m.getDepartment(), new Department(m.getDepartment(), m));
            Department dept = departments.get(m.getDepartment());
            if (dept.getManager() != m) {
                errorLines.add(String.format(DUPLICATE_MANAGER_MESSAGE_TEMPLATE,
                        DUPLICATE_MANAGER_ERR,
                        m.getDepartment(),
                        QUOTE_SPACE_COLON_SPACE,
                        m.toString())
                );
            } else {
                dept.setManager(m);
            }
        }
        return departments;
    }

    /**
     * Removes departments that do not have a manager.
     *
     * @param departments map of departments
     */
    public static void removeEmptyDepartments(Map<String, Department> departments) {
        departments.entrySet().removeIf(entry -> entry.getValue().getManager() == null);
    }
}
