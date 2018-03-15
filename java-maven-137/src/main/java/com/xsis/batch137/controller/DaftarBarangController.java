package com.xsis.batch137.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.batch137.model.Barang;
import com.xsis.batch137.model.Customer;
import com.xsis.batch137.model.Order;
import com.xsis.batch137.service.BarangService;
import com.xsis.batch137.service.CustomerService;
import com.xsis.batch137.service.ServiceOrder;

@Controller
@RequestMapping("/menu")
public class DaftarBarangController {
	
	@Autowired
	BarangService barangService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ServiceOrder serviceOrder;
	
	@RequestMapping
	public String index(Model model){
		List<Barang> daftarBarang = barangService.selectAll();
		List<Customer> daftarCustomer = customerService.selectAll();
		
		model.addAttribute("daftarBarang", daftarBarang);
		model.addAttribute("daftarCustomer", daftarCustomer);
		return "daftar-barang";
	}
	
	@RequestMapping(value="/src", method=RequestMethod.GET)
	public String indexBySearch(@RequestParam(value="search", defaultValue="") String search, Model model){
		
		List<Barang> daftarBarang = barangService.getBarangBySearchName(search);
		List<Customer> daftarCustomer = customerService.selectAll();
		model.addAttribute("daftarBarang", daftarBarang);
		model.addAttribute("daftarCustomer", daftarCustomer);
		System.out.println("search : "+ search);
		return "daftar-barang";
	}
	
	//order barang
	@RequestMapping(value="/order", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void orderBarang(@Valid @RequestBody Order order){
		serviceOrder.save(order);
	}
}
