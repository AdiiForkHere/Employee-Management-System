package com.xamp.employeemanagementsystem.service;

import com.xamp.employeemanagementsystem.entity.Department;
import com.xamp.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Save department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get department by ID
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Department not found with id: " + id)
        );
    }

    // Delete department
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
}