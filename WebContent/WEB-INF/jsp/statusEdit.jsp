<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.status_edit"/></title>
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

 						<form id="profileForm" method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/updateStatus">
 						
							<div class="form-group">
                                <label for="nameValue" class="col-md-2 control-label"><spring:message code="label.name"/></label>
                                <div class="col-md-6">
									<input name="name" type="text" class="form-control" id="nameValue" value="${status.statusCode}"
									required data-bv-notempty-message="name is required">
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