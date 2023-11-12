package tel.bvm.homework22.service;

import org.springframework.stereotype.Service;
import tel.bvm.homework22.scheme.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DetailsEmployeeDepartmentServiceImpl implements DetailsEmployeeDepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DetailsEmployeeDepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxWageDepartment(Integer departmentNumber) {

        return employeeService.getMap().values()
                .stream()
                .filter(employee -> Objects.isNull(departmentNumber) || employee.getDepartmentNumber().equals(departmentNumber))
                .max(Comparator.comparingInt(employee -> employee.getWage()))
                .orElseThrow();
    }

    @Override
    public Map<String, Employee> allEmployeeInfo() {
        return Collections.unmodifiableMap(employeeService.getMap());
    }

    @Override
    public Employee minWageDepartment(Integer departmentNumber) {
        return employeeService.getMap().values()
                .stream()
                .filter(employee -> Objects.isNull(departmentNumber) || employee.getDepartmentNumber().equals(departmentNumber))
                .min(Comparator.comparingInt(employee -> employee.getWage()))
                .orElseThrow();
    }

    @Override
    public String allEmployeeGroup(Integer department) {

        Map<Integer, List<Employee>> employeeGroup = employeeService.getMap().values()
                .stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartmentNumber(), () -> new HashMap<>(), Collectors.toList()));

        if (department == null) {
            return employeeGroup.toString();
        } else {
            return employeeGroup.getOrDefault(department, Collections.emptyList()).toString();
        }
    }
}
