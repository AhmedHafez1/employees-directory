package com.ghaza.tech.employees_directory.repository;

import com.ghaza.tech.employees_directory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByEmail(String email);
}
