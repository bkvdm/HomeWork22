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

    //    String idEmployeeInfo =
    @Override
    public Employee add(String firstName, String lastName, String passwordNumber, Integer yearBirth, Integer wage, Integer departmentNumber) {
        Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wage, departmentNumber);
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        if (employeeMap.containsKey(idEmployeeInfo)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(idEmployeeInfo, employee);
//        String executionInformation = "";
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, String passwordNumber, Integer yearBirth, Integer wage, Integer departmentNumber) {
        Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wage, departmentNumber);
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        if (employeeMap.containsKey(idEmployeeInfo)) {
            employeeMap.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, String passwordNumber, Integer yearBirth, Integer wage, Integer departmentNumber) {
        Employee employee = new Employee(firstName, lastName, passwordNumber, yearBirth, wage, departmentNumber);
        String idEmployeeInfo = firstName + lastName + passwordNumber;
        if (employeeMap.containsKey(idEmployeeInfo)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<String, Employee> allEmployeeInfo() {
        return new HashMap<> (employeeMap);
    }
}
