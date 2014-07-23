<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar navbar-static-top">
    <div class="navbar-inner">
        <div class="container">
            <div class="nav-collapse">
               
                  	<c:if test="${not empty errorMessage}">
                     <span class="message-body">
                      <span class="error">${errorMessage}</span>
                     </span>
                	</c:if>

                  	<c:if test="${not empty success}">
                     <span class="message-body">
                      <span>${success}</span>
                     </span>
                	</c:if>
               
                    <c:if test="${not empty user}">
                        <div class="form-inline pull-right">
                            <span>Hello, ${user.firstName} ${user.lastName}</span>
                            <a href="logout" class="btn" type="logout">Log out</a>
                        </div>
                    </c:if>
                    <c:if test="${empty user}">
                        <form class="form-inline pull-right" id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
                        	<div class="form-group">
                            	<input class="form-control" name="email" type="text" value="ilya@site.com"
                            		required data-bv-notempty-message="email is required">
                           	</div>                  
                        	<div class="form-group">                           	          		
                            	<input class="form-control" name="password" type="password" value="first"
                            		required data-bv-notempty-message="password is required">
                           	</div>                            		
                            <button class="btn" type="submit">Sign in</button>
                        </form>
                    </c:if>

            </div>
        </div>
    </div>
</div>