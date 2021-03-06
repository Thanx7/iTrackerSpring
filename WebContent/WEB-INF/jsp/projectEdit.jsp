<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.project_edit"/></title>
<jsp:include page="scripts.jsp"/>
	
<script>
$(document).ready(function() {
    $('#profileForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        }
    });
});
</script>
	
</head>
<body>
        <jsp:include page="header.jsp"/>		
        <jsp:include page="navbar.jsp"/>

            <div class="hero-container">

                <div class="row">
                    <div class="span12">

 						<form id="profileForm" method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/updateProject">
 						
							<div class="form-group">
                                <label for="nameValue" class="col-md-2 control-label"><spring:message code="label.project_name"/></label>
                                <div class="col-md-6">
									<input name="name" type="text" class="form-control" id="nameValue" value="${project.projectName}"
									required data-bv-notempty-message="name is required">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="descriptionValue" class="col-md-2 control-label"><spring:message code="label.description"/></label>
                                <div class="col-md-6">
                                    <textarea name="description" class="form-control" id="descriptionValue" rows="3"
                                    required data-bv-notempty-message="description is required">${project.description}</textarea>
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label for="builds" class="col-md-2 control-label"><spring:message code="label.builds"/></label>
                                <div class="col-md-4">
									<select name="builds" class="form-control" id="builds">
                                        <c:forEach var="build" items="${project.buildList}">
                                        	<option value="${build.id}"
    										   	<c:if test="${project.id eq build.project.id}">
    											 selected="selected"
    											</c:if> 
    										>id=${build.id}: ${build.name}</option>
					       				</c:forEach>
									</select>
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label for="newBuild" class="col-md-4 control-label"><spring:message code="label.new_build"/></label>
                                <div class="col-md-4">
									<input name="newBuild" type="text" class="form-control" id="newBuild">
                                </div>
                            </div>
                                                            
							<div class="form-group">
								<label for="manager" class="col-md-2 control-label"><spring:message code="label.manager"/></label>
								<div class="col-md-4">
									<select name="manager" class="form-control" id="manager">
                                        <c:forEach var="user" items="${users}">
                                        	<option value="${user.id}"
    										   	<c:if test="${user.id eq project.manager.id}">
    											 selected="selected"
    											</c:if>                                       	
                                        	>id=${user.id}: ${user.firstName} ${user.lastName}</option>
					       				</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-offset-2 col-md-10">
									<button type="submit" class="btn btn-primary"><spring:message code="label.update"/></button>
								</div>
							</div>
							
						</form>

                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp" />
    </body>
</html>