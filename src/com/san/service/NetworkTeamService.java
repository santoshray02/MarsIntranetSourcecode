package com.san.service;

import java.io.IOException;
import java.util.List;

public interface NetworkTeamService {
	public List getFilesList() throws IOException;
	public List getDirectoryList() throws IOException;
	public boolean addFiles();
}
