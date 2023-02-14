package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		
		return "about";
	}
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		
		return "contact";
	}
	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public String services() {
		
		return "services";
	}

}
