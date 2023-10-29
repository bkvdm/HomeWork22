package tel.bvm.homework22.service;

import org.springframework.stereotype.Service;
import tel.bvm.homework22.exception.EmployeeAlreadyAddedException;
import tel.bvm.homework22.exception.EmployeeNotFoundException;
import tel.bvm.homework22.scheme.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public int departmentNumberGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 1;
        int departmentNumberGenerator = random.nextInt(5) + minimumScore;
        return departmentNumberGenerator;
    }

    public int wageValueGenerator() {
        java.util.Random random = new java.util.Random();
        int minimumScore = 100_000;
        int wageValueGenerator = random.nextInt(300_000) + minimumScore;
        return wageValueGenerator;
    }

    @Override
    public Map add(String firstName, String lastName, String passwordNumber, Integer yearBirth, Employee employee) {

        if (employee == null) {
            Employee employeeNew = new Employee(firstName, lastName, passwordNumber, yearBirth, wageValueGenerator(), departmentNumberGenerator());
            String idEmployeeInfo = firstName + lastName + passwordNumber;

            if (employeeMap.containsKey(idEmployeeInfo)) {
                throw new EmployeeAlreadyAddedException();
            }
            employeeMap.put(idEmployeeInfo, employeeNew);
        } else {
            String idEmployeeInfo = firstName + lastName + passwordNumber;
            employeeMap.put(idEmployeeInfo, employee);
        }
        return employeeMap;
    }

    @Override
    public Employee remove(String firstName, String lastName, String passwordNumber) {
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        Employee employee = employeeMap.get(idEmployeeInfo);
        if (employee != null) {
            employeeMap.remove(idEmployeeInfo, employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, String passwordNumber) {
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        Employee employee = employeeMap.get(idEmployeeInfo);
        if (employee != null) {
            employeeMap.get(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

//    @Override
//    public Employee maxWageDepartment(Integer departmentNumber) {
////        final Map<Integer, Employee> employeeDepartment = new HashMap<>(Map.of());
//
//        Optional<Employee> maxDepartmentEmployee;
//        if (departmentNumber == null) {
//            maxDepartmentEmployee = employeeMap.values()
//                    .stream()
//                    .max(Comparator.comparingInt(employee -> employee.getWage()));
//        } else {
//            maxDepartmentEmployee = employeeMap.values()
//                    .stream()
//                    .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
//                    .max(Comparator.comparingInt(employee -> employee.getWage()));
//        }
//        return maxDepartmentEmployee.orElseThrow();
//    }
//
    @Override
    public Map<String, Employee> allEmployeeInfo() {
//        return new HashMap<> (employeeMap);
        return Collections.unmodifiableMap(employeeMap);
    }
    @Override
    public Map<String, Employee> getMap() {
        return employeeMap;
    }
//
//    @Override
//    public Employee minWageDepartment(Integer departmentNumber) {
//
//        Optional<Employee> minDepartmentEmployee;
//        if (departmentNumber == null) {
//            minDepartmentEmployee = employeeMap.values()
//                    .stream()
//                    .min(Comparator.comparingInt(employee -> employee.getWage()));
//        } else {
//            minDepartmentEmployee = employeeMap.values()
//                    .stream()
//                    .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
//                    .min(Comparator.comparingInt(employee -> employee.getWage()));
//        }
//        return minDepartmentEmployee.orElseThrow();
//    }
//
//    @Override
//    public String allEmployeeGroup(Integer department) {
//
//        Map<Integer, List<Employee>> employeeGroup = new HashMap<>();
//        List<Employee> employeeList = new ArrayList<>(employeeMap.values());
//        for (Employee employee : employeeList) {
//            Integer departmentNumber = employee.getDepartmentNumber();
//            List<Employee> employees = employeeGroup.getOrDefault(departmentNumber, new ArrayList<>());
//            employees.add(employee);
//            employeeGroup.put(departmentNumber, employees);
//        }
//        if (department == null) {
//            return employeeGroup.toString();
//        } else {
//            return employeeGroup.get(department).toString();
//        }
//    }
}