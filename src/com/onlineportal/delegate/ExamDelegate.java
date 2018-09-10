package com.onlineportal.delegate;

import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineportal.model.Examinfo;
import com.onlineportal.service.ExamService;

public class ExamDelegate {

	@Autowired
	private ExamService examservice;

	public ExamService getExamservice() {
		return this.examservice;
	}

	public void setExamservice(ExamService examservice) {
		this.examservice = examservice;
	}
	
	public String CreateExam(Examinfo exam ,String date) throws SQLException, ParseException{
	      return examservice.CreateExam(exam,date);
	}
	
	
}
