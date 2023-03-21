package com.model;

public class Employee {

    private String employeeId;
    private String employeeFullName;
    private String employeePhone;
    private Integer employeeSalary;

    public Employee() {
    }

	public Employee(String employeeId, String employeeFullName, String employeePhone, Integer employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeFullName = employeeFullName;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFullName() {
		return employeeFullName;
	}

	public void setEmployeeFullName(String employeeFullName) {
		this.employeeFullName = employeeFullName;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public Integer getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Integer employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

}
