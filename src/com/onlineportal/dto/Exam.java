package com.onlineportal.dto;
import java.time.LocalDate;
import java.util.Date;
public class Exam {

	private int Exam_ID;
	private String  Exam_Name;
	private String Department;
	private Date Exam_Date ;
	private int Duration;
	private int Total_Question;
	private LocalDate Creation_Date;
	private int Status ;
	private String Exam_Type;
	public Exam(String Exam_Name,String Department,int  Duration,String Exam_Type,int TOtal_Question){
		this.Exam_Name=Exam_Name;
		this.Department=Department;
		this.Duration=Duration;
		this.Exam_Type=Exam_Type;
		this.Total_Question=TOtal_Question;
		this.Creation_Date=setCreation_Date();
		this.Status=1;
	}
	public int getExam_ID() {
		return Exam_ID;
	}
	public String getExam_Name() {
		return Exam_Name;
	}
	public void setExam_Name(String exam_Name) {
		Exam_Name = exam_Name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public Date getExam_Date() {
		return Exam_Date;
	}
	public void setExam_Date(Date exam_Date) {
		Exam_Date = exam_Date;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public int getTotal_Question() {
		return Total_Question;
	}
	public void setTotal_Question(int total_Question) {
		Total_Question = total_Question;
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
	public String getExam_Type() {
		return Exam_Type;
	}
	public void setExam_Type(String exam_Type) {
		Exam_Type = exam_Type;
	}
	
}
