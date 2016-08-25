package com.san.controller;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

import com.san.model.LoginModel;
import com.san.service.LoginService;

@Controller
public class UserController{
	@Autowired
	private LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

    @RequestMapping("/login.do")
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response){
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	boolean isValidUser = loginService.isValidUser(username,password );
    	 HttpSession session=request.getSession();
    	 ModelAndView model;            
    	 if(isValidUser)
    	 
    	             {
    	 
    	                 System.out.println("User Login Successful");
    	                 session.setAttribute("loggedInUser", username);
    	                 session.setAttribute("password", password);
    	 
    	                 model = new ModelAndView("home");
    	 
    	             }
    	 
    	             else
    	 
    	             {
    	 
    	                 model = new ModelAndView("login");
    	               request.setAttribute("message", "Invalid credentials!!");
    	 
    	             }
    	//return new ModelAndView("home");
    	return model;
    	
    }
    /*@RequestMapping("/listfilesjava.do")
    public ModelAndView listfiles(){
    	File folder = new File("F:/MYwork/Spring/jars/springmvctilesjar/springmvctilesjar");
    	File[] listOfFiles = folder.listFiles();
    		List list=new ArrayList();
    	    for (int i = 0; i < listOfFiles.length; i++) {
    	      if (listOfFiles[i].isFile()) {
    	    	  list.add(listOfFiles[i].getName());
    	        System.out.println("File " + listOfFiles[i].getName());
    	        System.out.println(list.size());
    	      } else if (listOfFiles[i].isDirectory()) {
    	        System.out.println("Directory " + listOfFiles[i].getName());
    	      }
    	    
    	    }
    	return new ModelAndView("listfiles","list",list);
    }*/
    @RequestMapping("/logout.do")
    public ModelAndView executeLogout(HttpServletRequest request,HttpServletResponse response) throws IOException{
                 
    		 HttpSession session=request.getSession();  
            session.invalidate(); 
             {
    	                 System.out.println("LoogedOff");
    	                 request.setAttribute("message", "you are loggedout");
    	 
    	             }
    	 
    	return new ModelAndView("login");
    	//return model;
    	
    }


}
