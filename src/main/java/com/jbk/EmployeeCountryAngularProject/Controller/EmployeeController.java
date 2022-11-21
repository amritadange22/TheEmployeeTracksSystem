package com.jbk.EmployeeCountryAngularProject.Controller;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.EmployeeCountryAngularProject.Entity.Employee;
import com.jbk.EmployeeCountryAngularProject.Entity.Registration;
import com.jbk.EmployeeCountryAngularProject.Service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/login")
	public HashMap<String,Object> login(@RequestBody Registration reg) {
		
		return empService.login(reg);
		
		/*
		 * JSONObject jsonObj = new JSONObject(empService.login(reg));
		 * System.out.println(jsonObj); 
		 * return jsonObj;
		 */
	}
	
	@PostMapping(value="/registerEmployee")
	public ResponseEntity<String> registerEmployee(@RequestBody Registration employee) {
		Boolean b = empService.registerEmployee(employee);
		
		if(b)
		{
			return new ResponseEntity<String>("Employee Registered!!!",HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>("Employee already Exist!!!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		Boolean b = empService.addEmployee(employee);
		
		if(b)
		{
			return new ResponseEntity<String>("Employee Saved!!!",HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>("Employee already Exist!!!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = empService.getAllEmployee();
		
		if(!employees.isEmpty())
		{
			return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/getEmployeeById")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam Integer empid) {
		Employee employee = empService.getEmployeeById(empid);
		
		if(employee!=null)
		{
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="/updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		Boolean b = empService.updateEmployee(employee);
		
		if(b)
		{
			return new ResponseEntity<String>("Employee Updated Successfully!!!",HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<String>("Employee Not Updated",HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value="/deleteEmployeeById")
	public ResponseEntity<String> deleteEmployeeById(@RequestParam Integer empid) {
		Boolean b = empService.deleteEmployeeById(empid);
		
		if(b)
		{
			return new ResponseEntity<String>("Employee Deleted Successfully!!!",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Employee Not Deleted",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/changeStatus/{empid}")
	public ResponseEntity<String> changeStatusById(@PathVariable Integer empid) {
		boolean b = empService.changeStatusById(empid);
		
		if(b)
		{
			return new ResponseEntity<String>("Employee Updated Successfully!!!",HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<String>("Employee Not Updated",HttpStatus.NO_CONTENT);
		 
	}
}
