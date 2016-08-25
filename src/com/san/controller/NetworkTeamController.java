package com.san.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.san.service.NetworkTeamService;
@Controller
public class NetworkTeamController extends MultiActionController{
	@Autowired
	private NetworkTeamService networkTeamService;
	public NetworkTeamService getpytonTeamService() {
		return networkTeamService;
	}
	public void setNetworkTeamService(NetworkTeamService networkTeamService) {
		this.networkTeamService = networkTeamService;
	}
	@RequestMapping("/listfilesnetwork.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse res) throws Exception {
		 
		 HttpSession session=request.getSession();
		 request.setAttribute("directory","network");
		 if(session.getAttribute("loggedInUser")!=null){
		 List list=networkTeamService.getFilesList();
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
	@RequestMapping("/addnetworkfile.do")
	public ModelAndView addfile(HttpServletRequest request){
		boolean b=networkTeamService.addFiles();
		if(b)
		request.setAttribute("message", "File has been Uplaoded");
		else
			request.setAttribute("message", "File uplaoded failed");
		return new ModelAndView("listfiles");
	}
}
