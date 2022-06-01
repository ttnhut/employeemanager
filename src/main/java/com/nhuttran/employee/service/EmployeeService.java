/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.employee.service;

import com.nhuttran.employee.pojos.Employee;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(Long id);
}
