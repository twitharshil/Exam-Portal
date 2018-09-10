package com.onlineportal.model;

public class Examinfo {

	private String Examname;
	private String Department;
	private int Duration;
	private String Examtype;
	private int Totalquestion;
	public String getExamname() {
		return Examname;
	}
	public void setExamname(String examname) {
		this.Examname = examname;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		this.Department = department;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		this.Duration = duration;
	}
	public String getExamtype() {
		return Examtype;
	}
	public void setExamtype(String examtype) {
		this.Examtype = examtype;
	}
	public int getTotalquestion() {
		return Totalquestion;
	}
	public void setTotalquestion(int totalquestion) {
		this.Totalquestion = totalquestion;
	}
	
}
