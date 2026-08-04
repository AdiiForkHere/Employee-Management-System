package com.xamp.employeemanagementsystem.repository;

import com.xamp.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Total Active Employees
    long countByStatus(String status);

    // Total Departments
    @Query("SELECT COUNT(DISTINCT e.department) FROM Employee e")
    long countDistinctDepartments();

    // Total Payroll
    @Query("SELECT COALESCE(SUM(e.salary), 0) FROM Employee e")
    Double getTotalPayroll();
}