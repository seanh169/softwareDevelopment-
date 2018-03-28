<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
	<title></title>
</head>
<body>
<h1>New Category</h1>
<form:form action="" method="POST" modelAttribute="category">
	<form:label path="name">Name:
		<form:errors path="name"></form:errors> 
		<form:input type="text" path="name"></form:input>
	</form:label><br><br>
	
	<input type="submit" value="Create">
	
</form:form><br>
</body>
</html>