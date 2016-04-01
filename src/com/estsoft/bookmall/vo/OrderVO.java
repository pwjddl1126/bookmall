package com.estsoft.bookmall.vo;

public class OrderVO {

	private Long orderNo;
	private Long memberNo;
	private Long orderedPrice;
	private String address;
	//주문자 정보
	private String memberName;
	private String memberEmail;


	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getOrderedPrice() {
		return orderedPrice;
	}
	public void setOrderedPrice(Long orderedPrice) {
		this.orderedPrice = orderedPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	@Override
	public String toString() {
		return "OrderVO [orderNo=" + orderNo + ", memberNo=" + memberNo
				+ ", orderedPrice=" + orderedPrice + ", address=" + address
				+ ", memberName=" + memberName + ", memberEmail=" + memberEmail
				+ "]";
	}
	


	
	
	
}
