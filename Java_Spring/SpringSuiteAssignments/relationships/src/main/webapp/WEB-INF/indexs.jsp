<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<h1>New Person</h1>

<form:form action="/persons/new" method="POST" modelAttribute="person">
	<form:label path="firstName">First Name:
		<form:errors path="firstName"></form:errors> 
		<form:input type="text" path="firstName"></form:input>
	</form:label><br><br>
	<form:label path="lastName">Last Name: 
		<form:errors path="lastName"></form:errors>
		<form:input type="text" path="lastName"></form:input>
	</form:label><br><br>

	
	
	<input type="submit" value="Create Name!">

</form:form>