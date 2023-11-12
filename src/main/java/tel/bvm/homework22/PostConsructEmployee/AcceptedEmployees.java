package tel.bvm.homework22.PostConsructEmployee;

import org.springframework.stereotype.Component;
import tel.bvm.homework22.scheme.Employee;
import tel.bvm.homework22.service.EmployeeService;

import javax.annotation.PostConstruct;

@Component
public class AcceptedEmployees {
    private final EmployeeService employeeService;

    public AcceptedEmployees(EmployeeService employeeService) {
        this.employeeService = employeeService;
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

    @PostConstruct
    public void init() {

        employeeService.add("Иванов", "Иван", "12345", 1980);
        employeeService.add("Петров", "Пётр", "34789", 1975);
        employeeService.add("Смирнов", "Максим", "30237", 1989);
        employeeService.add("Новая", "Мария", "48905", 1990);
        employeeService.add("Симонов", "Тимофей", "01242", 1983);
        employeeService.add("Виноградова", "Анастасия", "29384", 1991);
        employeeService.add("Неизвестный", "Никита", "45892", 1980);
        employeeService.add("Громыко", "Павел", "32947", 1995);
        employeeService.add("Ким", "Юрий", "78118", 1999);
        employeeService.add("Великий", "Антон", "32460", 2001);
        employeeService.add("Крымская", "Маргарита", "34901", 1979);
    }
}
