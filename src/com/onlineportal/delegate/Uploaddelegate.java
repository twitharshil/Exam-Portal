package com.onlineportal.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineportal.dto.Appeareddetails;
import com.onlineportal.dto.Question;
import com.onlineportal.model.UploadQA;
import com.onlineportal.service.UploadqaService;

public class Uploaddelegate {

	@Autowired
	private UploadqaService uploadqaservice;

	public UploadqaService getUploadqaservice() {
		return uploadqaservice;
	}

	public void setUploadqaservice(UploadqaService uploadqaservice) {
		this.uploadqaservice = uploadqaservice;
	}

	public String UploadQuestion(UploadQA uploadqa) {
		return uploadqaservice.UploadQuestion(uploadqa);
	}

	public List<String> getexam(String str) {
		return uploadqaservice.getexam(str);
	}

	public String getStreamexam(String string) {
		return uploadqaservice.getStreamexam(string);
	}

	public List<Question> getallquestions(String value) {
		
		return uploadqaservice.getallquestions(value);
	}

	public String aspirantresponse(ArrayList<Question> qt,String value, String examname) {
		return uploadqaservice.aspirantresponse(qt,value,examname);
	}

	public int calculatescore(ArrayList<Question> qt, String value, String examname) {
		
		return uploadqaservice.calculatescore(qt,value,examname);
	}

	public List<Appeareddetails> Displaypopup(String value) {
	
		return uploadqaservice.Displaypopup(value);
	}

	public int gettimer(String examname) {
		
		return uploadqaservice.gettimer(examname) ;
	}

	public String gettype(String ename) {
		// TODO Auto-generated method stub
		return uploadqaservice.gettype(ename);
	}


}
