package com.onlineportal.service;

import java.util.ArrayList;
import java.util.List;

import com.onlineportal.dto.Appeareddetails;
import com.onlineportal.dto.Question;
import com.onlineportal.model.UploadQA;
public interface UploadqaService {

     public String UploadQuestion(UploadQA uploadqa) ;
     public List<String> getexam(String str);
	public String getStreamexam(String string);
	public List<Question> getallquestions(String value);
	public String aspirantresponse(ArrayList<Question> qt,String value, String examname);
	public int calculatescore(ArrayList<Question> qt, String value, String examname);
	public List<Appeareddetails> Displaypopup(String value);
	public int gettimer(String examname);
	public String gettype(String ename);

}
