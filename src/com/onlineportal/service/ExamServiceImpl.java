package com.onlineportal.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineportal.dao.ExamDao;
import com.onlineportal.model.Examinfo;

public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao examdao;
	
    public ExamDao getExamdao() {
		return this.examdao;
	}
    public void setExamdao(ExamDao examdao) {
		this.examdao = examdao;
	}
	
	public String CreateExam(Examinfo exam ,String date) throws SQLException, ParseException
	{
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yyyy");
		java.util.Date date1 = sdf1.parse(date);
		java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
		return examdao.CreateExam(exam, sqlStartDate);
	}


}
