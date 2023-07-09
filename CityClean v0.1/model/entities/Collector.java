package model.entities;

import model.enumeration.EmployeeTypes;

public class Collector extends Employee {

    private String employeeName;
    private Double workedhours;
    private Double salary;
    private Double kgCollected;

    public Collector(String employeeName, String empType, Double salary, Double workedHours) {
        super(employeeName, EmployeeTypes.COLLECTOR, salary, workedHours);
        this.salary = super.getSalary();
        this.employeeName = employeeName;
    }

    public Double getKgCollected() {
        return kgCollected;
    }

    public void setKgCollected(Double kgCollected) {
        this.kgCollected = kgCollected;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getWorkedhours() {
        return workedhours;
    }

    public void setWorkedhours(Double workedhours) {
        this.workedhours = workedhours;
    }

    public Double getSalary() {
        return salary;
    }
    
    }

