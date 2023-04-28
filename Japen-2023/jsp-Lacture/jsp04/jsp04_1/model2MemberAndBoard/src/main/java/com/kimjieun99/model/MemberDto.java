package com.kimjieun99.model;

// table 맞추기 => member02에 있는 컬럼명을 속성으로 가지는 object;
public class MemberDto {
private int no;
private String userId;
private String userPW;
private String userName;
private String userEmail;
private String userHp;
private int zipCode;
private String address;
private String regDate;
public MemberDto() {
	super();
	// TODO Auto-generated constructor stub
}
public MemberDto(int no, String userId, String userPW, String userName, String userEmail, String userHp, int zipCode,
		String address, String regDate) {
	super();
	this.no = no;
	this.userId = userId;
	this.userPW = userPW;
	this.userName = userName;
	this.userEmail = userEmail;
	this.userHp = userHp;
	this.zipCode = zipCode;
	this.address = address;
	this.regDate = regDate;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserPW() {
	return userPW;
}
public void setUserPW(String userPW) {
	this.userPW = userPW;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserHp() {
	return userHp;
}
public void setUserHp(String userHp) {
	this.userHp = userHp;
}
public int getZipCode() {
	return zipCode;
}
public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getRegDate() {
	return regDate;
}
public void setRegDate(String regDate) {
	this.regDate = regDate;
}
@Override
public String toString() {
	return "MemberDto [no=" + no + ", userId=" + userId + ", userPW=" + userPW + ", userName=" + userName
			+ ", userEmail=" + userEmail + ", userHp=" + userHp + ", zipCode=" + zipCode + ", address=" + address
			+ ", regDate=" + regDate + "]";
}

}
