package com.xsis.batch137.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.batch137.model.Barang;
import com.xsis.batch137.model.Customer;
import com.xsis.batch137.service.BarangService;
import com.xsis.batch137.service.CustomerService;

@Controller
@RequestMapping("/barang")
public class BarangController {

	@Autowired
	BarangService barangService;
	
	@RequestMapping
	public String index(){
		return "barang";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void viewBarang(@RequestBody Barang barang){
		barangService.save(barang);
	}
}
