/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.employee.controller;

import com.nhuttran.employee.pojos.Employee;
import com.nhuttran.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Asus
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/employees")
    public String listEmployees(Model model){
        model.addAttribute("employees" , employeeService.getAllEmployees());
        return "students";
    }
    
    @GetMapping("/employees/new")
    public String employeeForm(Model model){
        
        model.addAttribute("employee",new Employee());
        return "create_employee";
    }
    
    @PostMapping("/employees/new")
    public String saveStudent(@ModelAttribute("employee") Employee e){
        employeeService.saveEmployee(e);
        return "redirect:/employees";
    }
    
    @GetMapping("/employees/edit/{id}")
    public String editStudent(@PathVariable("id") Long id,Model model){
        model.addAttribute("employee",employeeService.getEmployeeById(id));
        return "edit_employee";
    }
    
    @PostMapping("/employees/{id}")
    public String updateStudent(@PathVariable("id") Long id , @ModelAttribute("employee") Employee e , Model model){
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setFirstName(e.getFirstName());
        existingEmployee.setLastName(e.getLastName());
        existingEmployee.setEmail(e.getEmail());
        
        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
