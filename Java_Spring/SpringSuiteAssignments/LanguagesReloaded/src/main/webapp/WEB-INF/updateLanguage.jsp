<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<a href="/languages">Dashboard</a><form action="/languages/${id }/delete" method="POST">
<input type="submit" value="delete"></form>
<form:form action="/languages/${id}/edit" method="POST" modelAttribute="langz">
<%-- Name:<input type="text" placeholder="${language.name}"><br>

Creator:<input type="text" placeholder="${language.creator}"><br>

Version:<input type="text" placeholder="${language.version}"><br> --%>
	
	<form:label path="name">
		<form:errors path="name"></form:errors>
		<form:input type="text" path="name"></form:input>
	</form:label><br><br>
	<form:label path="creator">
		<form:errors path="creator"></form:errors>
		<form:input type="text" path="creator"></form:input>
	</form:label><br><br>
	<form:label path="version">
		<form:errors path="version"></form:errors>
		<form:input type="number" path="version"></form:input>
	</form:label><br><br>
	<input type="submit" value="Make Changes!">
 	






	

</form:form>