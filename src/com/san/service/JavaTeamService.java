package com.san.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JavaTeamService {
	public List<File> getAll(String path);
	public void deleteAll();
	public List getFilesList() throws IOException;
	public List getDirectoryList() throws IOException;
	public boolean addFiles();
}
