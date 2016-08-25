package com.san.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.service.FileService;
import com.san.service.NetworkTeamService;
@Service("networkTeamService")
public class NetworkTeamServiceImpl implements NetworkTeamService {


	@Autowired
	private FileService fileService;
	
    	@Override
    	public List getFilesList() throws IOException {
    		List list=new ArrayList();
    		String path="network";
    			list=fileService.getFilesList(path);
    		return list;
    	}

    	public List getDirectoryList() throws IOException {
    		List list=new ArrayList();
    		String path="network";
    			list=fileService.getDirectoryList(path);
    		return list;
    	}

		@Override
		public boolean addFiles() {
			// TODO Auto-generated method stub
			return false;
		}

}
