package com.san.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.san.service.DirectorsService;

@Controller
public class DirectorsController extends MultiActionController{
	@Autowired
	private DirectorsService directorsService;
	@RequestMapping("/listfilesdirectors.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse res) throws Exception {
		 
		 HttpSession session=request.getSession();
		 request.setAttribute("directory","directors");
		 if(session.getAttribute("loggedInUser")!=null){
		 List list=directorsService.getFilesList();
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
	@RequestMapping("/adddirectorsfile.do")
	public ModelAndView addfile(HttpServletRequest request){
		boolean b=directorsService.addFiles();
		if(b)
		request.setAttribute("message", "File has been Uplaoded");
		else
			request.setAttribute("message", "File uplaoded failed");
		return new ModelAndView("listfiles");
	}
}
