<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                    <label class="col-md-2 control-label">Id</label>
                                        <p class="form-control-static">${issue.id}</p>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-2 control-label">Create Date</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">${issue.dateCreation}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Created By</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">id=${issue.userCreation.id}: ${issue.userCreation.firstName} ${issue.userCreation.lastName}</p>
                                    </div>
                                </div>

                                <c:if test="true">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">Modify Date</label>
                                        <div class="col-md-6">
                                            <p class="form-control-static">${issue.modifyDate}</p>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-2 control-label">Modified By</label>
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
                                    <label for="summaryValue" class="col-md-2 control-label">Summary</label>
                                    <div class="col-md-6">
                                        <input name="summary" type="text" class="form-control" value="${issue.summary}"
                                        required data-bv-notempty-message="summary is required">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Description</label>
                                    <div class="col-md-6">
                                        <textarea name="description" class="form-control" rows="3"
                                        required data-bv-notempty-message="description is required">${issue.description}</textarea>
                                    </div>
                                </div>
                                
                            <div class="form-group">
                                <label class="col-md-2 control-label">Status</label>
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
                                <label class="col-md-2 control-label">Resolution</label>
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
                                <label for="typeValue" class="col-md-2 control-label">Type</label>
                                <div class="col-md-4">
                                    <select name="type" class="form-control">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 control-label">Priority</label>
                                <div class="col-md-4">
                                    <select name="priority" class="form-control">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 control-label">Project</label>
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
                                <label class="col-md-2 control-label">Build Found</label>
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
                                <label class="col-md-2 control-label">Assignee</label>
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
                            	<label class="col-md-2 control-label">Comment</label>
                                    <div class="col-md-6">
                                       <textarea name="comment" class="form-control" rows="2" placeholder="Enter comment"></textarea>
                                    </div>
                            </div>
							
                    		<div class="row">
                            		<ul class="comments-list">
                                		<c:forEach items="${issue.commentList}" var="comment">
        	                            <li class="comment">
               	                            Added By: ${comment.user.firstName} ${comment.user.lastName}<br>
                      	                    Add Date: ${comment.createDate}<br>
  	                                        Comment: ${comment.text}<br>
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