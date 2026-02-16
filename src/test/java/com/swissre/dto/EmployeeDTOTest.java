package com.swissre.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeDTOTest {

    @Test
    void testDefaultConstructor() {
        EmployeeDTO employee = new EmployeeDTO();
        assertNotNull(employee);
    }

    @Test
    void testParameterizedConstructor() {
        EmployeeDTO employee = new EmployeeDTO(
            1L, 
            "John", 
            "Doe", 
            "john.doe@example.com", 
            "Engineering", 
            "Software Developer"
        );
        
        assertEquals(1L, employee.getId());
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("john.doe@example.com", employee.getEmail());
        assertEquals("Engineering", employee.getDepartment());
        assertEquals("Software Developer", employee.getPosition());
    }

    @Test
    void testSettersAndGetters() {
        EmployeeDTO employee = new EmployeeDTO();
        
        employee.setId(2L);
        employee.setFirstName("Jane");
        employee.setLastName("Smith");
        employee.setEmail("jane.smith@example.com");
        employee.setDepartment("Marketing");
        employee.setPosition("Marketing Manager");
        
        assertEquals(2L, employee.getId());
        assertEquals("Jane", employee.getFirstName());
        assertEquals("Smith", employee.getLastName());
        assertEquals("jane.smith@example.com", employee.getEmail());
        assertEquals("Marketing", employee.getDepartment());
        assertEquals("Marketing Manager", employee.getPosition());
    }

    @Test
    void testToString() {
        EmployeeDTO employee = new EmployeeDTO(
            1L, 
            "John", 
            "Doe", 
            "john.doe@example.com", 
            "Engineering", 
            "Software Developer"
        );
        
        String result = employee.toString();
        assertTrue(result.contains("EmployeeDTO"));
        assertTrue(result.contains("id=1"));
        assertTrue(result.contains("firstName='John'"));
        assertTrue(result.contains("lastName='Doe'"));
        assertTrue(result.contains("email='john.doe@example.com'"));
        assertTrue(result.contains("department='Engineering'"));
        assertTrue(result.contains("position='Software Developer'"));
    }
}
