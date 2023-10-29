package tel.bvm.homework22.service;

import tel.bvm.homework22.scheme.Employee;

import java.util.Map;

public interface DetailsEmployeeDepartmentService {
    Employee maxWageDepartment(Integer departmentNumber);

    Map<String, Employee> allEmployeeInfo();

    Employee minWageDepartment(Integer departmentNumber);

    String allEmployeeGroup(Integer department);
}
