package com.ghaza.tech.employees_directory.service;

import com.ghaza.tech.employees_directory.entity.Employee;
import com.ghaza.tech.employees_directory.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void remove(int id) {
        var result = employeeRepository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }

        employeeRepository.delete(result.get());
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee get(int id) {
        var result = employeeRepository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }

        return result.get();
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    @Override
    public List<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
