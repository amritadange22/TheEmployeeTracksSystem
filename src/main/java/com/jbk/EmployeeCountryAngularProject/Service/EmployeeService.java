package com.jbk.EmployeeCountryAngularProject.Service;

import java.util.HashMap;
import java.util.List;

import com.jbk.EmployeeCountryAngularProject.Entity.Employee;
import com.jbk.EmployeeCountryAngularProject.Entity.Registration;

public interface EmployeeService {

	public Boolean addEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(Integer empid);

	public Boolean updateEmployee(Employee employee);

	public Boolean deleteEmployeeById(Integer empid);

	public HashMap<String,Object> login(Registration reg);

	public Boolean registerEmployee(Registration employee);

	public boolean changeStatusById(Integer empid);
}
