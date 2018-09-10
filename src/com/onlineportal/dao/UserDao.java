package com.onlineportal.dao;
import java.sql.SQLException;

import com.onlineportal.model.Aspirant;
import com.onlineportal.model.Settinginfo;
public interface UserDao
{
	public boolean isValidUser(String username, String password) throws SQLException;
	public String Create(Aspirant aspirant,String password) throws SQLException;
	public String Update(Aspirant aspirant, String password) throws SQLException;
	public String UpdatePassword(Settinginfo setting);
	public String getname(String username);
	//public String getpasswordfromdatabase(String to);
	
	
	
}

