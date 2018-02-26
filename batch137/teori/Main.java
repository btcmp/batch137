package com.xsis.training.teori;

public class Main {
	
	public static void main(String args[]){
		//new => instansiasi object 
		/*Employee emp = new Employee();
		emp.setEmail("arrizaqu@yahoo.com");
		emp.setName("dudung");
		emp.setHireDate(null);
		emp.setSalary(60000.0);
		Employee emp2 = new Employee("satu", "ari", "arri", null, 0.0, 0.0);
		System.out.println(emp.getName());
		//untuk menyimpan data dalam database => data collection
		Employee[] listEmployee = new Employee[3];
		listEmployee[0] = emp;
		listEmployee[1] = emp2;*/
		
		Employee emp1 = new Employee();
		Manager mng = new Manager();
		Manager dir = new Director();
		
		emp1.setName("danang");
		emp1.setSalary(20000.0);
		mng.setName("manager");
		mng.setSalary(20000.0);
		System.out.println("name : "+ mng.getName());
		System.out.println("salary : "+ mng.getSalary());
	
		//dapat bonus
		//emp1.bonus();
		mng.bonus();
		dir.bonus();
	}

}
