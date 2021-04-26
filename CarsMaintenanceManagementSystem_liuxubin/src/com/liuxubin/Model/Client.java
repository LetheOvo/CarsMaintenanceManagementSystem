package com.liuxubin.Model;

public class Client {

	private String id;
	private String ClientName;
	private String Gender;
	private String IDNumber;
	private String PhoneNumber;
	private String HomeAddress;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getHomeAddress() {
		return HomeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}
	public Client(String clientName, String gender, String iDNumber, String phoneNumber, String homeAddress) {
		super();
		ClientName = clientName;
		Gender = gender;
		IDNumber = iDNumber;
		PhoneNumber = phoneNumber;
		HomeAddress = homeAddress;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
	