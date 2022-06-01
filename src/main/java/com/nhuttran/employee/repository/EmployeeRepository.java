/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhuttran.employee.repository;

import com.nhuttran.employee.pojos.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Asus
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
