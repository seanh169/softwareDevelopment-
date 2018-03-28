<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<h1>${currentcourse.name}</h1>

Instructor: ${currentcourse.instructor}<br>

Sign Ups: ${fn:length(currentcourse.users) } <a href="/courses/sort">Sort Ascending</a> <a href="">Sort Descending</a>
<table border="1px">
	<tr>	
		<td>Name</td>
		<td>Sign Up Date</td>
		<td>Action</td>
	</tr>




<c:forEach items="${cz }" var="czs">
	<c:forEach items="${czs.users }" var ="x">
	<c:set var="exist" scope="session" value="2"/>
	<c:forEach items="${x.courses }" var="y">
		<c:if test="${y.id == currentcourse.id }">
			<c:set var="exist" scope="session" value ="1"/>
		</c:if>
	</c:forEach>
	<c:if test="${exist == 1 }">
		<tr>
			<td>${x.name }</td>
			<td>${x.createdAt }</td>
			 <c:if test="${x.name == currentuser.name }" >
			<td><a href="/courses/${currentcourse.id }/remove">Remove</a></td>
			</c:if>
		</tr>
	</c:if>
		
	</c:forEach>
	
</c:forEach>
	
</table>
<a href="/courses/${currentcourse.id }/edit">Edit</a> <a href="/courses/${currentcourse.id }/delete">Delete</a>

