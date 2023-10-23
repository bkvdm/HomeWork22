package tel.bvm.homework22.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tel.bvm.homework22.scheme.Employee;
import tel.bvm.homework22.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
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

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String passwordNumber, @RequestParam Integer yearBirth) {
//        Integer wage = wageValueGenerator();
//        Integer departmentNumber = departmentNumberGenerator();
        return service.add(firstName, lastName, passwordNumber, yearBirth);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String passwordNumber) {
//        Integer wage = wageValueGenerator();
//        Integer departmentNumber = departmentNumberGenerator();
        return service.remove(firstName, lastName, passwordNumber);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String passwordNumber) {
//        Integer wage = wageValueGenerator();
//        Integer departmentNumber = departmentNumberGenerator();
        return service.find(firstName, lastName, passwordNumber);
    }

    @GetMapping
    public Map<String, Employee> allEmployeeInfo() {
    return service.allEmployeeInfo();
    }
}
