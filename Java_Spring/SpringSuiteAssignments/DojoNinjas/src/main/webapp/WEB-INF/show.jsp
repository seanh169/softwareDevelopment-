<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h1>${dojo.name } Location Ninjas</h1>
<table border="1">
	
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
		
	</tr>

<c:forEach items="${ninjaz }" var="ninja">
	<tr>
	<c:if test="${ninja.dojo.id == dojo.id}">
		
		<td>${ninja.firstName}</td><td> ${ninja.lastName}</td><td> ${ninja.age }</td> <br>
	</c:if>
	</tr>
</c:forEach>

</table><br>
<a href="/ninjas/new">Create New Ninja!</a>&nbsp;&nbsp;&nbsp;
<a href="/dojos/new">Create New Dojo!</a>