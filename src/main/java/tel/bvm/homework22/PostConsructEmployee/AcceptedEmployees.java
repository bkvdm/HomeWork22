package tel.bvm.homework22.PostConsructEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tel.bvm.homework22.scheme.Employee;
import tel.bvm.homework22.service.EmployeeService;

import java.util.Map;

@Component
public class AcceptedEmployees implements CommandLineRunner {

    public AcceptedEmployees() {
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

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String...args) {

//        public final Map<String, Employee> employeeMap;
//
//        public AcceptedEmployees (Map<String, Employee> employeeMap) {
//            this.employeeMap = employeeMap;
//        }

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

        employeeService.add(employeeDefault1.getFirstName(), employeeDefault1.getLastName(), employeeDefault1.getPasswordNumber(), employeeDefault1.getYearBirth(), employeeDefault1);
        employeeService.add(employeeDefault2.getFirstName(), employeeDefault2.getLastName(), employeeDefault2.getPasswordNumber(), employeeDefault2.getYearBirth(), employeeDefault2);
        employeeService.add(employeeDefault3.getFirstName(), employeeDefault3.getLastName(), employeeDefault3.getPasswordNumber(), employeeDefault3.getYearBirth(), employeeDefault3);
        employeeService.add(employeeDefault4.getFirstName(), employeeDefault4.getLastName(), employeeDefault4.getPasswordNumber(), employeeDefault4.getYearBirth(), employeeDefault4);
        employeeService.add(employeeDefault5.getFirstName(), employeeDefault5.getLastName(), employeeDefault5.getPasswordNumber(), employeeDefault5.getYearBirth(), employeeDefault5);
        employeeService.add(employeeDefault6.getFirstName(), employeeDefault6.getLastName(), employeeDefault6.getPasswordNumber(), employeeDefault6.getYearBirth(), employeeDefault6);
        employeeService.add(employeeDefault7.getFirstName(), employeeDefault7.getLastName(), employeeDefault7.getPasswordNumber(), employeeDefault7.getYearBirth(), employeeDefault7);
        employeeService.add(employeeDefault8.getFirstName(), employeeDefault8.getLastName(), employeeDefault8.getPasswordNumber(), employeeDefault8.getYearBirth(), employeeDefault8);
        employeeService.add(employeeDefault9.getFirstName(), employeeDefault9.getLastName(), employeeDefault9.getPasswordNumber(), employeeDefault9.getYearBirth(), employeeDefault9);
        employeeService.add(employeeDefault10.getFirstName(), employeeDefault10.getLastName(), employeeDefault10.getPasswordNumber(), employeeDefault10.getYearBirth(), employeeDefault10);
        employeeService.add(employeeDefault11.getFirstName(), employeeDefault11.getLastName(), employeeDefault11.getPasswordNumber(), employeeDefault11.getYearBirth(), employeeDefault11);




    }

}
