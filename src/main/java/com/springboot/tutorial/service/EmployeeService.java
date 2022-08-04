package com.springboot.tutorial.service;

import java.util.List;
import com.springboot.tutorial.entity.Employee;
public interface EmployeeService {

	List<Employee> listAll();
	
    void save(Employee employee);
    Employee getEmployeeById(int id);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(int id);



}
