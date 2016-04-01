package com.estsoft.bookmall.vo;

public class OrderedBookVO {
	private Long ordersNo;
	private Long booksNo;
	private Long quantity;
	
	public Long getOrdersNo() {
		return ordersNo;
	}
	public void setOrdersNo(Long ordersNo) {
		this.ordersNo = ordersNo;
	}
	public Long getBooksNo() {
		return booksNo;
	}
	public void setBooksNo(Long booksNo) {
		this.booksNo = booksNo;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderedBookVO [ordersNo=" + ordersNo + ", booksNo=" + booksNo
				+ ", quantity=" + quantity + "]";
	}

	
}
