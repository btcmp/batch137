package com.xsis.batch137.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SessionFactory sessionFacktory;
	
	public void save(Order order) {
		// TODO Auto-generated method stub
		Session session = sessionFacktory.getCurrentSession();
		session.save(order);
		session.flush();
	}

}
