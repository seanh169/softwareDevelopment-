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
<h1>${category.name }</h1>
<form action="/categories/{id}/join" method="POST">
<select name="product_id">
<c:forEach items="${product }" var="products">
<option value=${products.id }>${products.name }</option>
</c:forEach>
</select><br><br>
<input type="submit" value="add">
</form>
<h3>Products</h3>
<c:forEach items="${category.products }" var="prod">
	<p>${prod.name }</p>
</c:forEach>

</body>
</html>