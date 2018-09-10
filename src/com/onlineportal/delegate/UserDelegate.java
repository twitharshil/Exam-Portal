package com.onlineportal.delegate;
import java.sql.SQLException;

import com.onlineportal.model.Aspirant;
import com.onlineportal.model.Settinginfo;
import com.onlineportal.service.UserService;

public class UserDelegate
	{
	   private UserService userService;
		public UserService getUserService()
	    {
	        return this.userService;
	    }
	    public void setUserService(UserService userService)
	    {
	        this.userService = userService;
	    }
	    public boolean isValidUser(String username, String password) throws SQLException
	    {
	        return userService.isValidUser(username, password);
	    }
	    public String Create(Aspirant aspirant) throws SQLException
		{
			return userService.Create(aspirant);
		}
		public String Update(Aspirant aspirant) throws SQLException {
			
			return userService.Update(aspirant);
		}
		public String UpdatePassword(Settinginfo setting) {
			return userService.UpdatePassword(setting);
		}
		public String getname(String username) {
			return userService.getname(username);
		}
//	public int send(String to, String from) {
//			
//			return userService.send(to,from);
//		}
//		
	}

