package com.onlineportal.dto;
import java.time.LocalDate;

public class AspirantData {

	
	private int User_ID;
	private String UserName;
	private String Stream;	
	private String Aspirant_Name;
	private LocalDate Creation_Date;
	private int Status;
	private String Password;
	private int Verified_Status;
	private String IsAdmin;
	public AspirantData(){
	}
    public AspirantData(String name,String Username,String Stream){
		this.Aspirant_Name=name;
		this.UserName=Username;
		this.Stream=Stream;
		this.Creation_Date=setCreation_Date();
		this.Status=1;
		this.Verified_Status=0;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getStream() {
		return Stream;
	}
	public void setStream(String stream) {
		Stream = stream;
	}
	public String getAspirant_Name() {
		return Aspirant_Name;
	}
	public void setAspirant_Name(String aspirant_Name) {
		Aspirant_Name = aspirant_Name;
	}
	public LocalDate getCreation_Date() {
		return Creation_Date;
	}
	public LocalDate setCreation_Date() {
		 LocalDate date = java.time.LocalDate.now();
		 return Creation_Date = date;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getVerified_Status() {
		return Verified_Status;
	}
	public void setVerified_Status(int verified_Status) {
		Verified_Status = verified_Status;
	}
	public String getIsAdmin() {
		return IsAdmin;
	}
	
	
}
