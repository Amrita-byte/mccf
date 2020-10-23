package com.ibm.mccf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.mccf.model.CurrencyConversionFactor;

@Controller
public class MCCFWebController {
	
	
	
	@RequestMapping(path = "/web/greet")
	public String getGreetingObject()
	{		
		return "welcome";
	}
	
	@RequestMapping(path = "/web/greeting/detail/{countrycode}")
	public String getGreetingObject(@PathVariable String countrycode, Model model)
	{	
		String id = java.util.UUID.randomUUID().toString();
		double conversionFactor = 20.5;
		CurrencyConversionFactor ccfactor = new CurrencyConversionFactor(id,countrycode,conversionFactor);		
		model.addAttribute("ccf", ccfactor);
		
		return "index";
	}

}
