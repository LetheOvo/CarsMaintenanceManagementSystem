package com.liuxubin.Model;

public class Parts {

	private int id;
	private String partsId;
	private String partsNumber;
	private String partsPrice;
	
	
	
	public Parts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parts(String partsId, String partsNumber, String partsPrice) {
		super();
		this.partsId = partsId;
		this.partsNumber = partsNumber;
		this.partsPrice = partsPrice;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPartsId() {
		return partsId;
	}
	public void setPartsId(String partsId) {
		this.partsId = partsId;
	}
	public String getPartsNumber() {
		return partsNumber;
	}
	public void setPartsNumber(String partsNumber) {
		this.partsNumber = partsNumber;
	}
	public String getPartsPrice() {
		return partsPrice;
	}
	public void setPartsPrice(String partsPrice) {
		this.partsPrice = partsPrice;
	}
	
	
}
