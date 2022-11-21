package com.jbk.EmployeeCountryAngularProject.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.EmployeeCountryAngularProject.Dao.EmployeeDao;
import com.jbk.EmployeeCountryAngularProject.Entity.Employee;
import com.jbk.EmployeeCountryAngularProject.Entity.Registration;

@Service
public class EmployeeService_Impl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public Boolean addEmployee(Employee employee) {
		//LocalDate localDate = LocalDate.now();
		//LocalTime localTime = LocalTime.now();
		//LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		//LocalDateTime localDateTime = LocalDateTime.now();
		//Date date = new Date();
		//employee.setCreateddate(date);
		//employee.setUpdateddate(localDateTime);
		return empDao.addEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return empDao.getAllEmployee();
	}

	@Override
	public Employee getEmployeeById(Integer empid) {
		
		return empDao.getEmployeeById(empid);
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		
		return empDao.updateEmployee(employee);
	}

	@Override
	public Boolean deleteEmployeeById(Integer empid) {
		
		return empDao.deleteEmployeeById(empid);
	}

	@Override
	public HashMap<String,Object> login(Registration reg) {
		
		HashMap<String,Object> map = new HashMap<>();
		Registration regObj = empDao.login(reg);
		System.out.println("In Service");
		System.out.println(regObj);
		if(regObj!=null) {
			if(regObj.getPassword().equals(reg.getPassword())) {
				map.put("msg", "Valid User");
				map.put("user", regObj);
			}
			else {
				map.put("msg", "Wrong Password");
				map.put("user", null);
			}
		}
		else {
			map.put("msg", "Invalid User");
			map.put("user", null);
		}
		return map;
	}

	@Override
	public Boolean registerEmployee(Registration employee) {
		
		Date date = new Date();
		employee.setCreateddate(date);
		return empDao.registerEmployee(employee);
	}

	@Override
	public boolean changeStatusById(Integer empid) {
		
		return empDao.changeStatusById(empid);
	}

}
