   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <div class="container">
    <div class="row collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        	<ul class="nav nav-tabs">
        		<li class="current"><a href="home.do">Home</a></li>
		               <li><a href="#">About</a></li>
		               <li><a href="listfilesnetwork.do">Networks</a></li>
		               <li><a href="listfilesjava.do">Java</a></li>
		               <li><a href="listfilespython.do">Python</a></li>
		               <li><a href="listfilesrnd.do">R &amp; D </a></li>
  
  						<li role="presentation" class="dropdown">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      						Others <span class="caret"></span>
    					</a>
	    					<ul class="dropdown-menu">
		    					<li><a href="about.html">About</a></li>
				               <li><a href="network.html">Networks</a></li>
				               <li><a href="java.html">Java</a></li>
				               <li><a href="python.html">Python</a></li>
				               <li><a href="rnd.html">R &amp; D </a></li>
	    					</ul>
  						</li>
  						<form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <c:choose>
      	<c:when test="${not empty loggedInUser}">
      	<li>
      	<h3 class="text-right"><span class="label label-success "><c:out value="${loggedInUser}"/></span> </h3>
      		
      	</li>
  			<a href="logout.do" class="btn btn btn-default navbar-btn navbar-right" role="button">log out</a>
		
  		</c:when>
  		<c:otherwise>
  		<a href="loginpage.do" class="btn btn btn-default navbar-btn navbar-right" role="button">Sign in</a>
  		</c:otherwise>
  
      	
		
		</c:choose> 	</ul>
			
      </div>
      </div>