package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.enumeration.EmployeeTypes;

public class Boss extends Employee {

	public int bossPass = 3582;

	private static List<Employee> empList = new ArrayList<>();

	public Boss(String employeeName, String empType, Double salary, Double workedHours) {
		super(employeeName, EmployeeTypes.BOSS, salary, workedHours);
	}

	public Boss() {

	}

	public String findEmployee(String name) {
		for (Employee emp : empList) {
			if (emp.getEmployeeName().equals(name)) {
				String result = "Employer Found, what you want do?";
				String result0 = "This is the name of employer: \n ";

				return result + result0 + "/n" + emp.getEmployeeName();

			}
		}
		return "Employee not found";
	}

	public Double desencreasySalary(String empName, Double valueOut, Double empWorkedHours) {
		for (Employee emp : empList) {
			if (empName.equals(emp.getEmployeeName())) {
				empWorkedHours = this.getWorkedHours();
				Double newSalary = this.getSalary() + valueOut;
				emp.setSalary(newSalary);
				return newSalary;
			}
		}
		return null;
	}

	public void autentication(int pass) {
		if (pass == bossPass) {
			bossOptions();
		} else {
			System.out.println("Error in authentication, exiting program for security reasons!");
			System.exit(0);
		}
	}

	public void bossMenu() {
		System.out.println("1. Enter your account");
		System.out.println("2. Change your type");
	}

	public void bossOptions() {
		System.out.println("1. Search for employee by name");
		System.out.println("2. Disencrasy Salary");
		System.out.println("3. Dismiss Employee");
	}

	public static List<Employee> getEmpList() {
		return empList;
	}

	public static void addEmployee(Employee employee) {
		empList.add(employee);
	}
}
