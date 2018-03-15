<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<table class="table">
<c:forEach items="${books }" var="book">
	<tr>
		<td><c:out value="${book.title }"/></td>
		<td><c:out value="${book.description }"/></td>
		<td><c:out value="${book.language }"/></td>
		<td><c:out value="${book.numberOfPages }"/></td>
	</tr>
</c:forEach>



</table>
