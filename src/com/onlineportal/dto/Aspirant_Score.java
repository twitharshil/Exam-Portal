package com.onlineportal.dto;

public class Aspirant_Score {

	 private int User_ID;
	 private int Exam_ID;
	 private int Question_ID;
	 private double Score;
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
	public int getQuestion_ID() {
		return Question_ID;
	}
	public void setQuestion_ID(int question_ID) {
		Question_ID = question_ID;
	}
	public double getScore() {
		return Score;
	}
	public void setScore(double score) {
		Score = score;
	}
	 
}
