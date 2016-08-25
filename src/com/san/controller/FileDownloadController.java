package com.san.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.san.service.LoginService;

@Controller
@RequestMapping("/download.do")
public class FileDownloadController {
	
	
	@Autowired
	private LoginService loginservice;
	
	@RequestMapping(value = "/redirect",method = RequestMethod.GET)
    public ModelAndView doDownload(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
        // get absolute path of the application
		String server = "192.168.33.34";
        int port = 21;
        FTPClient ftpClient = new FTPClient();
		ftpClient.connect(server, port);
        ftpClient.login("san","a");
		//boolean b=loginservice.isValidUser("san","a");
		
		
		ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        	String fileUrl = request.getParameter("path");
            File downloadFile = new File("D:/"+fileUrl);
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile));
            boolean success = ftpClient.retrieveFile(fileUrl, outputStream1);
            outputStream1.close();
             ModelAndView model = null;
            if (success) {
                System.out.println("File has been downloaded successfully.");
                request.setAttribute("message","File has been downloaded successfully." );
                model=new ModelAndView("home");
            }
 
        return model;
	}

}
