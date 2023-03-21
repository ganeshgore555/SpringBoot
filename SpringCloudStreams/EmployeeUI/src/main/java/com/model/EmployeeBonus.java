package com.model;

public class EmployeeBonus {

    private String employeeId;
    private String deptId;
    private Integer bonus;
    
    public EmployeeBonus() {
    }

	public EmployeeBonus(String employeeId, String deptId, Integer bonus) {
		super();
		this.employeeId = employeeId;
		this.deptId = deptId;
		this.bonus = bonus;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

    
}
