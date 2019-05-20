package com.dmfa.picoplaca.beans;

/**
 * @author dfuentes
 *
 * Bean that contains input parameters
 */
public class ParametersBean {
	
	public String licensePlateNumber;
	public String date;
	public String time;
	
	
	
	public ParametersBean() {
		super();
	}

	public ParametersBean(String licensePlateNumber, String date, String time) {
		super();
		this.licensePlateNumber = licensePlateNumber;
		this.date = date;
		this.time = time;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}
	
	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	

}
