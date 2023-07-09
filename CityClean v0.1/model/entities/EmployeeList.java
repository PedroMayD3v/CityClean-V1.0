package model.entities;

import model.enumeration.EmployeeTypes;
import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
	private List<Employee> employees;
	private Employee emp;

	public EmployeeList() {
		employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String dismissByName(String name) {
	    for (Employee employee : employees) {
	        if (employee.getEmployeeName().equals(name)) {
	            employees.remove(employee);
	            return "This employee has been fired!";
	        }
	    }
	    return "Employee not found.";
	}

}
