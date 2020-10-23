package com.ibm.mccf.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.mccf.model.CurrencyConversionFactor;
import com.ibm.mccf.repository.ConversionFactorRepository;

public class ConversionFactorService {

	@Autowired
	ConversionFactorRepository conversionrepo;
	
	@Autowired
	CurrencyConversionFactor ccfactorObj;
	
	
	public ConversionFactorService(ConversionFactorRepository conversionrepo) {
		super();
		//constructor injection happening here for repo
		this.conversionrepo = conversionrepo;
		//this.ccfactor = ccfactor;
	}

	public ConversionFactorService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String addCoversionFactor(String countrycode, double conversionfactor) {
		String id = java.util.UUID.randomUUID().toString();
		// autowire not working
		ccfactorObj = new CurrencyConversionFactor(id,countrycode,conversionfactor);
		/*
		 * ccfactor.setId(id); ccfactor.setCountryCode(countrycode);
		 * ccfactor.setConversionFactor(conversionfactor);
		 */
		
		conversionrepo.save(ccfactorObj);
		return "success" ;
	}
	public double getCoversionFactor(String countrycode) {
		
		// autowire not working
		
		/*
		 * ccfactor.setId(id); ccfactor.setCountryCode(countrycode);
		 * ccfactor.setConversionFactor(conversionfactor);
		 */
		Optional<CurrencyConversionFactor> ccfactorRepoObj = conversionrepo.findById(countrycode);
		ccfactorObj = ccfactorRepoObj.get();
		double ccfactor = ccfactorObj.getConversionFactor();
		return ccfactor ;
	}
	
	public String updateCoversionFactor(String countrycode,double conversionfactor) {		
		Optional<CurrencyConversionFactor> ccfactorRepoObj = conversionrepo.findById(countrycode);
		ccfactorObj = ccfactorRepoObj.get();
		ccfactorObj.setConversionFactor(conversionfactor);
		conversionrepo.save(ccfactorObj);
		return "success" ;
	}
	
	public CurrencyConversionFactor getCoversionFactorObj(String countrycode) {
		
		Optional<CurrencyConversionFactor> ccfactorRepoObj = conversionrepo.findById(countrycode);
		ccfactorObj = ccfactorRepoObj.get();
		
		return ccfactorObj ;
	}
	
	public CurrencyConversionFactor[] getCoversionFactorList() {	
		List<CurrencyConversionFactor> CurrencyConversionFactorlist =  new ArrayList<CurrencyConversionFactor>();
		List<CurrencyConversionFactor> ccfactorRepoObjList = conversionrepo.findAll();
		Iterator<CurrencyConversionFactor> ccfactoritr = ccfactorRepoObjList.iterator();
		CurrencyConversionFactor[]  CurrencyConversionFactors = null ;
		return CurrencyConversionFactors;
	}

	public CurrencyConversionFactor addConversionFactorDiscovery(String countrycode, double conversionFactor) {
		// TODO Auto-generated method stub
		String id = java.util.UUID.randomUUID().toString();
		ccfactorObj = new CurrencyConversionFactor(id,countrycode,conversionFactor);
		conversionrepo.save(ccfactorObj);
		return getCoversionFactorObj(countrycode);
	}

}
