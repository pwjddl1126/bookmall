package com.estsoft.bookmall.vo;

public class MemberVO {

	private Long memberNo;
	private String email;
	private Long password;
	private String name;
	
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memeberNo) {
		this.memberNo = memeberNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memeberNo=" + memberNo + ", email=" + email
				+ ", password=" + password + ", name=" + name + "]";
	}
	
	
}
