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
	<h1>New Product</h1>
	<form:form action="" method="POST" modelAttribute="product">
	<form:label path="name">Name:
		<form:errors path="name"></form:errors> 
		<form:input type="text" path="name"></form:input>
	</form:label><br><br>
	<form:label path="description">Description
		<form:errors path="description"></form:errors> 
		<form:input type="text" path="description"></form:input>
	</form:label><br><br>
	<form:label path="price">Price
		<form:errors path="price"></form:errors> 
		<form:input type="float" path="price"></form:input>
	</form:label><br><br>
	<input type="submit" value="Create">
	
</form:form><br>

</body>
</html>