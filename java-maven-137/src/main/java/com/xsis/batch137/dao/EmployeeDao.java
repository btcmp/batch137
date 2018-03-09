package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Employee;

public interface EmployeeDao {

	//create
	public void save(Employee employee);
	//jamak employee -- list
	public List<Employee> selectAll();
	//single employee
	public Employee getOne(Employee employee);
	//delete
	public void delete(Employee employee);
	//update
	public void update(Employee employee);
	//save or update
	public void saveAtauUpdate(Employee employee);
}
