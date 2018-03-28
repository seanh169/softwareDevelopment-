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
	
	<h1>${product.name }</h1><br><br>
	<form action="/products/${product.id }/join" method="POST" modelAttribute ="addcat">
	<p>Add Category:</p>
	<select name="category_id">
		<c:forEach items="${category }" var="categories">
		<option value="${categories.id }">${categories.name }</option>
		</c:forEach>
	</select>
	</select><br><br>
	<input type="submit" value="add">
	</form>
	
	<h2>Categories</h2>
	
	<c:forEach items="${ product.categories }" var="cat">
		<p>${cat.name }</p>
	
	</c:forEach>
	
</body>
</html>