package model.entities;

import model.enumeration.EmployeeTypes;

public class Driver extends Employee {
	
	private String name;
	private Double workedHours;
	private Double salary;
    
	public Driver(String employeeName, String empType, Double salary, Double workedHours) {
		super(employeeName, EmployeeTypes.DRIVER, salary, workedHours);
		this.name = employeeName;
		this.workedHours = workedHours;
		this.salary = salary;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(Double workedHours) {
		this.workedHours = workedHours;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Double CalculateDriveHours(Double workedHours) {
		Double newSalary = null;
		if(workedHours > 160.00) {
			Double percent = 0.15;
			Double bonus = this.salary * percent;
			newSalary = this.salary + bonus;
		}
		return newSalary;
		
	}
	
	
	
	

}
