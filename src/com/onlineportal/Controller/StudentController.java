package com.onlineportal.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlineportal.delegate.Uploaddelegate;
import com.onlineportal.dto.Appeareddetails;
import com.onlineportal.dto.Question;

@Controller
@RequestMapping(value="/student")
public class StudentController {

	@Autowired
	private Uploaddelegate qadelegate;
	public Uploaddelegate getQadelegate() {
		return qadelegate;
	}
	public void setExamdelegate(Uploaddelegate qadelegate) {
		this.qadelegate = qadelegate;
	}
	@RequestMapping(value={"/"})
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model = new ModelAndView("Student");
        return model;
    }	
	
	 @RequestMapping(value={"/Appear"})
		public ModelAndView Exam(){
			
	    	ModelAndView model= new ModelAndView("Appear");
			return model;
		}
	
	 @RequestMapping(value={"/database"},method = RequestMethod.GET)
		public @ResponseBody List<String> getexamdetail(HttpServletRequest request,HttpServletResponse response ){
			try{
				String value =(String ) request.getSession().getAttribute("mail");
				String stream = qadelegate.getStreamexam(value);
				List<String> total = qadelegate.getexam(stream); 
		        return total;
			}
			catch(Exception e){
				return null;
			}
		}
	 @RequestMapping(value={"/begin"},method = RequestMethod.POST)
	 public ModelAndView displayexampage(HttpServletRequest request, HttpServletResponse response,@RequestParam("ex") String ename)
	    {
		    ModelAndView model=null;
		    HttpSession session = request.getSession();
		    String type=qadelegate.gettype(ename);
		    if(type.equals("One")){
		    	model = new ModelAndView("Begin");
		        session.setAttribute("en", ename);
		    }
		    else
		    {
		    	model = new ModelAndView("Beginall");
		        session.setAttribute("en", ename);
		    }
		    return model;
	    }
	 
	 @RequestMapping(value={"/examdedo"},method = RequestMethod.GET)
	 public @ResponseBody List<Question> displayquestion(HttpServletRequest request, HttpServletResponse response)
	    {
		 HttpSession session = request.getSession();
		 try{
			    String value =(String )session.getAttribute("en");
			    List<Question> Allquestions= qadelegate.getallquestions(value);
			    return Allquestions;
			}
			catch(Exception e){
				return null;
			}
		  }
	@RequestMapping(value={"/responsed"},method = RequestMethod.POST)
	 public @ResponseBody int displayresponse(HttpServletRequest request, HttpServletResponse response,@RequestBody ArrayList<Question> qt)
	    {
		  
		  HttpSession session = request.getSession();
		  String value =(String ) request.getSession().getAttribute("mail");
		  String examname =(String )session.getAttribute("en");
		  String rs = qadelegate.aspirantresponse(qt,value,examname);
		  if(rs.equals("inserted")){
			   int rs1=qadelegate.calculatescore(qt,value,examname);
			   session.setAttribute("marks", rs1);
			  return rs1;
		  }
		  else
		  return 100;
		 }
	@RequestMapping(value={"/thankyou"},method = RequestMethod.GET)
	 public ModelAndView displaythankyou(@RequestParam("score") int value)
    {
	    ModelAndView model = new ModelAndView("thank");
        model.addObject("marks",value );
        return model;
    }
	
	@RequestMapping(value={"/getpopup"})
	 public ModelAndView Displaypopup(HttpServletRequest request, HttpServletResponse response)
   {
		HttpSession session = request.getSession();
	    String value =(String )session.getAttribute("mail");
	    List<Appeareddetails> Alldetail= qadelegate.Displaypopup(value);
	    ModelAndView model = new ModelAndView("performance");
	    model.addObject("getlist",Alldetail);
	    return model;
   }
	@RequestMapping(value={"/timer"},method = RequestMethod.GET)
	 public @ResponseBody int displaytime(HttpServletRequest request, HttpServletResponse response)
	    {
		  
		  HttpSession session = request.getSession();
		  String examname =(String )session.getAttribute("en");
		  int rs = qadelegate.gettimer(examname);
		  return rs;
		 }
	
	@RequestMapping(value="/logoutfromstudent")
	public ModelAndView dologoutfromstudent(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
	@RequestMapping(value="/logoutfromappear")
	public ModelAndView dologoutfromappear(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
	@RequestMapping(value="/logoutfromthank")
	public ModelAndView dologoutfromthank(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
	
}
