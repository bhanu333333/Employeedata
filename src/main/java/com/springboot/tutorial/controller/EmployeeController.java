package com.springboot.tutorial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tutorial.entity.Employee;
import com.springboot.tutorial.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service; 
	
	
	

	//@RequestMapping("/")	
	@GetMapping("/") 
	public String viewHomePage(Model model) {
		List<Employee> employeeList = service.listAll();
		model.addAttribute("listAll", employeeList);
		return "index";
	}
	
	//@RequestMapping("/new")	
	@GetMapping("/new")
	public String showNewEmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee,Model model,BindingResult result) {
		service.save(employee);
		
		List<Employee> employeeList = service.listAll();
		model.addAttribute("listAll", employeeList);
		model.addAttribute("employeeAttr",employee);
		return "redirect:/";
		
	}
	
	@GetMapping("/employee/{id}")	
	public String editEmployeeForm(@PathVariable int id,Model model) {
		
		model.addAttribute("employee", service.getEmployeeById(id));
		return "update_employee" ;
	
}
	@PostMapping("/employee/update/{id}")
	
	public String updateEmployee(@PathVariable int id,@ModelAttribute("employee") Employee employee,Model model) {
		Employee existingEmployee=service.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setName(employee.getName());
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setGender(employee.getGender());
		existingEmployee.setDept(employee.getDept());
		existingEmployee.setJoiningDate(employee.getJoiningDate());
		existingEmployee.setRetiringDate(employee.getRetiringDate());
		service.updateEmployee(existingEmployee);
		List<Employee> employeeList = service.listAll();
		model.addAttribute("listAll", employeeList);
		model.addAttribute("employeeAttr",employee);
		return "redirect:/";
	}
	
	@GetMapping("/employee/delete/{id}")	
	public String deleteEmployee(@PathVariable int id, @ModelAttribute("employee") Employee employee,Model model) {
		service.deleteEmployeeById(id);
		List<Employee> employeeList = service.listAll();
		model.addAttribute("listAll", employeeList);
		model.addAttribute("employeeAttr",employee);
		return "redirect:/";

		
	
	}
	
}
