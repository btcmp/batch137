package com.xsis.batch137.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.model.Employee;

@Service
@Transactional
public class InitService {

	@Autowired
	EmployeeService employeeService;
	//save employee
	@PostConstruct
	public void init(){
		Employee employee = new Employee();
		employee.setId(1);
		//employee.setAddress("seputih banyak");
		employee.setName("Agung Jaya");
		employee.setEmail("seba@gmail.com");
		//employee.setSalary(50000.0);
		//employeeService.saveAtauUpdate(employee);
		//this.deleteEmp(6);
		//this.getDataEmployee();
	}
	
	//example get all
	public void getDataEmployee(){
		List<Employee> employees = employeeService.selectAll();
		for(Employee emp: employees){
			System.out.println("id : "+ emp.getId() + "name : "+ emp.getName());
		}
	}
	
	//example delete
	public void deleteEmp(int id){
		Employee emp = new Employee();
		emp.setId(id);
		emp.setEmail("-");
		employeeService.delete(emp);
	}
}
