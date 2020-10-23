package com.ibm.mccf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.mccf.model.CurrencyConversionFactor;
import com.ibm.mccf.repository.ConversionFactorRepository;
import com.ibm.mccf.service.ConversionFactorService;

@RestController
public class ManageCurrencyConversionFactorController {
	

	@Autowired
	ConversionFactorRepository conversionrepo;
	
	/*
	 * @Autowired CurrencyConversionFactor ccfactor;
	 */

	
	public ManageCurrencyConversionFactorController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = "/welcome")
	public String geWelcome() {		
		return "Welcome" ;
	}
	
	@GetMapping(path = "/getConversionFactor/{countrycode}")
	public double getConversionFactor(@PathVariable String countrycode) {	
		ConversionFactorService cfService = new ConversionFactorService(conversionrepo);
		double ccfactor = cfService.getCoversionFactor(countrycode)	;	
		return ccfactor ;
	}
	
	@GetMapping(path = "/addConversionFactor/{countrycode}/{conversionFactor}")
	public String addConversionFactor(@PathVariable String countrycode,
			@PathVariable double conversionFactor) {		
		//CurrencyConversionService ccService = new CurrencyConversionService(conversionrepo,ccfactor);
		ConversionFactorService cfService = new ConversionFactorService(conversionrepo);
		String response = cfService.addCoversionFactor(countrycode, conversionFactor);		
		return response ;
	}
	
	@GetMapping(path = "/addConversionFactorDiscovery/{countrycode}/{conversionFactor}")
	public CurrencyConversionFactor addConversionFactorDiscovery(@PathVariable String countrycode,
			@PathVariable double conversionFactor) {		
		//CurrencyConversionService ccService = new CurrencyConversionService(conversionrepo,ccfactor);
		ConversionFactorService cfService = new ConversionFactorService(conversionrepo);
		return cfService.addConversionFactorDiscovery(countrycode, conversionFactor);		
		
	}
	
	@GetMapping(path = "/updateConversionFactor/{countrycode}/{conversionFactor}")
	public String updateConversionFactor(@PathVariable String countrycode,
			@PathVariable double conversionFactor) {		
		//CurrencyConversionService ccService = new CurrencyConversionService(conversionrepo,ccfactor);
		ConversionFactorService cfService = new ConversionFactorService(conversionrepo);
		String response = cfService.updateCoversionFactor(countrycode, conversionFactor);		
		return response ;
	}
	
	@GetMapping(path = "/getConversionFactorObj/{countrycode}")
	public CurrencyConversionFactor getConversionFactorObj(@PathVariable String countrycode) {	
		ConversionFactorService cfService = new ConversionFactorService(conversionrepo);
		return cfService.getCoversionFactorObj(countrycode)	;	
		
	}
	
	@GetMapping(path = "/getConversionFactorList")
	public CurrencyConversionFactor[] getCoversionFactorObjList() {	
		ConversionFactorService cfService = new ConversionFactorService(conversionrepo);
		return cfService.getCoversionFactorList()	;	
		
	}
	
}
