<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.submit_issue"/></title>
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

<script>
$(document).ready(function() {
    $('#dropdown1').change(function() {
        var selectedValue = $(this).val();
        var servletUrl = 'dropdown2options?value=' + selectedValue;

        $.getJSON(servletUrl, function(options) {
            var dropdown2 = $('#dropdown2');
            $('>option', dropdown2).remove();
            if (options) {
                $.each(options, function(key, value) {
                    dropdown2.append($('<option/>').val(key).text(value));
                });
            };
        });
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

                        <form id="profileForm" method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/saveIssue">
 
							<div class="form-group">
                                <label for="summaryValue" class="col-md-2 control-label"><spring:message code="label.summary"/></label>
                                <div class="col-md-6">
                                    <input type="text" name="summary" class="form-control" placeholder="Enter summary"
                                    required data-bv-notempty-message="summary is required">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label for="descriptionValue" class="col-md-2 control-label"><spring:message code="label.description"/></label>
                                <div class="col-md-6">
                                    <textarea name="description" class="form-control" rows="3" placeholder="Enter description"
                                    required data-bv-notempty-message="description is required"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="statusValue" class="col-md-2 control-label"><spring:message code="label.status"/></label>
                                <div class="col-md-4">
                                    <select name="status" class="form-control">
                                    	<c:forEach var="status" items="${statuses}">
                                    		<c:if test="${status.id lt 3}">
    											<option value="${status.id}">${status.statusCode}</option>
    										</c:if>
										</c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="typeValue" class="col-md-2 control-label"><spring:message code="label.type"/></label>
                                <div class="col-md-4">
                                    <select name="type" class="form-control">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="priorityValue" class="col-md-2 control-label"><spring:message code="label.priority"/></label>
                                <div class="col-md-4">
                                    <select name="priority" class="form-control">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="projectValue" class="col-md-2 control-label"><spring:message code="label.project"/></label>
                                <div class="col-md-4">
                                    <select id="dropdown1" name="project" class="form-control">
					                   	<c:forEach var="project" items="${projects}">
    										<option value="${project.id}"
    										   	<c:if test="${project.id eq 1}">
    											 selected="selected"
    											</c:if> 
    										>${project.projectName}</option>
										</c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="buildFoundValue" class="col-md-2 control-label"><spring:message code="label.build_found"/></label>
                                <div class="col-md-4">
                                    <select id="dropdown2" name="build" class="form-control">
                                    	<c:forEach var="build" items="${firstProject.buildList}">
   											<option value="${build.id}"
												<c:if test="${build.id eq 1}">
    											 selected="selected"
    											</c:if> 
											>${build.name}</option>
   										</c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="assigneeValue" class="col-md-2 control-label"><spring:message code="label.assignee"/></label>
                                <div class="col-md-4">
                                    <select name="assignee" class="form-control">
                                    	<option selected="selected" value="0"></option>
                                        <c:forEach var="user" items="${users}">
                                        	<option value="${user.id}">id=${user.id}: ${user.firstName} ${user.lastName}</option>
					       				</c:forEach>
                                    </select>
                                </div>
                            </div>
							
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-10">
                                	<input type="submit" class="btn btn-primary" value="<spring:message code="label.add"/>">
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