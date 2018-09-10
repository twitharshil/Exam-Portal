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
import com.onlineportal.model.Aspirant;


@Controller
@RequestMapping(value={"/admin"})
public class AdminRegistrationController {
	

	  @Autowired
      private UserDelegate loginDelegate; 
	  public UserDelegate getLoginDelegate() {
			return loginDelegate;
		}
		
		public void setLoginDelegate(UserDelegate loginDelegate) {
			this.loginDelegate = loginDelegate;
		}

	@RequestMapping(value={"/"})
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model = new ModelAndView("admin");
        return model;
    }	
	
	@RequestMapping(value="/regist")
	public ModelAndView AdminPage(){
		ModelAndView model = new ModelAndView("employee");
		return model;
	}
	
	@RequestMapping(value={"/employee"})
	public ModelAndView CreateAspirant(){
		
		ModelAndView model = new ModelAndView("new_employee");
		return model;
	}
	@RequestMapping(value={"/update"})
	public ModelAndView UpdateAspirant(){
		
		ModelAndView model = new ModelAndView("update_employee");
		
		return model;
	}
	@RequestMapping(value="/create", method= RequestMethod.POST)
	public ModelAndView Create(@ModelAttribute("aspirant") Aspirant aspirant,BindingResult result){
		
		 ModelAndView model= null;
		 if(result.hasErrors())
		 { 
			model =new ModelAndView("employee");
			return  model;
	      }
		 
		 try{
			
			 String rs = loginDelegate.Create(aspirant);
			 if(rs.equals(aspirant.getName()))
			 { 
				 //String from ="twitharshil@gmail.com";
				 model=new ModelAndView("new_employee");
				 model.addObject("msg"," Aspirant "+ aspirant.getName() + " added !! ");
//			 int rs1= loginDelegate.send(aspirant.getUsername(),from);
//			 if(rs1==1){
//					 System.out.println("send ho gaya h ");
//				 }
			 }
			 else
			 {
				 model=new ModelAndView("new_employee");
				 model.addObject("msg"," invalid Credentials insert again");
				 
			 }
		  }
		 catch(Exception e)
	        {
	            e.printStackTrace();
	      }
		return model;
      }
	
	
	@RequestMapping(value="/submitupdate", method= RequestMethod.POST)
	public ModelAndView Update(@ModelAttribute("aspirant") Aspirant aspirant,BindingResult result){
		
		 ModelAndView model= null;
		 if(result.hasErrors())
		 { 
			model =new ModelAndView("update_employee");
			return  model;
	      }
		 
		 try{
			 
			 String rs = loginDelegate.Update(aspirant);
			 if(rs.equals(aspirant.getName()))
			 {
				 model=new ModelAndView("update_employee");
				 model.addObject("msg","Password  Updated For "+ aspirant.getName());
			 }
			 else
			 {
				 model=new ModelAndView("update_employee");
				 model.addObject("msg","  Aspirant  " + aspirant.getName() + "  Doesn't Exist ");
				 
			 }
		  }
		 catch(Exception e)
	        {
	            e.printStackTrace();
	      }
		return model;
      }
	@RequestMapping(value="/logoutfromregistration")
	public ModelAndView dologoutfromadminregistration(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
	
	@RequestMapping(value="/logoutfromadmin")
	public ModelAndView dologoutfromadmin(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
     	return model;
	}
	
	@RequestMapping(value="/logoutfromregist")
	public ModelAndView dologoutfromadminregist(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
	
}
