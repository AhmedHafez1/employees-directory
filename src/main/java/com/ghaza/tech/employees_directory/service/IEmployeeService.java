package com.ghaza.tech.employees_directory.service;

import com.ghaza.tech.employees_directory.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    void remove(int id);

    Employee save(Employee employee);

    Employee get(int id);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByEmail(String email);
}
