<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<table class="table">
	<tr>	
		<th>Name</th>
		<th>Creator</th>
		<th>Version</th>
		<th>Action</th>
	</tr>
<c:forEach items="${languages }" var="languageT" varStatus = "i">
	<tr>
		<td><c:out value="${languageT.name }"/></td>
		<td><c:out value="${languageT.creator }"/></td>
		<td><c:out value="${languageT.version }"/></td>
		<td><a href="/languages/delete/${i.index }">delete</a>    <a href="/languages/edit/${i.index }">edit</a></td>
	</tr>
</c:forEach>

</table>

<form:form method="POST" action="/languages/new" modelAttribute="language">
	<form:label path="name"><b>Name</b>
	<form:errors path="name"/>
	<form:input path="name"/></form:label><br>

	<form:label path="creator"><b>Creator</b>
	<form:errors path="creator"/>
	<form:input path="creator"/></form:label><br>
	
	<form:label path="version"><b>Version</b>
	<form:errors path="version"/>
	<form:input path="version"/></form:label><br>

	<input type="submit" value="Submit"/>
</form:form>
