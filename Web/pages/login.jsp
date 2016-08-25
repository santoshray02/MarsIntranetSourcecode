<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div class = "container">
  <div class="wrapper">
  <c:if test="${not empty message}">
  		<div class="alert alert-danger" role="alert">
  			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  			<span class="sr-only">Error:</span>
  <c:out value="${message}"></c:out>
</div>
  </c:if>
    <form action="login.do" method="post" name="Login_Form" class="form-signin">       
        <h3 class="form-signin-heading"> Please Sign In</h3>
        <hr><br>
        
        <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />
        <input type="password" class="form-control" name="password" placeholder="Password" required=""/>          
       
        <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>        
    </form>     

  </div>
</div>