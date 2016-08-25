package com.san.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class FirstController {
	@RequestMapping("/home.do")
	public ModelAndView home(HttpServletRequest request){
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("loggedInUser");
		System.out.println(username);
		ModelAndView model = new ModelAndView();
		if(session.getAttribute("loggedInUser")!=null){
			return new ModelAndView("home");
		}else{
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("/loginpage.do")  
	public ModelAndView loginpage(HttpServletRequest request) {  
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("loggedInUser");
		System.out.println(username);
		ModelAndView model = new ModelAndView();
		if(session.getAttribute("loggedInUser")!=null){
			return new ModelAndView("home");
		}else{
			return new ModelAndView("login");
		}
	        //return model;  
	            
	    }
	
	@RequestMapping("/fileuploadpage.do")  
	public ModelAndView fileuploadpage() {  
	        return new ModelAndView("fileupload");  
	            
	    }
   
}
