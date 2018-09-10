package com.onlineportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.onlineportal.dto.Appeareddetails;
import com.onlineportal.dto.Question;
import com.onlineportal.model.Aspirant_Response;
import com.onlineportal.model.UploadQA;

public class UploadqaDaoImpl implements UploadqaDao {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public UploadqaDaoImpl(JdbcTemplate jdbctemplalte){
		this.jdbctemplate=jdbctemplalte;
	}

	public String UploadQuestion(UploadQA uploadqa) {
		System.out.println(uploadqa.getDepartment());
		String query1 = "INSERT INTO question (Question,Option_A,Option_B,Option_C,Option_D,Status,Creation_Date,Exam_ID) VALUES('"+uploadqa.getQuestion() +"','"+uploadqa.getOptionA()+"','"+ uploadqa.getOptionB()+ "','"+uploadqa.getOptionC()+"','"+uploadqa.getOptionD()+"','"+ 1 +"','"+ uploadqa.setCreation_Date() +"',(Select Exam_ID from exam where Exam_Name= '"+uploadqa.getExam() +"'))"; 	
	    try{
	    	     int rs = jdbctemplate.update(query1);
	    	     if(rs==1)
	    	     {
	    	    	 int  a=1,b=1,c=1,d=1;
	    	    	 if(uploadqa.getAnswerA()==null){
	    	    		 a=0;
	    	    	 }
	    	    	 if(uploadqa.getAnswerB()==null){
	    	    		 b=0;
	    	    	 }
	    	    	 if(uploadqa.getAnswerC()==null){
	    	    		 c=0;
	    	    	 }
	    	    	 if(uploadqa.getAnswerD()==null){
	    	    		 d=0;
	    	    	 }
	    	 	    String query2="INSERT INTO answer (Question_ID, Correct_Response_A, Correct_Response_B, Correct_Response_C, Correct_Response_D, Status, Creation_Date) VALUES((Select MAX(Question_ID) from question),"+a+","+ b+ ","+c+","+d+","+ 1 +",'"+ uploadqa.getCreation_Date() +"')";   
                    int rs1 = jdbctemplate.update(query2);
	    	    	 if(rs1==1){
	    	    		 return "uploaded";
	    	          }
	    	     }
	  	       	}
	       	catch (DataAccessException e){
	       		return "DataAccessException Occured ";
	       	}
		return "cannot";
		}

	public List<String> getexam(String str) {
	    String query="Select Exam_Name from exam where Department ='"+str+"'";
		List<String> getexams = jdbctemplate.query(query, new ExamMapper());
		return getexams;
	}
	
	private class ExamMapper implements RowMapper<String> {
           public String mapRow(ResultSet rs, int arg1) throws SQLException {
			return rs.getString(1);
		}
	}
	
	public String getStreamexam(String string) {
		String query="Select Stream from aspirant where UserName ='"+string+"'";
		String streetName = (String) jdbctemplate.queryForObject( query, new Object[]{}, String.class);
		return streetName;
	}
	
	private class QuestionMapper implements RowMapper<Question> {
        public Question mapRow(ResultSet rs, int arg1) throws SQLException {
			Question up = new Question();
			up.setQuestionId(rs.getInt(1));
			up.setQuestion(rs.getString(2));
			up.setOptionA(rs.getString(3));
			up.setOptionB(rs.getString(4));
			up.setOptionC(rs.getString(5));
			up.setOptionD(rs.getString(6));
			return up;
		}
	}
	
