<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Tracker</title>
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

<script>
$(document).ready(function() {
    $('#dropdownStatus').change(function() {
        var selectedValue = $(this).val();
        var select = document.getElementById('dropdownResolution');
        var len = select.length;
        	
        if (selectedValue == "3") {

       		$('#dropdownResolution').find('option[value=0]').show();
       		$('#dropdownResolution').find('option[value=0]').prop("selected", "selected");       		
       		
        	for (i=1; i<=len; i++) {
        		$('#dropdownResolution').find('option[value=i]').hide();
	       	}
        	
        	$('#dropdownResolution').attr('disabled', true);
        }

        if (selectedValue == "4" || selectedValue == "5") {

       		$('#dropdownResolution').find('option[value=0]').hide();
       		$('#dropdownResolution').find('option:selected').removeAttr("selected");
       		$('#dropdownResolution').find('option[value=1]').prop("selected", "selected");
       		
        	for (i=1; i<=len; i++) {
        		$('#dropdownResolution').find('option[value=i]').show();
	       	}
        	
        	$('#dropdownResolution').attr('disabled', false);
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

                            <form id="profileForm" method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/updateIssue">

                                <div class="form-group">
                                    <label class="col-md-2 control-label"><spring:message code="label.id"/></label>
                                        <p class="form-control-static">${issue.id}</p>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-2 control-label"><spring:message code="label.cr_date"/></label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">${issue.dateCreation}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label"><spring:message code="label.cr_by"/></label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">id=${issue.userCreation.id}: ${issue.userCreation.firstName} ${issue.userCreation.lastName}</p>
                                    </div>
                                </div>

                                <c:if test="true">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label"><spring:message code="label.mod_date"/></label>
                                        <div class="col-md-6">
                                            <p class="form-control-static">${issue.modifyDate}</p>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-2 control-label"><spring:message code="label.mod_by"/></label>
                                        <div class="col-md-6">
                                        	<c:if test="${not empty issue.userModify.id}">
                                        		<p class="form-control-static">id=${issue.userModify.id}: ${issue.userModify.firstName} ${issue.userModify.lastName}</p>
											</c:if>
                                        	<c:if test="${empty issue.userModify.id}">
                                        		<p class="form-control-static"></p>
											</c:if>                                            
                                        </div>
                                    </div>
                                </c:if>
                                    
                                <div class="form-group">
                                    <label for="summaryValue" class="col-md-2 control-label"><spring:message code="label.summary"/></label>
                                    <div class="col-md-6">
                                        <input name="summary" type="text" class="form-control" value="${issue.summary}"
                                        required data-bv-notempty-message="summary is required">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label"><spring:message code="label.description"/></label>
                                    <div class="col-md-6">
                                        <textarea name="description" class="form-control" rows="3"
                                        required data-bv-notempty-message="description is required">${issue.description}</textarea>
                                    </div>
                                </div>
                                
                            <div class="form-group">
                                <label class="col-md-2 control-label"><spring:message code="label.status"/></label>
                                <div class="col-md-4">
                                    <select id="dropdownStatus" name="status" class="form-control">
                                    	<c:if test="${issue.status.id eq 1 || issue.status.id eq 6}">
    									 <option value="1" selected="selected">${statuses[0].statusCode}</option>
    									 <option value="2">${statuses[1].statusCode}</option>
    									</c:if>

                                    	<c:if test="${issue.status.id eq 2}">
    									 <option value="2" selected="selected">${statuses[1].statusCode}</option>
    									 <option value="3">${statuses[2].statusCode}</option>
    									</c:if>

                                    	<c:if test="${issue.status.id eq 3}">
    									 <option value="3" selected="selected">${statuses[2].statusCode}</option>
    									 <option value="4">${statuses[3].statusCode}</option>
    									 <option value="5">${statuses[4].statusCode}</option>
    									</c:if>
    									
                                    	<c:if test="${issue.status.id eq 4}">
    									 <option value="4" selected="selected">${statuses[3].statusCode}</option>
    									 <option value="5">${statuses[4].statusCode}</option>
    									 <option value="6">${statuses[5].statusCode}</option>
    									</c:if>

                                    	<c:if test="${issue.status.id eq 5}">
    									 <option value="5" selected="selected">${statuses[4].statusCode}</option>
    									 <option value="6">${statuses[5].statusCode}</option>
    									</c:if>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 control-label"><spring:message code="label.resolution"/></label>
                                <div class="col-md-4">
                                    <select id="dropdownResolution" name="resolution" class="form-control" disabled>
                                    	<c:if test="${issue.status.id lt 3}">
    										<option selected="selected"></option>
                                    	</c:if>
                                    	
                                    	<c:if test="${issue.status.id eq 3}">
                                    		<option value="0" selected="selected"></option>
					                   		<c:forEach var="resolution" items="${resolutions}">
	    										<option value="${resolution.id}">${resolution.resolutionName}</option>
											</c:forEach>
                                    	</c:if>
                                    	
                                    	<c:if test="${issue.status.id gt 3}">
					                   		<c:forEach var="resolution" items="${resolutions}">
	    										<option value="${resolution.id}"
	    										   	<c:if test="${resolution.id eq issue.resolution.id}">
	    											 selected="selected"
	    											</c:if> 
	    										>${resolution.resolutionName}</option>
											</c:forEach>
                                    	</c:if>
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
                                <label class="col-md-2 control-label"><spring:message code="label.priority"/></label>
                                <div class="col-md-4">
                                    <select name="priority" class="form-control">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 control-label"><spring:message code="label.project"/></label>
                                <div class="col-md-4">
                                    <select id="dropdown1" name="project" class="form-control">
					                   	<c:forEach var="project" items="${projects}">
    										<option value="${project.id}"
    										   	<c:if test="${project.id eq issue.project.id}">
    											 selected="selected"
    											</c:if> 
    										>${project.projectName}</option>
										</c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 control-label"><spring:message code="label.build_found"/></label>
                                <div class="col-md-4">
                                    <select id="dropdown2" name="build" class="form-control">
                                    	<c:forEach var="build" items="${issue.project.buildList}">
   											<option value="${build.id}"
												<c:if test="${build.id eq issue.build.id}">
    											 selected="selected"
    											</c:if> 
											>${build.name}</option>
   										</c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 control-label"><spring:message code="label.assignee"/></label>
                                <div class="col-md-4">
                                    <select name="assignee" class="form-control">
                                    	<option selected="selected" value="0"></option>
                                        <c:forEach var="user" items="${users}">
                                        	<option value="${user.id}"
    										   	<c:if test="${user.id eq issue.assignee.id}">
    											 selected="selected"
    											</c:if>                                       	
                                        	>id=${user.id}: ${user.firstName} ${user.lastName}</option>
					       				</c:forEach>
                                    </select>
                                </div>
                            </div>
							
							<div class="form-group">
                            	<label class="col-md-2 control-label"><spring:message code="label.add_comment"/></label>
                                    <div class="col-md-6">
                                       <textarea name="comment" class="form-control" rows="2" placeholder="Enter comment"></textarea>
                                    </div>
                            </div>
							
                    		<div class="row">
                            		<ul class="comments-list">
                                		<c:forEach items="${issue.commentList}" var="comment">
        	                            <li class="comment">
               	                            <spring:message code="label.cr_by"/>: ${comment.user.firstName} ${comment.user.lastName}<br>
                                            <spring:message code="label.cr_date"/>: ${comment.createDate}<br>
                                            <spring:message code="label.comment"/>: ${comment.text}<br>
            	                        </li>
                                		</c:forEach>
                            		</ul>   
        		            </div>							
							
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-10">
                                	<input type="submit" class="btn btn-primary" value="Update">
                                </div>
                            </div>
							
							<input type="hidden" name="id" value="${issue.id}" />
							
                            </form>
                            
                        </div>
                    </div>
               
            </div>
        </div>

        <jsp:include page="footer.jsp" />
    </body>
</html>