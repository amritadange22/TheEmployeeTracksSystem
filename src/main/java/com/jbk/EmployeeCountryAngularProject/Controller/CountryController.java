package com.jbk.EmployeeCountryAngularProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.EmployeeCountryAngularProject.Entity.Country;
import com.jbk.EmployeeCountryAngularProject.Service.CountryService;

@RestController
@CrossOrigin
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@PostMapping(value="/addCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country country) {
		Boolean b = countryService.addCountry(country);
		
		if(b)
		{
			return new ResponseEntity<String>("Country Saved!!!",HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>("Country already Exist!!!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/getAllCountry")
	public ResponseEntity<List<Country>> getAllCountry() {
		List<Country> countries = countryService.getAllCountry();
		
		if(!countries.isEmpty())
		{
			return new ResponseEntity<List<Country>>(countries,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/getCountryById")
	public ResponseEntity<Country> getCountryById(@RequestParam Integer cid) {
		Country country = countryService.getCountryById(cid);
		
		if(country!=null)
		{
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="/updateCountry")
	public ResponseEntity<String> updateCountry(@RequestBody Country country) {
		Boolean b = countryService.updateCountry(country);
		
		if(b)
		{
			return new ResponseEntity<String>("Country Updated Successfully!!!",HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<String>("Country Not Updated",HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value="/deleteCountryById")
	public ResponseEntity<String> deleteCountryById(@RequestParam Integer cid) {
		Boolean b = countryService.deleteCountryById(cid);
		
		if(b)
		{
			return new ResponseEntity<String>("Country Deleted Successfully!!!",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Country Not Deleted",HttpStatus.NO_CONTENT);
	}
}
