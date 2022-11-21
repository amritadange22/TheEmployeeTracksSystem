package com.jbk.EmployeeCountryAngularProject.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.EmployeeCountryAngularProject.Entity.Employee;
import com.jbk.EmployeeCountryAngularProject.Entity.Registration;

@Repository
public class EmployeeDao_Impl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Boolean addEmployee(Employee employee) {
		Session session=null;
		Boolean b=false;
		try {
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("ename", employee.getEname()));
			Employee emp = (Employee) criteria.uniqueResult();
			if(emp==null)
			{
				Transaction transaction = session.beginTransaction();
				session.save(employee);
				transaction.commit();
				b=true;
			}

		}catch (NonUniqueResultException nure) {
			System.out.println("Employee already Exist...");;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return b;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session=null;
		List<Employee> employees = null;
		try {
			session=sessionFactory.openSession();
			employees = session.createCriteria(Employee.class).list();

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(Integer empid) {
		
		Session session=null;
		Employee employee = null;
		try {
			session=sessionFactory.openSession();
			employee = session.get(Employee.class,empid);

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return employee;
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		
		Session session=null;
		Employee emp = null;
		Boolean b=false;
		try {
			session=sessionFactory.openSession();
			emp = getEmployeeById(employee.getEmpid());
			
			if(emp!=null)
			{
				Transaction transaction = session.beginTransaction();
				session.update(employee);
				transaction.commit();
				b=true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return b;
	}

	@Override
	public Boolean deleteEmployeeById(Integer empid) {
		
		Session session=null;
		Employee emp = null;
		Boolean b=false;
		try {
			session=sessionFactory.openSession();
			emp = session.get(Employee.class,empid);
			
			if(emp!=null)
			{
				Transaction transaction = session.beginTransaction();
				session.delete(emp);
				transaction.commit();
				b=true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return b;
	}

	@Override
	public Registration login(Registration reg) {
		
		Session session=null;
		Registration regObj = null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Registration.class);
			criteria.add(Restrictions.eq("emailid", reg.getEmailid()));
			regObj = (Registration) criteria.uniqueResult();
			//session=sessionFactory.openSession();
			//regObj = session.get(Registration.class,reg.getEmailid());

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return regObj;
	}

	@Override
	public Boolean registerEmployee(Registration employee) {
		
		Session session=null;
		Boolean b=false;
		try {
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Registration.class);
			criteria.add(Restrictions.eq("emailid", employee.getEmailid()));
			Registration emp = (Registration) criteria.uniqueResult();
			if(emp==null)
			{
				Transaction transaction = session.beginTransaction();
				session.save(employee);
				transaction.commit();
				b=true;
			}

		}catch (NonUniqueResultException nure) {
			System.out.println("Employee already Exist...");;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return b;
	}

	@Override
	public boolean changeStatusById(Integer empid) {
		
		Session session=null;
		Employee emp = null;
		boolean b = false;
		try {
			session=sessionFactory.openSession();
			emp = getEmployeeById(empid);
			
			if(emp!=null)
			{
				Transaction transaction = session.beginTransaction();
				if(emp.getStatus().equals("active")) {
					emp.setStatus("inactive");
					session.update(emp);
					b=true;
				}
				else {
					emp.setStatus("active");
					session.update(emp);
					b=true;
				}
				transaction.commit();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return b;
	}
}
