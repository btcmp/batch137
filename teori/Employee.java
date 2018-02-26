package com.xsis.training.teori;

import java.util.Date;

//POJO -> encapsulation
//java bean
public class Employee{
	//set empty constructor
	public  Employee(){
		this.name = "rusdy";
	}
	//set parameter constructor
	public Employee(String id, String name, String email, Date hireDate, double saldo, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.hireDate = hireDate;
		this.saldo = saldo;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nama : "+ this.getName();
	}
	
	//property
	private String id;
	private String name;
	private String email;
	private Date hireDate;
	//variable primitive
	private double saldo;
	private Double salary;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
