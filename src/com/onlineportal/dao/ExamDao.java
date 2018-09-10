package com.onlineportal.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.onlineportal.model.Examinfo;

public interface ExamDao {
	public String CreateExam(Examinfo exam, Date sqlStartDate) throws SQLException;
}
