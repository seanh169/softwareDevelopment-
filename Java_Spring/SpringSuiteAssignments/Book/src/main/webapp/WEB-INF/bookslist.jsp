<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<ul>
<c:forEach items="${books }" var="book">
	<li>
		<c:out value="${book.title }"/>
		<c:out value="${book.description }"/>
		<c:out value="${book.language }"/>
		<c:out value="${book.numberOfPages }"/>
	</li>
</c:forEach>



</ul>
