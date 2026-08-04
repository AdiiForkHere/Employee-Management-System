package com.xamp.employeemanagementsystem.controller;

import com.xamp.employeemanagementsystem.entity.Employee;
import com.xamp.employeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // =========================
    // Dashboard / Employee List
    // =========================
    @GetMapping("/employees")
    public String listEmployees(Model model) {

        model.addAttribute("employees", employeeService.getAllEmployees());

        // Dashboard Statistics
        model.addAttribute("totalEmployees", employeeService.getTotalEmployees());
        model.addAttribute("activeEmployees", employeeService.getActiveEmployees());
        model.addAttribute("departmentCount", employeeService.getTotalDepartments());
        model.addAttribute("totalPayroll", employeeService.getTotalPayroll());

        return "employees";
    }

    // =========================
    // Open Add Employee Form
    // =========================
    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model) {

        model.addAttribute("employee", new Employee());

        return "new_employee";
    }

    // =========================
    // Save Employee
    // =========================
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

    // =========================
    // Open Edit Employee Form
    // =========================
    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {

        model.addAttribute("employee",
                employeeService.getEmployeeById(id));

        return "edit_employee";
    }

    // =========================
    // Update Employee
    // =========================
    @PostMapping("/employees/{id}")
    public String updateEmployee(
            @PathVariable Long id,
            @ModelAttribute("employee") Employee employee) {

        Employee existingEmployee = employeeService.getEmployeeById(id);

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setJoiningDate(employee.getJoiningDate());
        existingEmployee.setStatus(employee.getStatus());

        employeeService.saveEmployee(existingEmployee);

        return "redirect:/employees";
    }

    // =========================
    // Delete Employee
    // =========================
    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployeeById(id);

        return "redirect:/employees";
    }
}