<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.issue_tracker"/></title>
<jsp:include page="scripts.jsp"/>

<script>
$(document).ready(function() {
    $('#loginForm').bootstrapValidator({
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

            <table class="table table-striped table-hover table-view">
                <tr>
                    <td class="l"><a href="main/id/"><spring:message code="label.id"/></a></td>
                    <td class="l"><a href="main/priority/"><spring:message code="label.priority"/></a></td>
                    <td class="l"><a href="main/assignee/"><spring:message code="label.assignee"/></a></td>
                    <td class="l"><a href="main/type/"><spring:message code="label.type"/></a></td>
                    <td class="l"><a href="main/status/"><spring:message code="label.status"/></a></td>
                    <td class="l"><a href="main/summary/"><spring:message code="label.summary"/></a></td>
                </tr>

                <c:forEach var="issue" items="${issueList}" >
                <tr>
                
					<c:if test="${not empty user}">
                 		<td class="l"><a href="issue/${issue.id}/">${issue.id}</a></td>
                    </c:if>
					<c:if test="${empty user}">
                 		<td class="l"><a href="issueDetails/${issue.id}/">${issue.id}</a></td>
                    </c:if>

                 <td class="l">${issue.priority}</td>
                 <td class="l">${issue.assignee.id} ${issue.assignee.firstName} ${issue.assignee.lastName}</td>
                 <td class="l">${issue.type}</td>
                 <td class="l">${issue.status.statusCode}</td>
                 <td class="l">${issue.summary}</td>
                </tr>
                </c:forEach>
            </table>
        </div>

        <jsp:include page="footer.jsp" />
    </body>
</html>