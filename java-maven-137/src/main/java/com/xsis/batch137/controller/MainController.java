package com.xsis.batch137.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping
	@ResponseBody
	public String index(){
		return "hallo world java spring";
	}
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about(){
		return "about";
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	@ResponseBody
	public String contact(){
		return "contact";
	}
}
