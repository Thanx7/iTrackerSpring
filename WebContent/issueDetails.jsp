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

</head>

<body>
        <jsp:include page="header.jsp"/>		
        <jsp:include page="navbar.jsp"/>

            <div class="hero-container">
                
                    <div class="row">
                        <div class="span12">

                            <form id="profileForm" method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/main">

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
                                    <label class="col-md-2 control-label">Summary</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">${issue.summary}</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Description</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">${issue.description}</p>                                    
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Status</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">${issue.status.statusCode}</p>                                    
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Resolution</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">${issue.resolution.resolutionName}</p>                                    
                                    </div>
                                </div>
                                                                
                                <div class="form-group">
                                    <label class="col-md-2 control-label">Type</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">1</p>                                    
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Priority</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">1</p>                                    
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Project</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">${issue.project.projectName}</p>                                    
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Build Found</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">${issue.build.name}</p>                                    
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Assignee</label>
                                    <div class="col-md-6">
                                        <p class="form-control-static">${issue.assignee.firstName} ${issue.assignee.lastName}</p>                                    
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
                                	<input type="submit" class="btn btn-primary" value="Ok">
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