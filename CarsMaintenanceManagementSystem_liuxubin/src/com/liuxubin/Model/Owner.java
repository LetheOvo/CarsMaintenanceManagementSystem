package com.liuxubin.Model;

public class Owner {

	private int id;
	private String ownerName;
	private String VehicleModel;
	private String VehicleRegistration;
	private String ContactNumber;
	
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Owner(String ownerName, String vehicleModel, String vehicleRegistration, String contactNumber) {
		super();
		this.ownerName = ownerName;
		VehicleModel = vehicleModel;
		VehicleRegistration = vehicleRegistration;
		ContactNumber = contactNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getVehicleModel() {
		return VehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		VehicleModel = vehicleModel;
	}
	public String getVehicleRegistration() {
		return VehicleRegistration;
	}
	public void setVehicleRegistration(String vehicleRegistration) {
		VehicleRegistration = vehicleRegistration;
	}
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	
	
}
