<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="container">
      <div class="panel panel-default">
        <div class="panel-heading"><strong>Upload Files</strong> <small>Java Team files upload</small></div>
        <div class="panel-body">

          <!-- Standar Form -->
          <h4>Select files from your computer</h4>
          <form action="uploadFile.do" method="post" enctype="multipart/form-data" id="js-upload-form">
            <div class="form-inline">
              <div class="form-group">
                <input type="file" name="file">
              </div>
              <input type="submit" class="btn btn-sm btn-primary" value="Upload files"/>
            </div>
          </form>

          <!-- Drop Zone -->
          <h4>Or drag and drop files below</h4>
          <div class="upload-drop-zone" id="drop-zone">
            Just drag and drop files here
          </div>

          

          
        </div>
      </div>
    </div> <!-- /container -->