package com.swissre.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeDtoTest {

    @Test
    void testDefaultConstructor() {
        EmployeeDto employee = new EmployeeDto();
        assertNotNull(employee);
        assertNull(employee.getId());
        assertNull(employee.getName());
        assertNull(employee.getEmail());
        assertNull(employee.getDepartment());
        assertNull(employee.getPosition());
    }

    @Test
    void testParameterizedConstructor() {
        EmployeeDto employee = new EmployeeDto(1L, "John Doe", "john.doe@example.com", "IT", "Software Engineer");
        
        assertEquals(1L, employee.getId());
        assertEquals("John Doe", employee.getName());
        assertEquals("john.doe@example.com", employee.getEmail());
        assertEquals("IT", employee.getDepartment());
        assertEquals("Software Engineer", employee.getPosition());
    }

    @Test
    void testSettersAndGetters() {
        EmployeeDto employee = new EmployeeDto();
        
        employee.setId(2L);
        employee.setName("Jane Smith");
        employee.setEmail("jane.smith@example.com");
        employee.setDepartment("HR");
        employee.setPosition("HR Manager");

        assertEquals(2L, employee.getId());
        assertEquals("Jane Smith", employee.getName());
        assertEquals("jane.smith@example.com", employee.getEmail());
        assertEquals("HR", employee.getDepartment());
        assertEquals("HR Manager", employee.getPosition());
    }

    @Test
    void testEquals() {
        EmployeeDto employee1 = new EmployeeDto(1L, "John Doe", "john.doe@example.com", "IT", "Software Engineer");
        EmployeeDto employee2 = new EmployeeDto(1L, "John Doe", "john.doe@example.com", "IT", "Software Engineer");
        EmployeeDto employee3 = new EmployeeDto(2L, "Jane Smith", "jane.smith@example.com", "HR", "HR Manager");

        assertEquals(employee1, employee2);
        assertNotEquals(employee1, employee3);
        assertNotEquals(employee1, null);
        assertEquals(employee1, employee1);
    }

    @Test
    void testHashCode() {
        EmployeeDto employee1 = new EmployeeDto(1L, "John Doe", "john.doe@example.com", "IT", "Software Engineer");
        EmployeeDto employee2 = new EmployeeDto(1L, "John Doe", "john.doe@example.com", "IT", "Software Engineer");

        assertEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void testToString() {
        EmployeeDto employee = new EmployeeDto(1L, "John Doe", "john.doe@example.com", "IT", "Software Engineer");
        String expected = "EmployeeDto{id=1, name='John Doe', email='john.doe@example.com', department='IT', position='Software Engineer'}";
        
        assertEquals(expected, employee.toString());
    }
}
