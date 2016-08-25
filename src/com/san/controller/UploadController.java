package com.san.controller;
import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/uploadFile.do")
public class UploadController {
private String saveDirectory = "F:/";

	
	@RequestMapping(method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request, 
			@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
		String server = "192.168.33.34";
        int port = 21;
        FTPClient ftpClient = new FTPClient();
		ftpClient.connect(server, port);
        ftpClient.login("san","a");
		//System.out.println("description: " + request.getParameter("description"));
		
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload){
				
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
			}
		}

		// returns to the view "Result"
		return "Result";
	}
}
