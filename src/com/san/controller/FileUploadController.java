package com.san.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/uploadfile.do")
public class FileUploadController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView uploadfile() throws SocketException, IOException{
	String server = "192.168.33.34";
    int port = 21;
    String user = "san";
    String pass = "a";
    ModelAndView model = null;
    FTPClient ftpClient = new FTPClient();


        ftpClient.connect(server, port);
        ftpClient.login(user, pass);
        ftpClient.enterLocalPassiveMode();

        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

        File firstLocalFile = new File("F:/SantoshStudent/build.xml");

        String firstRemoteFile = "build.xml";
        InputStream inputStream = new FileInputStream(firstLocalFile);

        System.out.println("Start uploading first file");
        boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
        inputStream.close();
        
        if (done) {
        	model.addObject("home");
            System.out.println("The first file is uploaded successfully.");
        }
		return model;
    
	}
}
