package com.swissre;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employees = Arrays.asList(
            new Employee(1L, "Alice Johnson", "Engineering", "alice.johnson@swissre.com"),
            new Employee(2L, "Bob Smith", "Finance", "bob.smith@swissre.com"),
            new Employee(3L, "Carol White", "HR", "carol.white@swissre.com")
    );

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst();
    }
}
