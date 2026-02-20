package com.swissre.dao;

import com.swissre.dto.EmployeeDTO;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final Map<Long, EmployeeDTO> store = new ConcurrentHashMap<>();

    @Override
    public void add(EmployeeDTO emp) {
        store.put(emp.getId(), emp);
    }

    @Override
    public void update(EmployeeDTO emp) {
        store.put(emp.getId(), emp);
    }

    @Override
    public EmployeeDTO get(Long id) {
        return store.get(id);
    }

    @Override
    public void delete(EmployeeDTO dto) {
        store.remove(dto.getId());
    }
}
