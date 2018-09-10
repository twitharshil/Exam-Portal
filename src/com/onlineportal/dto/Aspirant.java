package com.onlineportal.dto;
import java.util.*;
import com.sun.jmx.snmp.Timestamp;

public class Aspirant {

	private static int nid=1000;
	private static String value="ABCEDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*";
	private int User_ID;
	private String UserName;
	private String Stream;
	private String Aspirant_Name;
	private Timestamp Creation_Date;
	private int Status;
	private String Password;
	private int Verified_Status;

	Aspirant(String name,String Username,String Stream){
		this.Aspirant_Name=name;
		this.UserName=Username;
		this.Stream=Stream;
		this.User_ID=nid++;
		this.Creation_Date=setCreation_Date();
		this.Status=1;
		this.Password=setPassword();
		this.Verified_Status=0;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID() {
		User_ID = nid++;
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
	public Timestamp getCreation_Date() {
		return Creation_Date;
	}
	public Timestamp setCreation_Date() {
		Date date= new Date();
		 long time = date.getTime();
		 Timestamp ts = new Timestamp(time);
		 return Creation_Date = ts;
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
	public String getPassword() {
		return Password;
	}
	private String setPassword() {
		Random rand = new Random();
		char[] pass=new char[10];
		for(int i=0;i<10;i++){
			pass[i]= (char) rand.nextInt(value.length());
		}
		String b=new String(pass);
		Password=b;
		return Password;
	}
}
