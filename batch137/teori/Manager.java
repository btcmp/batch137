package com.xsis.training.teori;

public class Manager extends Employee{

	@Override
	public Double getSalary() {
		// TODO Auto-generated method stub
		return super.getSalary() + 20000;
	}
	
	@Override
	public void setSalary(Double salary) {
		// TODO Auto-generated method stub
		super.setSalary(salary- 20000) ;
	}
	
	public Double bonus(){
		return super.getSalary() * 2;
	}
}
