package com.jbk.EmployeeCountryAngularProject.Dao;

import java.util.List;

import com.jbk.EmployeeCountryAngularProject.Entity.Country;

public interface CountryDao {

	public Boolean addCountry(Country country);

	public List<Country> getAllCountry();

	public Country getCountryById(Integer cid);

	public Boolean updateCountry(Country country);

	public Boolean deleteCountryById(Integer cid);
}
