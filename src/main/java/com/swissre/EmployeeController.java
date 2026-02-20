package com.swissre;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final List<EmployeeDTO> EMPLOYEES = Arrays.asList(
            new EmployeeDTO(1L, "Alice Johnson", "Engineering"),
            new EmployeeDTO(2L, "Bob Smith", "Marketing"),
            new EmployeeDTO(3L, "Carol White", "HR")
    );

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return EMPLOYEES;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return EMPLOYEES.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
