<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="navbar navbar-static-top">
    <div class="navbar-inner">
        <div class="container">
            <div class="nav-collapse">

                  <span>
                     <a href="?lang=en">en</a>|<a href="?lang=ru">ru</a>
                  </span>

                  <span>
                  	<spring:message code="label.pagination"/>:
                    <c:forEach begin="0" end="${pagesCount}" var="val">
    					<a href="page/${val}/">${val}</a>|
					</c:forEach>
                  </span>
               
                  <c:if test="${not empty errorMessage}">
                    <span class="message-body">
                      <span class="error">
                      	<spring:message code="label.${errorMessage}" />
                      </span>
                    </span>
                	</c:if>

                  <c:if test="${not empty success}">
                    <span class="message-body">
                      <span>
                      	<spring:message code="label.${success}" />
                      </span>
                    </span>
                	</c:if>
               
                    <c:if test="${not empty user}">
                        <div class="form-inline pull-right">
                            <span><spring:message code="label.welcome"/>, ${user.firstName} ${user.lastName}</span>
                            <a href="logout" class="btn" type="logout"><spring:message code="label.logout"/></a>
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
                            <button class="btn" type="submit"><spring:message code="label.sign_in"/></button>
                        </form>
                    </c:if>

            </div>
        </div>
    </div>
</div>