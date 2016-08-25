package com.san.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.san.service.JavaTeamService;
import com.san.service.impl.JavaTeamServiceImpl;



@Controller
public class JavaTeamController extends MultiActionController{
	@Autowired
	private JavaTeamService javaTeamService;
	public JavaTeamService getJavaTeamService() {
		return javaTeamService;
	} 
	public void setJavaTeamService(JavaTeamService javaTeamService) {
		this.javaTeamService = javaTeamService;
	}
	@RequestMapping("/listfilesjava.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse res) throws Exception {
		 
		 HttpSession session=request.getSession();
		 if(session.getAttribute("loggedInUser")!=null){
		 request.setAttribute("directory","java");
		 
		 List list=javaTeamService.getFilesList();
		 ModelAndView mv=new ModelAndView();
		//String list=completepath;
		 mv.setViewName("listfiles");
		 mv.addObject("list", list);
		 return new ModelAndView("listfiles","list",list);
		 }else
		 {
			 return new ModelAndView("login","message","You should Login first");
		 }
		 
	}
	@RequestMapping("/addjavafile.do")
	public ModelAndView addfile(HttpServletRequest request){
		boolean b=javaTeamService.addFiles();
		request.setAttribute("message", "File has been Uplaoded");
		return new ModelAndView("listfiles");
	}

}
