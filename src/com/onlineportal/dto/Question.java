package com.onlineportal.dto;

import java.time.LocalDate;

public class Question {

         private int questionId;
         private String question;
         private String optionA;
         private String optionB;
         private String optionC;
         private String optionD;
         private LocalDate Creation_Date;
     	private int Status ;
     	
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
		
	
		public int getQuestionId() {
			return questionId;
		}
		public void setQuestionId(int questionId) {
			this.questionId = questionId;
		}
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public String getOptionA() {
			return optionA;
		}
		public void setOptionA(String optionA) {
			this.optionA = optionA;
		}
		public String getOptionB() {
			return optionB;
		}
		public void setOptionB(String optionB) {
			this.optionB = optionB;
		}
		public String getOptionC() {
			return optionC;
		}
		public void setOptionC(String optionC) {
			this.optionC = optionC;
		}
		public String getOptionD() {
			return optionD;
		}
		public void setOptionD(String optionD) {
			this.optionD = optionD;
		}
    
     	 
}