	public List<Question> getallquestions(String value) {
		
		String query1="SELECT Exam_ID FROM exam where Exam_Name='"+value+"'";
		int examid = (int)jdbctemplate.queryForObject( query1, new Object[]{}, Integer.class);
		
		String query="Select Total_Question from exam where Exam_ID ="+examid+"";
		int noofquestion = (int)jdbctemplate.queryForObject( query, new Object[]{}, Integer.class);
		
		String que = "Select Count(Question_ID) from question where Exam_ID = "+examid+"";
		int totalquestionentire = (int)jdbctemplate.queryForObject( que, new Object[]{}, Integer.class);
		
		String query2="Select * from question where Exam_ID="+examid+"";
		List<Question> getexams = jdbctemplate.query(query2, new QuestionMapper());
		
		List<Question> rs1 =new ArrayList<Question>();
		Random rand = new Random();
		for(int i=0;i<Math.min(noofquestion,totalquestionentire);i++){ 
		         Question q = new Question();
			     q = getexams.get(rand.nextInt(Math.min(noofquestion,totalquestionentire)));
			     rs1.add(q);
			 }
		return rs1;
	}
	
public String aspirantresponse(ArrayList<Question> qt,String value,String examname) {
		
		String query1="SELECT User_ID FROM aspirant where UserName='"+value+"'";
		int userid = (int)jdbctemplate.queryForObject( query1, new Object[]{}, Integer.class);
		String query2="SELECT Exam_ID FROM exam where Exam_Name='"+examname+"'";
		int examid = (int)jdbctemplate.queryForObject( query2, new Object[]{}, Integer.class);
        int count=0;
		for(int i=0;i<qt.size();i++){
 	        
			int a=0,b=0,c=0,d=0;
			if(qt.get(i).getOptionA().equals(true)){a=1;};
			if(qt.get(i).getOptionA().equals(true)){b=1;};
			if(qt.get(i).getOptionA().equals(true)){c=1;};
			if(qt.get(i).getOptionA().equals(true)){d=1;};
			String query4="INSERT INTO aspirant_response (User_ID, Exam_ID, Question_ID, Response_Given, Response_A, Response_B, Response_C, Response_D, Status,Creation_Date) VALUES("+userid+","+examid+ ","+qt.get(i).getQuestionId()+","+ 1 +","+a +","+ b +","+ c +","+ d +","+ 1 +",'"+ qt.get(i).setCreation_Date()+"')";   
			int rs1 = jdbctemplate.update(query4);
			if(rs1==1){
				count++;
			}
		}
		if(count==qt.size()){
			return "inserted";
		}
		return null;
	}
/*correct answer fetch in aspirant from answer table */

private class ResponseMapper implements RowMapper<Aspirant_Response> {
    public Aspirant_Response mapRow(ResultSet rs, int arg1) throws SQLException {
    	Aspirant_Response up = new Aspirant_Response();
		
    	if(rs.getInt(1)==1){up.setResponseA("true");}
		else{up.setResponseA("false");}
		
		if(rs.getInt(2)==1){up.setResponseB("true");}
		else{up.setResponseB("false");}
		
		if(rs.getInt(3)==1){up.setResponseC("true");}
		else{up.setResponseC("false");};
		
		if(rs.getInt(4)==1){up.setResponseD("true");}
		else
		{up.setResponseD("false");}
		
		return up;
	}
}

public int calculatescore(ArrayList<Question> qt, String value, String examname) {
		
	    int count=0;
	    int score=0;
	    String query1="SELECT User_ID FROM aspirant where UserName='"+value+"'";
		int userid = (int)jdbctemplate.queryForObject( query1, new Object[]{}, Integer.class);
		
		String query2="SELECT Exam_ID FROM exam where Exam_Name='"+examname+"'";
		int examid = (int)jdbctemplate.queryForObject( query2, new Object[]{}, Integer.class);
		
		for(int i=0;i<qt.size();i++){
		  String query3="SELECT Correct_Response_A, Correct_Response_B, Correct_Response_C, Correct_Response_D  from answer where Question_ID="+qt.get(i).getQuestionId() +"";
		  Aspirant_Response respo= jdbctemplate.queryForObject(query3, new ResponseMapper());
		  int pass=0;
		  if(respo.getResponseA().equals(qt.get(i).getOptionA())){
			  if(respo.getResponseB().equals(qt.get(i).getOptionB())){
				  if(respo.getResponseC().equals(qt.get(i).getOptionC())){
					  if(respo.getResponseD().equals(qt.get(i).getOptionD())){
						  pass=1;
					  }
				  }
			  }
		  }
		 if(pass==1){
			String query4="INSERT INTO aspirant_score (User_ID, Exam_ID, Question_ID, Score) VALUES("+userid+","+examid+ ","+qt.get(i).getQuestionId()+","+1.0+")";   
			int rs1 = jdbctemplate.update(query4);
			if(rs1==1){
				score++;
				count++;
			}
		  }
		 else
		 {
			 String query4="INSERT INTO aspirant_score (User_ID, Exam_ID, Question_ID, Score) VALUES("+userid+","+examid+ ","+qt.get(i).getQuestionId()+","+0+")";   
				int rs1 = jdbctemplate.update(query4);
				if(rs1==1){
					count++;
				}
	      }
		 }
		if(count==qt.size()){
			return score;
		}
		else{
			return 100;
		}
	}
private class allExamMapper implements RowMapper<Integer> {
    public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
		return rs.getInt(1);
	}
}
public List<Appeareddetails> Displaypopup(String value) {
	
	    String query="Select User_ID from aspirant where UserName ='"+value+"'";
		int userid = (int)jdbctemplate.queryForObject( query, new Object[]{}, Integer.class);
		
		String query1="SELECT DISTINCT Exam_ID from aspirant_score where User_ID ="+userid+"";
		List<Integer> exams= jdbctemplate.query(query1, new allExamMapper());
		
		List<Appeareddetails> data =new ArrayList<Appeareddetails>();
		for(int i=0;i<exams.size();i++){
			
			Appeareddetails up = new Appeareddetails();
            String query4 = "Select Exam_Name from exam where Exam_ID ="+exams.get(i)+" ";
    		String examname  = (String) jdbctemplate.queryForObject( query4, new Object[]{}, String.class);
    		
    		String query5 = "Select Exam_Date from exam where Exam_ID ="+exams.get(i)+" ";
    		String examdate = (String) jdbctemplate.queryForObject( query5, new Object[]{}, String.class);

		    up.setName(value);
		    up.setExamname(examname);
		    up.setAppearedon(examdate);
		    
			String query2="SELECT SUM(Score) FROM aspirant_score WHERE User_ID ="+userid+" and Exam_ID="+exams.get(i)+"";
			int score = (int)jdbctemplate.queryForObject( query2, new Object[]{}, Integer.class);
            up.setScore(score);
            data.add(up);
		}
		return data;
	}

public int gettimer(String examname) {
	String query4 = "Select Duration from exam where Exam_Name ='"+examname+"' ";
	int time = (int)jdbctemplate.queryForObject( query4, new Object[]{}, Integer.class);
	return time;
   }


public String gettype(String ename) {
	
	String query4 = "Select Exam_Type from exam where Exam_Name ='"+ename+"' ";
	String examtype = (String) jdbctemplate.queryForObject( query4, new Object[]{}, String.class);
	return examtype;
}
}
