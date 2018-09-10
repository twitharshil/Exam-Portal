package com.onlineportal.model;

import java.time.LocalDate;

public class UploadQA {

	private String depart;
	private String Exam;
	private String Question;
	private String optionA;
	private String AnswerA;
	private String optionB;
	private String AnswerB;
	private String optionC;
	private String AnswerC;
	private String optionD;
	private String AnswerD;
	private LocalDate Creation_Date;
	private int Status ;
	public String getDepartment() {
		return depart;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getAnswerA() {
		return AnswerA;
	}
	public void setAnswerA(String answerA) {
		AnswerA = answerA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getAnswerB() {
		return AnswerB;
	}
	public void setAnswerB(String answerB) {
		AnswerB = answerB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getAnswerC() {
		return AnswerC;
	}
	public void setAnswerC(String answerC) {
		AnswerC = answerC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswerD() {
		return AnswerD;
	}
	public void setAnswerD(String answerD) {
		AnswerD = answerD;
	}
	public void setDepartment(String department) {
		this.depart = department;
	}
	public String getExam() {
		return Exam;
	}
	public void setExam(String exam) {
		this.Exam = exam;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		this.Question = question;
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
		this.Status = status;
	}
	
	
}
