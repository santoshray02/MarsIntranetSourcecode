<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.io.*" %>

<div class="container">
<div class="row">
<p class="center" >
<button type="button" class="btn btn-labeled btn-primary btn-lg pull-right"> <span class="btn-label"><i class="glyphicon glyphicon-upload"></i> </span>Upload files</button>

</p>
	
</div>
</div>
<div class="container">

		<div class="well">
        <h1 class="text-center"><c:out value="${directoryname}"></c:out></h1>
        <div class="list-group-item">
        <c:choose>
        	<c:when test="${not empty list}">
        		<c:forEach var="listValue" items="${list}">
          
                
                <div class="row">
                    <h3 class="list-group-item-heading"> File :  ${listValue}</h3>
                    </p>
                    
               
                <p>
                     <a href="download.do?path=${listValue}" class="btn btn-default btn-lg pull-right"><span class="glyphicon glyphicon-download-alt"></span>  Download Now! </a>
                     </p>
                </div>
               
          		</c:forEach>
        	</c:when>
        	<c:otherwise>
        		<div class="alert alert-warning">
  					<strong>Oops!</strong> No Files Found in this Directory.
				</div>
        	</c:otherwise>
        </c:choose>
        
        
        </div>
	</div>
</div>








<div class="row">
	
	
</div>