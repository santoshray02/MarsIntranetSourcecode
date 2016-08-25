<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div class="services container">

  <div class="row">
  <c:if test="${not empty message}">
  		<div class="alert alert-success" role="alert">
  			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
  			<span class="sr-only"></span>
  		<c:out value="${message}"></c:out>
		</div>
  </c:if>
  	<div class="page-header text-center">
  	
  <h1>Departments <small> </small></h1>
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img class="icon" src="images/java1.png" alt="Icon">
      <div class="caption">
        <h3>Java Development team</h3>
        <p>...</p>
        <p><a href="listfilesjava.do" class="btn btn-primary" role="button">View</a> <a href="fileuploadpage.do" class="btn btn-default" role="button">upload File</a></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img class="icon" src="images/python1.ico" alt="Icon">
      <div class="caption">
        <h3>Python Development Team</h3>
        <p>...</p>
        <p><a href="listfilespython.do" class="btn btn-primary" role="button">View</a> <a href="fileuploadpage.do" class="btn btn-default" role="button">upload File</a></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img class="icon" src="images/networks1.png" alt="Icon">
      <div class="caption">
        <h3>Network Design team</h3>
        <p>...</p>
        <p><a href="listfilesnetworks.do" class="btn btn-primary" role="button">View</a> <a href="fileuploadpage.do" class="btn btn-default" role="button">upload File</a></p>
      </div>
    </div>
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img class="icon" src="images/rnd1.png" alt="Icon">
      <div class="caption">
        <h3>Research and Development Team</h3>
        <p>...</p>
        <p><a href="listfilesrnd.do" class="btn btn-primary" role="button">View</a> <a href="fileuploadpage.do" class="btn btn-default" role="button">upload File</a></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
       <img class="icon" src="images/director.jpg" alt="Icon">
      <div class="caption">
        <h3>Board of Directors </h3>
        <p>...</p>
        <p><a href="listfilesdirectors.do" class="btn btn-primary" role="button">View</a> <a href="fileuploadpage.do" class="btn btn-default" role="button">upload File</a></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
       <img class="icon" src="images/other.jpg" alt="Icon">
      <div class="caption">
        <h3>Others </h3>
        <p>...</p>
        <p><a href="listfilesothers.do" class="btn btn-primary" role="button">View</a> <a href="fileuploadpage.do" class="btn btn-default" role="button">upload File</a></p>
      </div>
    </div>
  </div>  
  </div> 
  </div>