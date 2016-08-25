package com.san.service;

import java.io.IOException;
import java.util.List;

public interface FileService {
	public List getFilesList(String path) throws IOException; 
	public List getDirectoryList(String path) throws IOException;
}
