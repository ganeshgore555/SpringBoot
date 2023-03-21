package com.model;

public class BulkOrder extends Order {
    private Integer quantity;
    private Integer discount;
    
    
    public BulkOrder(Integer orderId, Integer customerId, Float orderAmount, String timestamp, Integer quantity,
			Integer discount) {
		super(orderId, customerId, orderAmount, timestamp);
		this.quantity = quantity;
		this.discount = discount;
	}
	
    public BulkOrder() {
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
    
    
}
