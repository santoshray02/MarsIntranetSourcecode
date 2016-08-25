package com.san.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.service.FileService;
import com.san.service.PythonTeamService;
@Service("pythonTeamService")
public class PythonTeamServiceImpl implements PythonTeamService {

	@Autowired
	private FileService fileService;
	
    	@Override
    	public List getFilesList() throws IOException {
    		List list=new ArrayList();
    		String path="java";
    			list=fileService.getFilesList(path);
    		return list;
    	}

    	public List getDirectoryList() throws IOException {
    		List list=new ArrayList();
    		String path="java";
    			list=fileService.getDirectoryList(path);
    		return list;
    	}

		@Override
		public boolean addFiles() {
			// TODO Auto-generated method stub
			return false;
		}
}
