package tel.bvm.homework22.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tel.bvm.homework22.scheme.Employee;
import tel.bvm.homework22.service.DetailsEmployeeDepartmentService;

import java.util.Map;

@RestController
@RequestMapping("/employee/details/departments")
public class DetailsEmployeeDepartmentController {
    private final DetailsEmployeeDepartmentService detailsEmployeeDepartmentService;

    public DetailsEmployeeDepartmentController(DetailsEmployeeDepartmentService detailsEmployeeDepartmentService) {
        this.detailsEmployeeDepartmentService = detailsEmployeeDepartmentService;
    }

    @GetMapping
    public Map<String, Employee> allEmployeeInfo() {
        return detailsEmployeeDepartmentService.allEmployeeInfo();
    }

    @GetMapping("/max-salary")
    public Employee maxWageDepartment(@RequestParam(value = "department", required = false) Integer departmentNumber) {
        return detailsEmployeeDepartmentService.maxWageDepartment(departmentNumber);
    }

    @GetMapping("/min-salary")
    public Employee minWageDepartment(@RequestParam(value = "department", required = false) Integer departmentNumber) {
        return detailsEmployeeDepartmentService.minWageDepartment(departmentNumber);
    }

    @GetMapping("/all")
    public String employeeDepartment(@RequestParam(value = "department", required = false) Integer departmentNumber) {
        return detailsEmployeeDepartmentService.allEmployeeGroup(departmentNumber);
    }
}
