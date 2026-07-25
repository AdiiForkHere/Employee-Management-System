package com.xamp.employeemanagementsystem.service;

import com.xamp.employeemanagementsystem.entity.Employee;
import com.xamp.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}