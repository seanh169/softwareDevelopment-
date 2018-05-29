<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>Welcome ${emailz.name}</h1>

<h3>Courses</h3>
<table border="1px">
	<tr>
		<td>Course</td>
		<td>Instructor</td>
		<td>Signups</td>
		<td>Action</td>
	</tr>


<c:forEach items="${courses }" var="course">
	<tr>
		<td><a href="/courses/${course.id}">${course.name }</a></td>
		<td>${course.instructor}</td>
		<td>${fn:length(course.users) }/${course.signuplimit }</td>
		<c:if test="${fn:length(course.users) < course.signuplimit }">
		<td><a href="/courses/${course.id}/join">Add</a></td>
		</c:if>
		<c:if test="${fn:length(course.users) == course.signuplimit  }">
		<td>Full</td>
		</c:if>
		<c:forEach items="${course.users }" var="i">
			<c:if test="${i.name == emailz.name}">
				<td>Already Added</td>
			</c:if>
		</c:forEach>
	</tr>
</c:forEach>
</table>


<a href="/courses/new">Create Course</a>

