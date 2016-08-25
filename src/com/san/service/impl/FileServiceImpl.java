package com.san.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.service.FileService;
import com.san.service.LoginService;
@Service("fileService")
public class FileServiceImpl implements FileService {
	@Autowired
	private LoginService loginservice;
	HttpServletRequest request;
	//HttpSession session=request.getSession();
	FTPClient ftpClient = new FTPClient();
	@Override
	public List getFilesList(String path) throws IOException {
		/*HttpSession session=request.getSession();
		String username=(String) session.getAttribute("loggedInUser");
		String password=(String) session.getAttribute("password");*/

		ftpClient.connect("192.168.33.34", 21);
		//boolean success=loginservice.isValidUser("san", "a");
		boolean success=ftpClient.login("san", "a");
		List list = new ArrayList();
		if (success) {
			System.out.println("loogedin  files to server");
			//FTPFile[] files = ftpClient.listFiles("192.168.33.34/java");
			String[] files2 = ftpClient.listNames("/"+path);
			System.out.println("loogedin to server");
		//List list = new ArrayList();
			for (String file : files2) {
				list.add(file);
	            System.out.println(file);

	        }
		/*for (FTPFile file : files) {
            list.add(file.getName());
            if (file.isFile()) {
            	list.add(file.getName());
            }

        }*/
		}
			
		return list;
	}

	@Override
	public List getDirectoryList(String path) throws IOException {
		FTPFile[] files1 = ftpClient.listFiles(path);
		List list = new ArrayList();
		for (FTPFile file : files1) {
            list.add(file.getName());
            if (file.isDirectory()) {
            	list.add(file.getName());
            }

        }
		return list;
	}

}
