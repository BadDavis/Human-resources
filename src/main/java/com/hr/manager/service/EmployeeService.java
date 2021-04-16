package com.hr.manager.service;

import com.hr.manager.exception.UserNotFoundException;
import com.hr.manager.model.Employee;
import com.hr.manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repository.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return repository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + " was not found"));
    }

    public void deleteEmployee(Long id) {
        repository.deleteEmployeeById(id);
    }
}
