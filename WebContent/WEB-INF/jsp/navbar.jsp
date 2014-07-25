<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container container-add">
	<div class="navbar menu-view" role="navigation">
            <ul class="nav nav-pills">

				<c:set var="url" value="${pageContext.request.contextPath}"/>
				<c:set var="submit_issue" scope="request"><spring:message code="label.submit_issue"/></c:set>
				<c:set var="home_page" scope="request"><spring:message code="label.home_page"/></c:set>

                <c:if test="${user.role == 'USER' || user.role == 'ADMINISTRATOR'}">
                    <c:if test="${sb eq 'disable'}"><li class="hidden"></c:if>
                    <c:if test="${sb ne 'disable'}"><li class="active"></c:if>                    
	                        <a href="${url}/submitIssue">${submit_issue}</a>
    	                </li>

                    <c:if test="${bb eq 'disable'}"><li class="hidden"></c:if>
                    <c:if test="${bb ne 'disable'}"><li class="active"></c:if>                                        
    	                    <a href="${url}/main">${home_page}</a>
        	            </li>
                </c:if>

                <c:if test="${user.role == 'ADMINISTRATOR'}">

                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
                        	<spring:message code="label.project"/>
                        	<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                             <a role="menuitem" href="${url}/projects"><spring:message code="label.all_projects"/></a>
                            </li>
                            <li>
                           	 <a role="menuitem" href="${url}/projectSubmit"><spring:message code="label.add_project"/></a>
                            </li>
                        </ul>
                    </li>

                    <li><a href="${url}/statuses"><spring:message code="label.status"/></a></li>

                    <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
                        	<spring:message code="label.resolution"/>
                        	<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                            	<a role="menuitem" href="${url}/resolutions"><spring:message code="label.all_resolutions"/></a>
                            </li>
                            <li>
                            	<a role="menuitem" href="${url}/resolutionSubmit"><spring:message code="label.add_resolution"/></a>
                            </li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a class="dropdown-toggle" disabled="disabled" role="button" data-toggle="dropdown" href="#">
                        	<spring:message code="label.priority"/>
                        	<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                            	 <a role="menuitem" href="#"><spring:message code="label.not_implemented"/></a>
                            </li>
                            <!--  <li>
                            	<a role="menuitem" href="${url}/priority">Search Priority</a>
                            </li>
                            <li>
                            	<a role="menuitem" href="${url}/prioritySubmit">Add Priority</a>
                            </li> -->
                        </ul>
                    </li>
                    
                    <li class="dropdown">
                        <a class="dropdown-toggle" disabled="disabled" role="button" data-toggle="dropdown" href="#">
                        	<spring:message code="label.type"/>
                        	<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                        	<li>
                            	 <a role="menuitem" href="#"><spring:message code="label.not_implemented"/></a>
                            </li>
                            <!--<li>
                            	 <a role="menuitem" href="${url}/type">Search Type</a>
                            </li>
                            <li>
                            	<a role="menuitem" href="${url}/typeSubmit">Add Type</a>
                            </li> -->
                        </ul>
                    </li>                    
                </c:if>
                
            </ul>
</div>