<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<table border="1">

	<tr>
		<th>Name:</th>
		<th>Creator:</th>
		<th>Version:</th>
		<th>Action:</th>
	</tr>
<c:forEach items="${languages }" var="lang">
	<tr>
		<td><a href="/languages/${lang.id}">${ lang.name }</a></td>
		<td>${lang.creator}</td>
		<td>${lang.version}</td>
		
		<td><form action="/languages/${lang.id }/delete" method="POST">
			<input type="submit" value="delete">
		</form> <a href="/languages/${lang.id}/edit">Edit</a></td>
	</tr>
</c:forEach>	
</table>
<br><br><br>

<h1>Create a language!</h1>


<form:form action="/languages" method="POST" modelAttribute="language">
	<form:label path="name">Name: 
		<form:errors path="name"></form:errors>
		<form:input type="text" path="name"></form:input>
	</form:label><br><br>
	<form:label path="creator">Creator: 
		<form:errors path="creator"></form:errors>
		<form:input type="text" path="creator"></form:input>
	</form:label><br><br>
	<form:label path="version">Version:
		<form:errors path="version"></form:errors>
		<form:input type="number" path="version"></form:input>
	</form:label><br><br>
	
	
	<input type="submit" value="Create Langauge!">

</form:form>