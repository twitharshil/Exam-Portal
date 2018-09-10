package com.onlineportal.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.onlineportal.dto.AspirantData;
import com.onlineportal.model.Aspirant;
import com.onlineportal.model.Settinginfo;


public class UserDaoImpl implements UserDao {
	
	
	private JdbcTemplate jdbcTemplate;
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean isValidUser(String username, String password) throws SQLException {
		String query = "Select * from aspirant where username ='" + username + "' and password = '" + password + "'";
		List<Aspirant> aspirants = jdbcTemplate.query(query, new AspirantMapper());
		return aspirants.size() > 0 ? true : false;
	}

	private class AspirantMapper implements RowMapper<Aspirant> {

		public Aspirant mapRow(ResultSet rs, int arg1) throws SQLException {
			return new Aspirant();
		}
	}

	public String Create(Aspirant aspirant,String password) throws SQLException{
 
		 String query = "Select * from aspirant where Aspirant_Name= '" + aspirant.getName() + "' and  UserName ='" + aspirant.getUsername() + "' and Stream = '" + aspirant.getDepartment() + "' ";
 	     List<Aspirant> aspirants = jdbcTemplate.query(query, new AspirantMapper());
	     if(aspirants.size() >0){
 	    	 return "Already Exist";
 	     }
 	     else
 	     {
 	        AspirantData aspirantdata = new AspirantData(aspirant.getName(),aspirant.getUsername(),aspirant.getDepartment());
 	    	String query1 = "INSERT INTO aspirant (Stream,UserName,Password,Status,Creation_Date,Verified_Status,Aspirant_Name) VALUES('"+aspirantdata.getStream() +"','"+aspirantdata.getUserName()+"','"+ password + "','"+aspirantdata.getStatus()+"','"+aspirantdata.getCreation_Date()+"','"+ aspirantdata.getVerified_Status()+"','"+aspirantdata.getAspirant_Name()+"')"; 	
 	       	try{
 	    	     int rs = jdbcTemplate.update(query1);
 	    	     if(rs==1)
 	    	     return aspirantdata.getAspirant_Name();
 	    	     else
 	    	    	 return "cannot";
 	       	}
 	       	catch (DataAccessException e){
 	       		return "DataAccessException Occured ";
 	       	} 
         }
	}

public String Update(Aspirant aspirant,String password) throws SQLException {
	
	     String query = "Select * from aspirant where Aspirant_Name= '" + aspirant.getName() + "' and  UserName ='" + aspirant.getUsername() + "' and Stream = '" + aspirant.getDepartment() + "' ";
	     List<Aspirant> aspirants = jdbcTemplate.query(query, new AspirantMapper());
	     if(aspirants.size()!=1){
	    	 return "Already Exist";
	     }
	     else
	     {
	    	String query1 =" UPDATE aspirant SET Password= ? where Aspirant_Name= ? and UserName = ? and Stream = ? ";

	        try{
	         	  int rs = jdbcTemplate.update(query1,password,aspirant.getName(),aspirant.getUsername(),aspirant.getDepartment());
	    	     if(rs==1)
	    	     return aspirant.getName();
	    	     else
	    	    	 return "cannot";
	       	}
	       	catch (DataAccessException e){
	       		return "DataAccessException Occured ";
	       	} 
     }
	    
   }

public String UpdatePassword(Settinginfo setting) {
	
     String query = "Select Password from aspirant where IsAdmin='Y'";
     String streetName = (String) jdbcTemplate.queryForObject( query, new Object[]{}, String.class);
         if(streetName.equals(setting.getCurrentPassword())){
              try{
            	 String query1 =" UPDATE aspirant SET Password= ? where IsAdmin= ? "; 
	    	     int rs = jdbcTemplate.update(query1,setting.getNewPassword(),"Y");
	    	     if(rs==1)
	    	     return "Updated";
	       	}
	       	catch (DataAccessException e){
	       		return "DataAccessException Occured ";
	       	} 
        	 
         }
	    	 return "cannot";
       }

public String getname(String username) {
	
	String query = "Select Aspirant_Name from aspirant where UserName='"+username+"'";
    String Name = (String) jdbcTemplate.queryForObject( query, new Object[]{}, String.class);
	return Name;
   }

//public String getpasswordfromdatabase(String to) {
//	String query = "Select Password from aspirant where UserName='"+to+"'";
//	String password = (String) jdbcTemplate.queryForObject( query, new Object[]{}, String.class);
//	return password;
//}
}
