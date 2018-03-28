<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>





<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<p>${listing.address }</p>
	<p>${listing.description }</p>
	<p>Email: ${listing.user.email }</p>
	<p>Name: ${listing.user.firstName } ${listing.user.lastName }</p>
	<p>Size: ${listing.size }</p>
	<p>Cost: ${listing.cost }</p>
	
	<strong>Reviews (   /  5 )</strong>
	
	
	<c:if test="${!user.host }"><a href="/listings/${listing.id}/review ">Leave a Review</a></c:if>
	
	
	<div class="reviews">
		<c:forEach items="${listing.reviews }" var = "review">
			<p>${review.user.firstName }:</p>
			<p>Rating: ${review.rating }/5:</p>
			<p>${review.description }</p>
		
		</c:forEach>
	
	
	</div>
</body>
</html>