<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>All Projects</title>
<jsp:include page="scripts.jsp"/>
</head>

<body>
        <jsp:include page="header.jsp"/>		
        <jsp:include page="navbar.jsp"/>

            <table class="table table-striped table-hover table-view">
                <tr>
                    <td class="l">Name</td>
                    <td class="l">Manager</td>
                    <td class="l">Description</td>
                </tr>

                <c:forEach var="project" items="${projects}" >
                <tr>
	           		<td class="l"><a href="project?id=${project.id}">${project.projectName}</a></td>
    	            <td class="l">${project.manager.firstName} ${project.manager.lastName}</td>
        	        <td class="l">${project.description}</td>
                </tr>
                </c:forEach>
            </table>
        </div>

        <jsp:include page="footer.jsp" />
</body>
</html>