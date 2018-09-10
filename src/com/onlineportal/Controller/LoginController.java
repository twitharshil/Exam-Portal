package com.onlineportal.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlineportal.delegate.UserDelegate;
import com.onlineportal.model.User;

@Controller
@RequestMapping(value="/login")
public class LoginController
{

	@Autowired
	private UserDelegate loginDelegate;
	public UserDelegate getLoginDelegate() {
		return loginDelegate;
	}

	public void setLoginDelegate(UserDelegate loginDelegate) {
		this.loginDelegate = loginDelegate;
	}

	@RequestMapping(value={"/"})
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model = new ModelAndView("login");
        return model;
    }	
    
	@RequestMapping(value={"/loginpro"}, method=RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response ,@ModelAttribute("loginBean") User loginBean, BindingResult result){
		
		ModelAndView model= null;
		if(result.hasErrors()){
	        model =new ModelAndView("login");
			return model;
		}
	  
		try
        {
            boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());
            if(isValidUser)
            {
            	
            	HttpSession session = request.getSession();
            	String name = loginDelegate.getname(loginBean.getUsername());
                System.out.println("User Login Successful");
                if(loginBean.getUsername().equals("admin@gmail.com"))
                { 
                     model = new ModelAndView("admin");
                     session.setAttribute("nam","admin" );
                 }
                else
                	{
                	
                	    model=new ModelAndView("Student");
                	    session.setAttribute("nam",name );
                	    session.setAttribute("mail", loginBean.getUsername());
                	}
            }
            else
            {
                model = new ModelAndView("login");
                model.addObject("loginBean", loginBean);
                model.addObject("message", "Invalid credentials!!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return model;
    }
	@RequestMapping(value="/logout")
	public ModelAndView dologoutfromlogin(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
	@RequestMapping(value="/logoutfromstudent")
	public ModelAndView dologoutfromstudent(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
}

	
