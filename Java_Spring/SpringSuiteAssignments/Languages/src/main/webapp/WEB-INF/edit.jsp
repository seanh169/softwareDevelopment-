<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<a href="/languages/delete/${i.index }">Delete</a>   <a href="/languages">Dashboard</a>
<form:form method="POST" action="/languages/edit/${id}" modelAttribute="language">
	<form:label path="name"><b>Name</b>
	<form:errors path="name"/>
	<form:input path="name"/></form:label><br>

	<form:label path="creator"><b>Creator</b>
	<form:errors path="creator"/>
	<form:input path="creator"/></form:label><br>
	
	<form:label path="version"><b>Version</b>
	
	<form:input path="version"/></form:label><br>
	<form:errors path="version"/>

	<input type="submit" value="Submit"/>
</form:form>