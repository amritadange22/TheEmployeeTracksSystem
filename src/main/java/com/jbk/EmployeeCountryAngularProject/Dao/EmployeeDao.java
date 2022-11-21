package com.jbk.EmployeeCountryAngularProject.Dao;

import java.util.List;

import org.json.JSONObject;

import com.jbk.EmployeeCountryAngularProject.Entity.Employee;
import com.jbk.EmployeeCountryAngularProject.Entity.Registration;

public interface EmployeeDao {

	public Boolean addEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(Integer empid);

	public Boolean updateEmployee(Employee employee);

	public Boolean deleteEmployeeById(Integer empid);

	public Registration login(Registration reg);

	public Boolean registerEmployee(Registration employee);

	public boolean changeStatusById(Integer empid);
}
