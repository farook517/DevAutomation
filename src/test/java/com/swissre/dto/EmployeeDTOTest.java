package com.swissre.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDTOTest {

    @Test
    void testDefaultConstructor() {
        EmployeeDTO employee = new EmployeeDTO();
        assertNotNull(employee);
    }

    @Test
    void testParameterizedConstructor() {
        Long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String department = "Engineering";
        String position = "Software Engineer";
        LocalDate hireDate = LocalDate.of(2020, 1, 15);
        Double salary = 75000.0;

        EmployeeDTO employee = new EmployeeDTO(id, firstName, lastName, email, 
                                               department, position, hireDate, salary);

        assertEquals(id, employee.getId());
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(email, employee.getEmail());
        assertEquals(department, employee.getDepartment());
        assertEquals(position, employee.getPosition());
        assertEquals(hireDate, employee.getHireDate());
        assertEquals(salary, employee.getSalary());
    }

    @Test
    void testGettersAndSetters() {
        EmployeeDTO employee = new EmployeeDTO();
        
        Long id = 2L;
        employee.setId(id);
        assertEquals(id, employee.getId());
        
        String firstName = "Jane";
        employee.setFirstName(firstName);
        assertEquals(firstName, employee.getFirstName());
        
        String lastName = "Smith";
        employee.setLastName(lastName);
        assertEquals(lastName, employee.getLastName());
        
        String email = "jane.smith@example.com";
        employee.setEmail(email);
        assertEquals(email, employee.getEmail());
        
        String department = "Marketing";
        employee.setDepartment(department);
        assertEquals(department, employee.getDepartment());
        
        String position = "Marketing Manager";
        employee.setPosition(position);
        assertEquals(position, employee.getPosition());
        
        LocalDate hireDate = LocalDate.of(2021, 3, 10);
        employee.setHireDate(hireDate);
        assertEquals(hireDate, employee.getHireDate());
        
        Double salary = 85000.0;
        employee.setSalary(salary);
        assertEquals(salary, employee.getSalary());
    }

    @Test
    void testToString() {
        EmployeeDTO employee = new EmployeeDTO(1L, "John", "Doe", 
                                               "john.doe@example.com", 
                                               "Engineering", 
                                               "Software Engineer", 
                                               LocalDate.of(2020, 1, 15), 
                                               75000.0);
        
        String result = employee.toString();
        
        assertNotNull(result);
        assertTrue(result.contains("EmployeeDTO{"));
        assertTrue(result.contains("id=1"));
        assertTrue(result.contains("firstName='John'"));
        assertTrue(result.contains("lastName='Doe'"));
        assertTrue(result.contains("email='john.doe@example.com'"));
        assertTrue(result.contains("department='Engineering'"));
        assertTrue(result.contains("position='Software Engineer'"));
        assertTrue(result.contains("hireDate=2020-01-15"));
        assertTrue(result.contains("salary=75000.0"));
    }

    @Test
    void testNullValues() {
        EmployeeDTO employee = new EmployeeDTO();
        
        assertNull(employee.getId());
        assertNull(employee.getFirstName());
        assertNull(employee.getLastName());
        assertNull(employee.getEmail());
        assertNull(employee.getDepartment());
        assertNull(employee.getPosition());
        assertNull(employee.getHireDate());
        assertNull(employee.getSalary());
    }
}
