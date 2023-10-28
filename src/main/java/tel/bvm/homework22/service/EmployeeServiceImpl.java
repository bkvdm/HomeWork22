package tel.bvm.homework22.service;

import org.springframework.stereotype.Service;
import tel.bvm.homework22.exception.EmployeeAlreadyAddedException;
import tel.bvm.homework22.exception.EmployeeNotFoundException;
import tel.bvm.homework22.scheme.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final Map<String, Employee> employeeMap;

    Employee employeeDefault1 = new Employee("Иванов", "Иван", "12345", 1980, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault2 = new Employee("Петров", "Пётр", "34789", 1975, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault3 = new Employee("Смирнов", "Максим", "30237", 1989, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault4 = new Employee("Новая", "Мария", "48905", 1990, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault5 = new Employee("Симонов", "Тимофей", "01242", 1983, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault6 = new Employee("Виноградова", "Анастасия", "29384", 1991, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault7 = new Employee("Неизвестный", "Никита", "45892", 1980, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault8 = new Employee("Громыко", "Павел", "32947", 1995, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault9 = new Employee("Ким", "Юрий", "78118", 1999, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault10 = new Employee("Великий", "Антон", "32460", 2001, wageValueGenerator(), departmentNumberGenerator());
    Employee employeeDefault11 = new Employee("Крымская", "Маргарита", "34901", 1979, wageValueGenerator(), departmentNumberGenerator());

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
    public Employee add(String firstName, String lastName, String passwordNumber, Integer yearBirth) {
        employeeMap.put(employeeDefault1.getFirstName() + employeeDefault1.getLastName() + employeeDefault1.getYearBirth(), employeeDefault1);
        employeeMap.put(employeeDefault2.getFirstName() + employeeDefault2.getLastName() + employeeDefault2.getYearBirth(), employeeDefault2);
        employeeMap.put(employeeDefault3.getFirstName() + employeeDefault3.getLastName() + employeeDefault3.getYearBirth(), employeeDefault3);
        employeeMap.put(employeeDefault4.getFirstName() + employeeDefault4.getLastName() + employeeDefault4.getYearBirth(), employeeDefault4);
        employeeMap.put(employeeDefault5.getFirstName() + employeeDefault5.getLastName() + employeeDefault5.getYearBirth(), employeeDefault5);
        employeeMap.put(employeeDefault6.getFirstName() + employeeDefault6.getLastName() + employeeDefault6.getYearBirth(), employeeDefault6);
        employeeMap.put(employeeDefault7.getFirstName() + employeeDefault7.getLastName() + employeeDefault7.getYearBirth(), employeeDefault7);
        employeeMap.put(employeeDefault8.getFirstName() + employeeDefault8.getLastName() + employeeDefault8.getYearBirth(), employeeDefault8);
        employeeMap.put(employeeDefault9.getFirstName() + employeeDefault9.getLastName() + employeeDefault9.getYearBirth(), employeeDefault9);
        employeeMap.put(employeeDefault10.getFirstName() + employeeDefault10.getLastName() + employeeDefault10.getYearBirth(), employeeDefault10);
        employeeMap.put(employeeDefault11.getFirstName() + employeeDefault11.getLastName() + employeeDefault11.getYearBirth(), employeeDefault11);

        Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wageValueGenerator(), departmentNumberGenerator());
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        if (employeeMap.containsKey(idEmployeeInfo)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(idEmployeeInfo, employee);
//        String executionInformation = "";
        return employee;
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

    @Override
    public Map<String, Employee> allEmployeeInfo() {
//        return new HashMap<> (employeeMap);
        return Collections.unmodifiableMap(employeeMap);
    }

    @Override
    public Employee maxWageDepartment(Integer departmentNumber) {
        final Map<Integer, Employee> employeeDepartment = new HashMap<>(Map.of());

//        employeeDepartment.get(departmentNumber);
//        int max = Stream.of(1, 2, 3).max(Comparator.naturalOrder()).get();

        Optional<Employee> maxDepartmentEmployee = employeeMap.values().stream()
                .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
                .max(Comparator.comparingInt(employee -> employee.getDepartmentNumber()));
        maxDepartmentEmployee.orElseThrow();

        if (maxDepartmentEmployee == null) {
            throw new EmployeeNotFoundException();
        }
        return maxDepartmentEmployee.get();
    }

    @Override
    public Employee minWageDepartment(Integer departmentNumber) {
        final Map<Integer, Employee> employeeDepartment = new HashMap<>(Map.of());

        Optional<Employee> minDepartmentEmployee = employeeMap.values().stream()
                .filter(employee -> employee.getDepartmentNumber().equals(departmentNumber))
                .min(Comparator.comparingInt(employee -> employee.getDepartmentNumber()));

        minDepartmentEmployee.orElseThrow();

        if (minDepartmentEmployee == null) {
            throw new EmployeeNotFoundException();
        }
        return minDepartmentEmployee.get();
    }

    @Override
    public Employee allEmployeeDepartment(Integer departmentNumber) {
//        final Map<Integer, Employee> employeeDepartment = new HashMap<>(Map.of());
        Map<Integer, Employee> employeeDepartment = new HashMap<>(Map.of());
        employeeMap.forEach((s, employee) -> {
            employeeDepartment.put(employee.getDepartmentNumber(), employee);
        });
        return employeeDepartment.get(departmentNumber);
    }

    @Override
    public Map<Integer, Employee> allEmployeeSortDepartment() {

        Map<Integer, Employee> employeeDepartment = new HashMap<>(Map.of());
        employeeMap.forEach((s, employee) -> {
            employeeDepartment.put(employee.getDepartmentNumber(), employee);
        });
        Map<Integer, Employee> sortedEmployeeDepartment = new TreeMap<>(employeeDepartment);
        return Collections.unmodifiableMap(sortedEmployeeDepartment);
    }
}
//                sortedEmployeeDepartment.values().stream().forEach(employee -> toString());


//        employeeMap.forEach((s, employee) -> {
//            employeeDepartment.put(employee.getDepartmentNumber(), employee);
//        });


//            employeeDepartment.put(employeeDefault1.getDepartmentNumber(), stringEmployeeEntry.getValue());

//        for (Map.Entry<String, Employee> stringEmployeeEntry : employeeMap.entrySet()) {
//            employeeDepartment.put(employeeMap.get(stringEmployeeEntry.getKey()).getDepartmentNumber(), stringEmployeeEntry.getValue());
//        }
