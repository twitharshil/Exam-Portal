package com.onlineportal.dto;
import java.sql.Timestamp;
import java.util.Date;

public class Answer {

	private int Question_ID;
	private int Correct_ResponseA;
	private int Correct_ResponseB;
	private int Correct_ResponseC;
	private int Correct_ResponseD;
	private int Status;
	private Timestamp Creation_Date;
	
	Answer(int Question_ID,int Correct_ResponseA,int Correct_ResponseB,int Correct_ResponseC,int Correct_ResponseD){
	        this.Question_ID=Question_ID;
	        this.Correct_ResponseA=Correct_ResponseA;
	        this.Correct_ResponseB=Correct_ResponseB;
	        this.Correct_ResponseC=Correct_ResponseC;
	        this.Correct_ResponseD=Correct_ResponseD;
	        this.Status=1;
	        this.Creation_Date= setCreation_Date();
		    
	}
	public int getQuestion_ID() {
		return Question_ID;
	}
	public void setQuestion_ID(int question_ID) {
		Question_ID = question_ID;
	}
	public int getCorrect_ResponseA() {
		return Correct_ResponseA;
	}
	public void setCorrect_ResponseA(int correct_ResponseA) {
		Correct_ResponseA = correct_ResponseA;
	}
	public int getCorrect_ResponseC() {
		return Correct_ResponseC;
	}
	public void setCorrect_ResponseC(int correct_ResponseC) {
		Correct_ResponseC = correct_ResponseC;
	}
	public int getCorrect_ResponseD() {
		return Correct_ResponseD;
	}
	public void setCorrect_ResponseD(int correct_ResponseD) {
		Correct_ResponseD = correct_ResponseD;
	}
	public int getCorrect_ResponseB() {
		return Correct_ResponseB;
	}
	public void setCorrect_ResponseB(int correct_ResponseB) {
		Correct_ResponseB = correct_ResponseB;
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
