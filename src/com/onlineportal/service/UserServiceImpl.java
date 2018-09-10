package com.onlineportal.service;
import java.sql.SQLException;
import java.util.Random;

import com.onlineportal.dao.UserDao;
import com.onlineportal.model.Aspirant;
import com.onlineportal.model.Settinginfo;

public class UserServiceImpl implements UserService
{
	
	private static String value="ABCEDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	
	private UserDao userDao;
    public UserDao getUserDao()
	{
		return this.userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	public boolean isValidUser(String username, String password) throws SQLException
	{
		return userDao.isValidUser(username, password);
	}
    public String Create(Aspirant aspirant) throws SQLException
	{
		String password = getPassword();
		return userDao.Create(aspirant,password);
	}

	public String Update(Aspirant aspirant) throws SQLException
	{
		String password = getPassword();
		return userDao.Update(aspirant, password);
	}
	
	public String getPassword() {
		Random rand = new Random();
		StringBuilder pass= new StringBuilder();
		for(int i=0;i<10;i++){
			pass.append(value.charAt(rand.nextInt(value.length())));
		}
		return pass.toString();	
	}

	public String UpdatePassword(Settinginfo setting) {
		
		return userDao.UpdatePassword(setting);
	}

	public String getname(String username) {
		return userDao.getname(username);
		
	}
    
//	public int send(String to,String from) 
//	{
//		 String host = "465"; 
//	     Properties properties = System.getProperties();  
//	     properties.setProperty("smtp.gmail.com" ,host)  ;
//	     Session session1 = Session.getDefaultInstance(properties);
//	 
//	     try{  
//	    	
//	    	 String password=userDao.getpasswordfromdatabase(to);
//	    	MimeMessage message = new MimeMessage(session1);  
//	        message.setFrom(new InternetAddress(from));  
//	        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
//	        message.setSubject("Ping");  
//	        message.setText("Your one time password is :  " + password); 
//	        Transport.send(message);  
//	        return 1;  
//	 
//	     }catch (MessagingException mex) {mex.printStackTrace(); return 0;}
//		
//	}
}
