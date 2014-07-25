<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.all_projects"/></title>
<jsp:include page="scripts.jsp"/>
</head>

<body>
        <jsp:include page="header.jsp"/>		
        <jsp:include page="navbar.jsp"/>

            <table class="table table-striped table-hover table-view">
                <tr>
                    <td class="l"><spring:message code="label.name"/></td>
                    <td class="l"><spring:message code="label.manager"/></td>
                    <td class="l"><spring:message code="label.description"/></td>
                </tr>

                <c:forEach var="project" items="${projects}" >
                <tr>
	           		<td class="l"><a href="project/${project.id}/">${project.projectName}</a></td>
    	            <td class="l">${project.manager.firstName} ${project.manager.lastName}</td>
        	        <td class="l">${project.description}</td>
                </tr>
                </c:forEach>
            </table>
        </div>

        <jsp:include page="footer.jsp" />
</body>
</html>