package com.xsis.batch137.dao;

import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		session.flush();
	}

	public List<Employee> selectAll() {
		// TODO Auto-generated method stub
		// HQL hibernate query language
		String hql = "from Employee";
		Session session = sessionFactory.getCurrentSession();
		//session.createCriteria(Employee.class).list();
		List<Employee> employees = session.createQuery(hql).list();
		if(employees.isEmpty())
			return null;
			else 
		return employees;
	}

	public Employee getOne(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//return session.get(Employee.class, employee.getId());
		String hql = "from Employee emp where emp.id = :empid";
		List<Employee> employees = session.createQuery(hql).
				setParameter("empid", employee.
						getId()).list();
		Employee emp = employees.get(0);
		if(employees.isEmpty())
			return null;
			else
		return emp;
	}

	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(employee);
		session.flush();
	}

	public void update(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
		session.flush();
	}

	public void saveAtauUpdate(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
		session.flush();
	}

}
