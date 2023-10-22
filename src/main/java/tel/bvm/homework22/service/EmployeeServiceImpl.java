package tel.bvm.homework22.service;

import org.springframework.stereotype.Service;
import tel.bvm.homework22.exception.EmployeeAlreadyAddedException;
import tel.bvm.homework22.exception.EmployeeNotFoundException;
import tel.bvm.homework22.scheme.Employee;

import java.util.HashMap;
import java.util.Map;
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

    //    String idEmployeeInfo =
    @Override
    public Employee add(String firstName, String lastName, String passwordNumber, Integer yearBirth) {
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
            employeeMap.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
//        Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wage, departmentNumber);
//        if (employeeMap.containsKey(idEmployeeInfo)) {
//            employeeMap.remove(employee);
//            return employee;
//        }
//        throw new EmployeeNotFoundException();

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
//        Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wage, departmentNumber);
//        String idEmployeeInfo = firstName + lastName + passwordNumber;
//        if (employeeMap.containsKey(idEmployeeInfo)) {
//        }

    @Override
    public Map<String, Employee> allEmployeeInfo() {
        return new HashMap<> (employeeMap);
//        Collections.unmodifiableMap()
    }
}
