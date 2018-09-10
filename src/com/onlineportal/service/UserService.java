package com.onlineportal.service;

import java.sql.SQLException;

import com.onlineportal.model.Aspirant;
import com.onlineportal.model.Settinginfo;
public interface UserService
{
	public boolean isValidUser(String username, String password) throws SQLException;
	public String Create(Aspirant aspirant) throws SQLException;
	public String Update(Aspirant aspirant) throws SQLException;
	public String UpdatePassword(Settinginfo setting) ;
	public String getname(String username);
	//public int send(String to, String from);
	
}

