package com.liuxubin.Model;

public class Records {
	private int id;
	private String plateNumber;
	private String partsId;
	private String useNumber;
	private String repairNumber;
	private String repairTime;
	
	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Records(String plateNumber, String partsId, String useNumber, String repairNumber, String repairTime) {
		super();
		this.plateNumber = plateNumber;
		this.partsId = partsId;
		this.useNumber = useNumber;
		this.repairNumber = repairNumber;
		this.repairTime = repairTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getPartsId() {
		return partsId;
	}
	public void setPartsId(String partsId) {
		this.partsId = partsId;
	}
	public String getUseNumber() {
		return useNumber;
	}
	public void setUseNumber(String useNumber) {
		this.useNumber = useNumber;
	}
	public String getRepairNumber() {
		return repairNumber;
	}
	public void setRepairNumber(String repairNumber) {
		this.repairNumber = repairNumber;
	}
	public String getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}
	
	
}
