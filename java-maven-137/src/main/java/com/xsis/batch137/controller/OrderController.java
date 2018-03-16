package com.xsis.batch137.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsis.batch137.model.Customer;
import com.xsis.batch137.model.Order;
import com.xsis.batch137.service.CustomerService;
import com.xsis.batch137.service.ServiceOrder;

@Controller
@RequestMapping(value="/order")
public class OrderController {

	/*
	 * URL : http://mysite.com/order/{ids} = @PathVariable
	 * URL : http://mysite.com/order?customer=12 => @RequestParam
	 * */ 
	@Autowired
	ServiceOrder serviceOrder;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping
	public String index(@RequestParam("customer") String id, Model model){
		/*
		 * ambil data order sesuai dengan customer yang belum di bayar
		 */
		Customer customer = customerService.getCustomerById(id);
		List<Order> dataOrder = serviceOrder.searchOrderByCustomer(customer);
		
		float totalHarga = 0;
		int totalItem = 0;
		for(Order order : dataOrder){
			float total = order.getBarang().getHarga() * order.getJumlahBeli();
			totalHarga = totalHarga + total;
			totalItem = totalItem + 1;
		}
		
		model.addAttribute("customer", customer);
		model.addAttribute("orders", dataOrder);
		model.addAttribute("totalHarga", totalHarga);
		model.addAttribute("totalItem", totalItem);
		
		return "daftar-order";
	}
}
