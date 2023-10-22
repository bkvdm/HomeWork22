package tel.bvm.homework22.service;

import tel.bvm.homework22.scheme.Employee;

import java.util.Map;

public interface EmployeeService {

    Employee add(String firstName, String lastName, String passwordNumber, Integer yearBirth, Integer wage, Integer departmentNumber);
    Employee remove(String firstName, String lastName, String passwordNumber, Integer yearBirth, Integer wage, Integer departmentNumber);
    Employee find(String firstName, String lastName, String passwordNumber, Integer yearBirth, Integer wage, Integer departmentNumber);

    Map<String, Employee> allEmployeeInfo();
}
