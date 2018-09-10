package com.onlineportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineportal.dao.UploadqaDao;
import com.onlineportal.dto.Appeareddetails;
import com.onlineportal.dto.Question;
import com.onlineportal.model.UploadQA;

public class UploadqaServiceImpl implements UploadqaService {
		
	    @Autowired
		private UploadqaDao qadao;
		
	    public UploadqaDao getQadao() {
			return this.qadao;
		}
	    public void setQadao(UploadqaDao qadao) {
			this.qadao = qadao;
		}
	    public String UploadQuestion(UploadQA uploadqa) {
			
	    	return qadao.UploadQuestion(uploadqa);
		}
		public List<String> getexam(String str) {
			return qadao.getexam(str);
		}
        
		public String getStreamexam(String string) {
			return qadao.getStreamexam(string);
		}
		public List<Question> getallquestions(String value) {
			
			return qadao.getallquestions(value);
		}
		
		public String aspirantresponse(ArrayList<Question> qt,String value,String examname) {
		
			return qadao.aspirantresponse(qt,value,examname);
		}
	
		public int calculatescore(ArrayList<Question> qt, String value, String examname) {
			
			return qadao.calculatescore(qt,value,examname) ;
		}
		
		public List<Appeareddetails> Displaypopup(String value) {
			
			return qadao.Displaypopup(value);
		}
	
		public int gettimer(String examname) {
			// TODO Auto-generated method stub
			return qadao.gettimer(examname);
		}
		@Override
		public String gettype(String ename) {
			
			return qadao.gettype(ename);
		}
	
}
