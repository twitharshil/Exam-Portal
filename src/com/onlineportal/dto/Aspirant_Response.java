package com.onlineportal.dto;

import java.sql.Timestamp;
import java.util.Date;

public class Aspirant_Response {
	private int Question_ID;
	private int User_ID;
	private int Exam_ID;
	private int Response_Given;
	private int ResponseA;
	private int ResponseB;
	private int ResponseC;
	private int ResponseD;
	private int Status;
	private Timestamp Creation_Date;
	public int getQuestion_ID() {
		return Question_ID;
	}
	public void setQuestion_ID(int question_ID) {
		Question_ID = question_ID;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}
	public int getExam_ID() {
		return Exam_ID;
	}
	public void setExam_ID(int exam_ID) {
		Exam_ID = exam_ID;
	}
	public int getResponse_Given() {
		return Response_Given;
	}
	public void setResponse_Given(int response_Given) {
		Response_Given = response_Given;
	}
	public int getResponseA() {
		return ResponseA;
	}
	public void setResponseA(int responseA) {
		ResponseA = responseA;
	}
	public int getResponseB() {
		return ResponseB;
	}
	public void setResponseB(int responseB) {
		ResponseB = responseB;
	}
	public int getResponseC() {
		return ResponseC;
	}
	public void setResponseC(int responseC) {
		ResponseC = responseC;
	}
	public int getResponseD() {
		return ResponseD;
	}
	public void setResponseD(int responseD) {
		ResponseD = responseD;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
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
	
}
