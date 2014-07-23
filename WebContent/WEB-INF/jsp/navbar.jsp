<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container container-add">
	<div class="navbar menu-view" role="navigation">
            <ul class="nav nav-pills">

                <c:if test="${user.role == 'USER' || user.role == 'ADMINISTRATOR'}">
                    <c:if test="${sb eq 'disable'}"><li class="hidden"></c:if>
                    <c:if test="${sb ne 'disable'}"><li class="active"></c:if>                    
	                        <a href="${pageContext.request.contextPath}/submitIssue">Submit Issue</a>
    	                </li>

                    <c:if test="${bb eq 'disable'}"><li class="hidden"></c:if>
                    <c:if test="${bb ne 'disable'}"><li class="active"></c:if>                                        
    	                    <a href="${pageContext.request.contextPath}/main">Home page</a>
        	            </li>
                </c:if>

                <c:if test="${user.role == 'ADMINISTRATOR'}">

                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
                        	Projects
                        	<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                             <a role="menuitem" href="${pageContext.request.contextPath}/projects">Projects</a>
                            </li>
                            <li>
                           	 <a role="menuitem" href="${pageContext.request.contextPath}/projectSubmit">Add Project</a>
                            </li>
                        </ul>
                    </li>

                    <li><a href="${pageContext.request.contextPath}/statuses">Statuses</a></li>

                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
                        	Resolutions
                        	<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                            	<a role="menuitem" href="${pageContext.request.contextPath}/resolutions">Resolutions</a>
                            </li>
                            <li>
                            	<a role="menuitem" href="${pageContext.request.contextPath}/resolutionSubmit">Add Resolution</a>
                            </li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a class="dropdown-toggle" disabled="disabled" role="button" data-toggle="dropdown" href="#">
                        	Priorities
                        	<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                            	 <a role="menuitem" href="#">this item is not implemented yet</a>
                            </li>
                            <!--  <li>
                            	<a role="menuitem" href="${pageContext.request.contextPath}/priority">Search Priority</a>
                            </li>
                            <li>
                            	<a role="menuitem" href="${pageContext.request.contextPath}/prioritySubmit">Add Priority</a>
                            </li> -->
                        </ul>
                    </li>
                    
                    <li class="dropdown">
                        <a class="dropdown-toggle" disabled="disabled" role="button" data-toggle="dropdown" href="#">
                        	Types
                        	<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                        	<li>
                            	 <a role="menuitem" href="#">this item is not implemented yet</a>
                            </li>
                            <!--<li>
                            	 <a role="menuitem" href="${pageContext.request.contextPath}/type">Search Type</a>
                            </li>
                            <li>
                            	<a role="menuitem" href="${pageContext.request.contextPath}/typeSubmit">Add Type</a>
                            </li> -->
                        </ul>
                    </li>                    
                </c:if>
                
            </ul>
</div>