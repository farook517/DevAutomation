package com.swissre.dao;

import com.swissre.dto.EmployeeDTO;

public interface EmployeeDAO {

    void add(EmployeeDTO emp);

    void update(EmployeeDTO emp);

    EmployeeDTO get(Long id);

    void delete(EmployeeDTO emp);
}
