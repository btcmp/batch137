package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.OrderDao;
import com.xsis.batch137.model.Customer;
import com.xsis.batch137.model.Order;

@Service
@Transactional
public class ServiceOrder {

	@Autowired
	OrderDao orderDao;
	
	public void save(Order order) {
		// TODO Auto-generated method stub
		Order oldOrder  = this.searchOrderByCustomerByIdOrder(order);
		int newJb = 0; 
		if(oldOrder != null){
			//update
			newJb = oldOrder.getJumlahBeli() + order.getJumlahBeli();
			order.setJumlahBeli(newJb);
			order.setId(oldOrder.getId());;
			this.update(order);
		}else
		orderDao.save(order);
	}

	public List<Order> searchOrderByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return orderDao.searchOrderByCustomer(customer);
	}

	public Order searchOrderByCustomerByIdOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDao.searchOrderByCustomerByIdOrder(order);
	}

	public void update(Order order) {
		// TODO Auto-generated method stub
		orderDao.update(order);
	}

}
