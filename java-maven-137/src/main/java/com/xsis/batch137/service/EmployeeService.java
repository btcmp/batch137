package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.EmployeeDao;
import com.xsis.batch137.dao.EmployeeDaoImpl;
import com.xsis.batch137.model.Employee;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	public void save(Employee employee){
		employeeDao.save(employee);
	}
	
	public List<Employee> selectAll(){
		return employeeDao.selectAll();
	}
	
	public void delete(Employee employee){
		employeeDao.delete(employee);
	}
	
	public void saveAtauUpdate(Employee employee){
		employeeDao.saveAtauUpdate(employee);
	}

	public Employee getOne(int id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setId(id);
		return employeeDao.getOne(employee);
	}
}
