package com.san.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.service.FileService;
import com.san.service.JavaTeamService;
@Service("javaTeamService")
public class JavaTeamServiceImpl implements JavaTeamService{
	@Autowired
	private FileService fileService;
	@Override
	public List getAll(String path) {
		File folder = new File(path);
    	File[] listOfFiles = folder.listFiles();
    	List<File> list=new ArrayList<File>();
    	for (int i = 0; i < listOfFiles.length; i++) {
  	      if (listOfFiles[i].isFile()) {
  	    	  list.add(listOfFiles[i]);
  	    	System.out.println("File " + listOfFiles[i].getPath());
  	      } else if (listOfFiles[i].isDirectory()) {
  	    	list.add(listOfFiles[i]);
  	        System.out.println("Directory " + listOfFiles[i].getPath());
  	      }
  	    
  	    }
		//List list=new ArrayList();
		//list.add(path);
		return list;
	}
	
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addFiles() {
		
		return true;
		
		
	}

	@Override
	public List getFilesList() throws IOException {
		List list=new ArrayList();
		String path="java";
			list=fileService.getFilesList(path);
		return list;
	}

	@Override
	public List getDirectoryList() throws IOException {
		List list=new ArrayList();
		String path="java";
			list=fileService.getDirectoryList(path);
		return list;
	}

}
