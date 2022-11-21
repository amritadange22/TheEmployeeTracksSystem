package com.jbk.EmployeeCountryAngularProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.EmployeeCountryAngularProject.Dao.CountryDao;
import com.jbk.EmployeeCountryAngularProject.Entity.Country;

@Service
public class CountryService_Impl implements CountryService {

	@Autowired
	private CountryDao countryDao;
	
	@Override
	public Boolean addCountry(Country country) {
		
		return countryDao.addCountry(country);
	}

	@Override
	public List<Country> getAllCountry() {
		
		return countryDao.getAllCountry();
	}

	@Override
	public Country getCountryById(Integer cid) {
		
		return countryDao.getCountryById(cid);
	}

	@Override
	public Boolean updateCountry(Country country) {
		
		return countryDao.updateCountry(country);
	}

	@Override
	public Boolean deleteCountryById(Integer cid) {
		
		return countryDao.deleteCountryById(cid);
	}

}
