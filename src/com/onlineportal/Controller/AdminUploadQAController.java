package com.onlineportal.Controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlineportal.delegate.Uploaddelegate;
import com.onlineportal.model.UploadQA;

@Controller
@RequestMapping(value= {"/admin"})
public class AdminUploadQAController {
  
	@Autowired
	private Uploaddelegate qadelegate;
	public Uploaddelegate getQadelegate() {
		return qadelegate;
	}
	public void setExamdelegate(Uploaddelegate qadelegate) {
		this.qadelegate = qadelegate;
	}
	
    @RequestMapping(value={"/upload"})
	public ModelAndView Upload(){
		
    	ModelAndView model= new ModelAndView("Upload");
		return model;
	}
    
	@RequestMapping(value={"/getexamdetail"},method = RequestMethod.POST)
	public @ResponseBody List<String> getexamdetail(@RequestParam("depart") String depart){
		
		try{
			
			List<String> total = qadelegate.getexam(depart); 
	        return total;
		}
		catch(Exception e){
			return null;
		}
	}
    
    @RequestMapping(value={"/Uploadqa"},method = RequestMethod.POST)
	public ModelAndView UploadQuestion(@ModelAttribute("uploadqa") UploadQA uploadqa, BindingResult result){
		
    	System.out.println(uploadqa.getDepartment());
		ModelAndView model =null;
		if(result.hasErrors()){
			model =new ModelAndView("Upload");
			model.addObject("msg", "Binding error");
			return model;
			
		}
		try{
			String rs= qadelegate.UploadQuestion(uploadqa);
			if(rs.equals("uploaded"))
			{
				model = new ModelAndView("Upload");
				model.addObject("msg","Question Added");	
			}
			
	     }
		 catch(Exception e){
			model = new ModelAndView("Upload");
			model.addObject("msg","Error occured cannot upload this question");
		}
		return model;
	}
    @RequestMapping(value="/logoutfromupload")
	public ModelAndView dologoutfromadminupload(HttpServletRequest request){
		ModelAndView model = new ModelAndView("login");
		HttpSession session = request.getSession();
		session.invalidate();
    	return model;
	}
}
