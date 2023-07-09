package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.enumeration.EmployeeTypes;

public class Manager extends Employee {

	private Collector collector;
	private String nameManger;
	private Double salary;
	private Double workedHours;

	public Manager() {

	}

	public Manager(String employeeName, String employeeType, Double salary, Double workedHours) {
		super(employeeName, EmployeeTypes.MANAGER, salary, workedHours);
		this.collector = collector;
		this.nameManger = employeeName;
		this.salary = salary;
		this.workedHours = workedHours;
	}

	public void showMangerMenu() {
		System.out.println("1. See the Collector list.");
		System.out.println("2. Desencrase salary based on worked hours.");
		System.out.println("3. Set DayOff for some employee: ");
		System.out.print("Enter Option:");
	}

	public List<Collector> showListofCollector(List<Collector> collectorList) {
		System.out.println("Collector List:");
		for (Collector collector : collectorList) {
			System.out.println(collector.getEmployeeName());
			System.out.println("Salary: " + collector.getSalary());
		}
		return new ArrayList<>(collectorList);
	} //Sempre que retornar uma lista de arrays é bom retornar uma NEW e instanciar o arrayList com o parametro do tipo List  


}
