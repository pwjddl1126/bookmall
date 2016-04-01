package com.estsoft.bookmall.vo;

public class BookVO {
	
	private Long bookNo;
	private String title;
	private Long categoryNo;
	private Long price;
	
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookVO [bookNo=" + bookNo + ", title=" + title
				+ ", categoryNo=" + categoryNo + ", price=" + price + "]";
	}
	
	

	
	
}
