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

import com.jbk.EmployeeCountryAngularProject.Entity.Country;

@Repository
public class CountryDao_Impl implements CountryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Boolean addCountry(Country country) {
		
		Session session=null;
		Boolean b=false;
		try {
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			criteria.add(Restrictions.eq("cname", country.getCname()));
			Country country1 = (Country) criteria.uniqueResult();
			if(country1==null)
			{
				Transaction transaction = session.beginTransaction();
				session.save(country);
				transaction.commit();
				b=true;
			}

		}catch (NonUniqueResultException nure) {
			nure.getMessage();
			//System.out.println("Country already Exist...");;
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
	public List<Country> getAllCountry() {
		
		Session session=null;
		List<Country> countries = null;
		try {
			session=sessionFactory.openSession();
			countries = session.createCriteria(Country.class).list();

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return countries;
	}

	@Override
	public Country getCountryById(Integer cid) {
		
		Session session=null;
		Country country = null;
		try {
			session=sessionFactory.openSession();
			country = session.get(Country.class,cid);

		}catch (Exception e) {
			e.getMessage();
			//e.printStackTrace();
		}
		finally {
			session.close();
		}
		return country;
	}

	@Override
	public Boolean updateCountry(Country country) {
		
		Session session=null;
		Country country1 = null;
		Boolean b=false;
		try {
			session=sessionFactory.openSession();
			country1 = getCountryById(country.getCid());
			
			if(country1!=null)
			{
				Transaction transaction = session.beginTransaction();
				session.update(country);
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
	public Boolean deleteCountryById(Integer cid) {
		
		Session session=null;
		Country country1 = null;
		Boolean b=false;
		try {
			session=sessionFactory.openSession();
			country1 = session.get(Country.class,cid);
			
			if(country1!=null)
			{
				Transaction transaction = session.beginTransaction();
				session.delete(country1);
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

}
