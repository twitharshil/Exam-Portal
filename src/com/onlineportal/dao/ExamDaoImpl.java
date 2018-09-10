package com.onlineportal.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.onlineportal.dto.Exam;
import com.onlineportal.model.Examinfo;
public class ExamDaoImpl implements ExamDao {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public ExamDaoImpl(JdbcTemplate jdbctemplalte){
		this.jdbctemplate=jdbctemplalte;
	}
	
	public String CreateExam(Examinfo exam,Date sqlStartDate){
		
		String query="Select * from exam where Exam_Name = '"+ exam.getExamname() + "' and Department = '" + exam.getDepartment() + "' ";
		List<Examinfo> exams = jdbctemplate.query(query, new Presentexam());
		if(exams.size()!=0){
			return "Exam Already Exist";
		}
		else
		{
		    Exam examdata = new Exam(exam.getExamname(),exam.getDepartment(),exam.getDuration(),exam.getExamtype(),exam.getTotalquestion());
	        String query1 = "INSERT INTO exam (Exam_Name,Exam_Date,Duration,Total_Question,Creation_Date,Status,Exam_Type,Department) VALUES ('"+ examdata.getExam_Name() +"','" + sqlStartDate + "','" + examdata.getDuration() + "','" + examdata.getTotal_Question() + "','" + examdata.getCreation_Date() + "','" + examdata.getStatus() + "','" + examdata.getExam_Type() + "','" + examdata.getDepartment() + "')"; 	
	 	  	try{
	    	     int rs = jdbctemplate.update(query1);
	    	     if(rs==1)
	    	     return examdata.getExam_Name();
	    	     else
	    	    	 return "cannot";
	       	}
	       	catch (DataAccessException r){
	       		return "DataAccessException Occured ";
	       	} 
		}
      }
	private class Presentexam implements RowMapper<Examinfo> {
        public Examinfo mapRow(ResultSet rs, int arg1) throws SQLException {
			return new Examinfo();
		}
	}
}
