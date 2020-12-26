package com.sapient.service;

import java.util.List;

import com.sapient.model.Employee;

public interface EmployeeService {

    public Employee getEmployeeById(Long id);
    public Employee getEmployeeByName(String name);
    public List<Employee> getAllEmployees();
    public boolean exists(String email);
    public Employee save(Employee employee);
    public List<Employee> getAllSalaryGreaterThan(Double salary);
}
