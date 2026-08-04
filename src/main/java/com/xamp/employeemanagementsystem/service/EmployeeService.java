package com.xamp.employeemanagementsystem.service;

import com.xamp.employeemanagementsystem.entity.Employee;
import com.xamp.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // =========================
    // CRUD Operations
    // =========================

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id : " + id));
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    // =========================
    // Dashboard Statistics
    // =========================

    public long getTotalEmployees() {
        return employeeRepository.count();
    }

    public long getActiveEmployees() {
        return employeeRepository.countByStatus("Active");
    }

    public long getTotalDepartments() {
        return employeeRepository.countDistinctDepartments();
    }

    public Double getTotalPayroll() {
        return employeeRepository.getTotalPayroll();
    }
}