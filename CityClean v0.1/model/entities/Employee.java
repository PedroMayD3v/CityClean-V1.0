package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.enumeration.EmployeeTypes;

public abstract class Employee {

	private String employeeName;
	private EmployeeTypes employeeType;
	private Double salary;
	private Double workedHours;
	private Double bonus;

	private static List<Employee> empList = new ArrayList<>();
	
	public Employee(String employeeName, EmployeeTypes employeeType, Double salary, Double workedHours) {
		this.employeeName = employeeName;
		this.employeeType = employeeType;
		this.salary = salary;
		this.workedHours = workedHours;
		empList.add(this);
	}
	
	public Employee() {
	}
	
	public Double getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(Double workedHours) {
		this.workedHours = workedHours;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public EmployeeTypes getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeTypes employeeType) {
		this.employeeType = employeeType;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Employee desencreasySalary(Employee emp, Double valueOut) {
		   emp.setSalary(emp.getSalary() - valueOut);
		   return emp; // Retorno da variável atualizada
	}

	
	@Override
	public String toString() {
		return  "====EMPLOYER OBSERVATIONS===="
				+ "\n"
				+"Employee Name: \n" 
	            + employeeName 
	            + "\n" 
	            + "Employee Type: "
	            + employeeType 
	            + "\n" 
	            + "Salary: "
	            + salary
	            + "\n"
				+ "Worker Hours = "
				+ workedHours 
				+ "\n";
	}
	
	
}
