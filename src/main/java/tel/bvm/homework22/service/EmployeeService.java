package tel.bvm.homework22.service;

import tel.bvm.homework22.scheme.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

    Map add(String firstName, String lastName, String passwordNumber, Integer yearBirth, Employee employee);

    Employee remove(String firstName, String lastName, String passwordNumber);

    Employee find(String firstName, String lastName, String passwordNumber);

    Map<String, Employee> allEmployeeInfo();

    Map<String, Employee> getMap();
//    Employee maxWageDepartment(Integer departmentNumber);
//
//    Employee minWageDepartment(Integer departmentNumber);
//
//    String allEmployeeGroup(Integer department);

}
