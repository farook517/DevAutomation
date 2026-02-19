package com.swissre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EmployeeControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        EmployeeService employeeService = new EmployeeService();
        EmployeeController controller = new EmployeeController(employeeService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllEmployees_returnsListOfEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].name").value("Alice Johnson"));
    }

    @Test
    void getEmployeeById_existingId_returnsEmployee() throws Exception {
        mockMvc.perform(get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Alice Johnson"))
                .andExpect(jsonPath("$.department").value("Engineering"))
                .andExpect(jsonPath("$.email").value("alice.johnson@swissre.com"));
    }

    @Test
    void getEmployeeById_nonExistingId_returnsNotFound() throws Exception {
        mockMvc.perform(get("/employees/99"))
                .andExpect(status().isNotFound());
    }
}
