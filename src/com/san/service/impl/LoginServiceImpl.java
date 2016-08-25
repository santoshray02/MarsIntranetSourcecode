package com.san.service.impl;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Service;

import com.san.service.LoginService;
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
	@Override
	public boolean isValidUser(String username, String password) {
		String server = "192.168.33.34";
        int port = 21;
        FTPClient ftpClient = new FTPClient();
		
		try {
            ftpClient.connect(server, port);
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return false; 
            }
            boolean success = ftpClient.login(username, password);
            showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
                return false ;
            }
            // Creates a directory
            
            // logs out
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        }
		return true;
	}
	

}
