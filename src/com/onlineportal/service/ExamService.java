package com.onlineportal.service;
import java.sql.SQLException;
import java.text.ParseException;

import com.onlineportal.model.Examinfo;

public interface ExamService {
       
	    public String CreateExam(Examinfo exam,String date) throws SQLException, ParseException;
}
