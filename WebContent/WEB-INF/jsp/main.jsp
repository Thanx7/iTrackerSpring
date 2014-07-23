<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Tracker</title>
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
                    <td class="l"><a href="main?sort=id">Id</a></td>
                    <td class="l"><a href="main?sort=priority">Priority</a></td>
                    <td class="l"><a href="main?sort=assignee">Assignee</a></td>
                    <td class="l"><a href="main?sort=type">Type</a></td>
                    <td class="l"><a href="main?sort=status">Status</a></td>
                    <td class="l"><a href="main?sort=summary">Summary</a></td>
                </tr>

                <c:forEach var="issue" items="${issueList}" >
                <tr>
                
					<c:if test="${not empty user}">
                 		<td class="l"><a href="issue?id=${issue.id}">${issue.id}</a></td>
                    </c:if>
					<c:if test="${empty user}">
                 		<td class="l"><a href="issueDetails?id=${issue.id}">${issue.id}</a></td>
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