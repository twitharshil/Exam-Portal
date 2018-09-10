package com.onlineportal.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlineportal.delegate.ExamDelegate;
import com.onlineportal.model.Examinfo;

@Controller
@RequestMapping(value= {"/admin"})
public class AdminExamController {

	@Autowired
	private ExamDelegate examdelegate;
	public ExamDelegate getExamdelegate() {
		return examdelegate;
	}
	public void setExamdelegate(ExamDelegate examdelegate) {
		this.examdelegate = examdelegate;
	}
    @RequestMapping(value={"/exam"})
	public ModelAndView Exam(){
		
    	ModelAndView model= new ModelAndView("exam");
		return model;
	}
	
	@RequestMapping(value={"/registerexam"},method = RequestMethod.POST)
	public ModelAndView RegisterExam(@ModelAttribute("exam") Examinfo exam,@RequestParam(value="Examdate" , required=true) String date , BindingResult result){
		
		ModelAndView model =null;
		if(result.hasErrors()){
			model =new ModelAndView("exam");
			model.addObject("msg", "Binding error");
			return model;
			
		}
		try{
			String rs= examdelegate.CreateExam(exam,date);
			if(rs.equals(exam.getExamname())){
			    model = new ModelAndView("exam");  
				model.addObject("msg", "Exam Created" );
			}
			else
			{
				model = new ModelAndView("exam");  
				model.addObject("msg", "Invalid Credentials or Exam already exist");
			}
		 }
		 catch(Exception e){
			model = new ModelAndView("exam");
			model.addObject("msg","Error occured");
		}
		return model;
	}
	@RequestMapping(value="/logoutfromexam")
	public ModelAndView dologoutfromexam(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
}
