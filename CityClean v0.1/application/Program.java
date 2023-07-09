package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

import model.entities.Boss;
import model.entities.Collector;
import model.entities.Driver;
import model.entities.Employee;
import model.entities.Manager;
import model.enumeration.EmployeeTypes;

public class Program {
	
	public static List<Employee> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		char option;
		String empType;
		Double hoursWorked = null;

		list = new ArrayList<>();
		
		List<Boss> bossList = new ArrayList<>();
		List<Collector> collectorList = new ArrayList<>();
		List<Manager> managerList = new ArrayList<>();
		List<Driver> driverList = new ArrayList<>();

		UI.welcomeMessage();

		System.out.print("Enter the number of employees will be read: ");
		int numEmployees = sc.nextInt();
		sc.nextLine(); // Limpar o buffer do scanner

		for (int i = 0; i < numEmployees; i++) {
			System.out.println("Employee #" + (i + 1));
			System.out.println("============================");
			System.out.println();
			System.out.print("Enter the type of worker: ");
			empType = sc.next();
			System.out.print("Enter the complete name of employee: ");
			String empName = sc.next();
			System.out.println("=============================");
			System.out.println();
			EmployeeTypes.valueOf(empType);

			if (empType.equals("BOSS")) {

				System.out.print("Enter the salary of this boss on this mounth: ");
				Double empSalary = sc.nextDouble();
				System.out.print("Enter the total value sold this month: ");
				Double empSales = sc.nextDouble();
				Employee boss = new Boss(empName, empType, empSalary, empSales);
				list.add(boss);
				bossList.add((Boss) boss);

			} else if (empType.equals("COLLECTOR")) {

				System.out.print("Enter the hours worked in this mounth: ");
				Double workedHours = sc.nextDouble();
				System.out.print("Enter the kilograms of garbage this employee collected this mounth: ");
				Double kilos = sc.nextDouble();
				sc.nextLine();
				System.out.print("Enter the type of garbage you collected the most this month (Common/Metal/Food): ");
				String garbageType = sc.nextLine();
				System.out.print("Enter your salary this month: ");
				Double empSalary = sc.nextDouble();
				Employee collector = new Collector(empName, empType, empSalary, workedHours);
				list.add(collector);
				collectorList.add((Collector) collector);
				Boss.addEmployee(collector);

			} else if (empType.equals("MANAGER")) {

				System.out.print("Enter your salary of this month: ");
				Double empSalary = sc.nextDouble();
				System.out.print("Enter your worked hours: ");
				hoursWorked = sc.nextDouble();
				Employee manager = new Manager(empName, empType, empSalary, hoursWorked);
				list.add(manager);
				managerList.add((Manager) manager);
				Boss.addEmployee(manager);

			} else if (empType.equals("DRIVER")) {

				System.out.print("Enter your salary this mounth: ");
				Double empSalary = sc.nextDouble();
				System.out.print("Enter your driven hours this mounth: ");
				hoursWorked = sc.nextDouble();
				Employee driver = new Driver(empName, empType, empSalary, hoursWorked);
				list.add(driver);
				driverList.add((Driver) driver);
				Boss.addEmployee(driver);

				System.out.print("Do you have a medical expenditures this mounth? (Y/N): ");
				option = sc.next().charAt(0);
				if (option == 'Y' || option == 'y') {
					System.out.print("Type the price of your medical expenditure of this mounth: ");
					Double priceMedical = sc.nextDouble();
				} else {
					System.out.println("OK, calculating your salary!");
				}
				sc.nextLine();

			}

		}

		// IMPLENTACÃO DE CREDENCIAIS A SEREM FEITAS

		System.out.print("What are your credentials? (C/B/M/D): ");
		char credentials = sc.next().charAt(0);

		if (credentials == 'C') {
			// Lógica de login a ser implementada com booleans
			EmployeeTypes employeeType = EmployeeTypes.COLLECTOR;
			for (Employee emp : collectorList) {
				Collector collector = (Collector) emp;
				System.out.println("Your name is: " + collector.getEmployeeName());
				System.out.println("Your salary this month: " + collector.getSalary());
				System.out.println("You collected this month: " + collector.getKgCollected());
			}
		} else if (credentials == 'M') {
			EmployeeTypes employeeType = EmployeeTypes.MANAGER;
			for (Employee emp : managerList) {
				Manager manager = (Manager) emp;
				System.out.print("Do you want to see the list of employees added? (Y/N): ");
				char decision = sc.next().charAt(0);
				if (decision == 'Y' || decision == 'y') {
					manager.showListofCollector(collectorList);
				} else if (decision == 'N') {
					manager.showMangerMenu();
					option = sc.next().charAt(0);
				}
			}
		} else if (credentials == 'B') {
			EmployeeTypes employeeType = EmployeeTypes.BOSS;
			for (Employee emp : bossList) {
				Boss boss = (Boss) emp;
				System.out.print("Enter the password to get the privileges: ");
				int pass = sc.nextInt();
				boss.autentication(pass);
				System.out.print("Enter the option: ");
				option = sc.next().charAt(0);

				if (option == '1') {
					System.out.print("Enter the name of the employee you want to search: ");
					String nameEmployee = sc.next();
					String result = boss.findEmployee(nameEmployee);
					System.out.println(result);
					
				} else if (option == '2') {
					System.out.print("Enter the name of the employee you want to decrease salary: ");
					String nameEmployee = sc.next();
					System.out.print("Enter the value you want to decrease: ");
					Double valueOut = sc.nextDouble();	
					Employee emp0 = findByName(nameEmployee);			
				    Employee empEncreasy = emp0.desencreasySalary(emp0, valueOut);
					System.out.println("The salary of the employee you chose has been atualizated!");
					System.out.println("New Salary: " + empEncreasy.getSalary());
					

				}

			}

		} else if (credentials == 'D') {
			EmployeeTypes employeeType = EmployeeTypes.DRIVER;
			for (Employee emp : driverList) {
				Driver driver = (Driver) emp;
				Double newSalary = driver.CalculateDriveHours(hoursWorked);
				System.out.println(newSalary);

			}

		}
	}
	
	
	public static Employee findByName(String name) {	
	Optional<Employee> emp = list.stream().filter(n -> n.getEmployeeName().equals(name)).findAny();
	if(emp.isEmpty()) {
		throw new RuntimeException("Employee not found!");
	} 
	return emp.get();
	

	}
}
