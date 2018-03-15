package com.xsis.batch137.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.OrderDao;
import com.xsis.batch137.model.Order;

@Service
@Transactional
public class ServiceOrder {

	@Autowired
	OrderDao orderDao;
	
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
	}

}
