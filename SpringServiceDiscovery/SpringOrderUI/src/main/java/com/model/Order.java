package com.model;

public class Order {

    private Integer orderId;
    private Integer customerId;
    private Float orderAmount;
    private String timestamp;

    public Order() {}

	public Order(Integer orderId, Integer customerId, Float orderAmount, String timestamp) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderAmount = orderAmount;
		this.timestamp = timestamp;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Float orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
   
}
