package com.estsoft.bookmall.vo;

public class CartVO {

	private Long memberNo;
	private Long bookNo;
	private Long quantity;
	
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartVO [memberNo=" + memberNo + ", bookNo=" + bookNo
				+ ", quantity=" + quantity + "]";
	}
	
	
	
}
