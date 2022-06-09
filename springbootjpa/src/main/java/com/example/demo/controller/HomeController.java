package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;


@RestController
public class HomeController {
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@DeleteMapping("/employee/{eid}")
	public String deleteById(@PathVariable int eid)
	{
		Employee employee=repo.getOne(eid);
		repo.delete(employee);
		return "deleted";
		
		
	}
	@PostMapping(path="/employee",consumes= {"application/json"})
	public Employee addEmployee(@RequestBody Employee employee)
	{
		repo.save(employee);
		return employee;
	}
	@GetMapping(path="/employees")
	public List<Employee> getEmployees()
	{
	   return repo.findAll();
	}
	@PutMapping(path="/employee",consumes= {"application/json"})
	public Employee saveOrUpdate(@RequestBody Employee employee)
	{
		repo.save(employee);
		return employee;
	}
	@RequestMapping("/employee/{eid}")
	public Optional<Employee> getEmployee(@PathVariable("eid") int eid)
	{
		return repo.findById(eid);
	}
}
