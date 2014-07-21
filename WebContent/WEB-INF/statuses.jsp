<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Statuses</title>
<jsp:include page="scripts.jsp"/>
</head>

<body>
        <jsp:include page="header.jsp"/>		
        <jsp:include page="navbar.jsp"/>

            <table class="table table-striped table-hover table-view">
                <tr>
                    <td class="l">Name</td>
                </tr>

                <c:forEach var="status" items="${statuses}" >
                <tr>
                
	           		<td class="l"><a href="status?id=${status.id}">${status.statusCode}</a></td>
                </tr>
                </c:forEach>
            </table>
        </div>

        <jsp:include page="footer.jsp" />
</body>
</html>