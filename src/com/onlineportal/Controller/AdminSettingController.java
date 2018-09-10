package com.onlineportal.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlineportal.delegate.UserDelegate;
import com.onlineportal.model.Settinginfo;

@Controller
@RequestMapping(value= {"/admin"})
public class AdminSettingController {

	@Autowired
	private UserDelegate loginDelegate;
	public UserDelegate getLoginDelegate() {
		return loginDelegate;
	}

	public void setLoginDelegate(UserDelegate loginDelegate) {
		this.loginDelegate = loginDelegate;
	}

	@RequestMapping(value={"/setting"})
	public ModelAndView setting(){
		
		ModelAndView model = new ModelAndView("setting");
		
		return model;
	}
	@RequestMapping(value={"/updatepassword"},method = RequestMethod.POST)
	public ModelAndView UploadQuestion(@ModelAttribute("setting") Settinginfo setting, BindingResult result){
		
		ModelAndView model =null;
		if(result.hasErrors()){
			model =new ModelAndView("Setting");
			model.addObject("msg", "Cannot MOdify");
			return model;
			
		}
		try{
			String rs=  loginDelegate.UpdatePassword(setting);
			if(rs.equals("Updated"))
			{
				model = new ModelAndView("setting");
				model.addObject("msg","Admin Password Changed");	
			}
			
	     }
		 catch(Exception e){
			model = new ModelAndView("Setting");
			model.addObject("msg","Enter alid Current Password");
		}
		return model;
	}
	@RequestMapping(value="/logoutfromsetting")
	public ModelAndView dologoutfromadminsetting(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
	
}
