package com.ghaza.tech.employees_directory.controller;
import com.ghaza.tech.employees_directory.entity.Employee;
import com.ghaza.tech.employees_directory.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable int id) {
        return employeeService.get(id);
    }

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        employee.setId(0);
        var savedEmployee = employeeService.save(employee);

        return ResponseEntity.created(URI.create("/api/employees/" + employee.getId())).body(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee) {
        employee.setId(id);
        var updatedEmployee = employeeService.save(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable int id) {
        employeeService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
