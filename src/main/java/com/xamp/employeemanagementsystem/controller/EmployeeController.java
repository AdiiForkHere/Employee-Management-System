package com.xamp.employeemanagementsystem.controller;

import com.xamp.employeemanagementsystem.entity.Employee;
import com.xamp.employeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "new_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {

        model.addAttribute("employee", employeeService.getEmployeeById(id));

        return "edit_employee";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployeeById(id);

        return "redirect:/employees";
    }
}