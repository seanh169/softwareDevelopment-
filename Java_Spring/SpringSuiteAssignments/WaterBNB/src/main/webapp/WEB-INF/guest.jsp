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
<c:if test="${user != null }"><a href="/listings">Home</a></c:if>
<c:if test="${user != null }"><a href="/users/new">Logout</a></c:if>

<h1>find your Listing!</h1>

<form method="GET" action="/listings/search">
	<input type="text" name="search">
	
	<input type="submit" value="Search">
</form>

<table>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>	
	<c:forEach items="${listings }" var="listing">
		<tr>
			<th>Address</th>
			<th>Size</th>
			<th>Cost</th>
			<th>Details</th>
		</tr>
		
		<tr>
			<td>${listing.address }</td>
			<td>${listing.size }</td>
			<td>${listing.cost }</td>
			<td> <a href="/listings/${listing.id }">See More</a></td>
		</tr>		
	</c:forEach>
</table>

</body>
</html>