package com.model;

public class Customer {

    private String customerId;
    private String customerFullName;
    private String customerPhone;
    private Float currentBalance;

    public Customer() {
    }

	public Customer(String customerId, String customerFullName, String customerPhone, Float currentBalance) {
		super();
		this.customerId = customerId;
		this.customerFullName = customerFullName;
		this.customerPhone = customerPhone;
		this.currentBalance = currentBalance;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFullName() {
		return customerFullName;
	}

	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Float getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Float currentBalance) {
		this.currentBalance = currentBalance;
	}

}
