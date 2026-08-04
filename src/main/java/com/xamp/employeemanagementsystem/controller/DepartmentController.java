package com.xamp.employeemanagementsystem.controller;

import com.xamp.employeemanagementsystem.entity.Department;
import com.xamp.employeemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Display all departments
    @GetMapping("/departments")
    public String viewDepartments(Model model) {

        model.addAttribute("departments", departmentService.getAllDepartments());

        return "departments";
    }

    // Open Add Department Form
    @GetMapping("/departments/new")
    public String showNewDepartmentForm(Model model) {

        Department department = new Department();

        model.addAttribute("department", department);

        return "new_department";
    }

    // Save Department
    @PostMapping("/departments")
    public String saveDepartment(@ModelAttribute("department") Department department) {

        departmentService.saveDepartment(department);

        return "redirect:/departments";
    }
}