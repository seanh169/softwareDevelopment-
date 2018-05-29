<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1>Edit ${currentcourse.name }</h1>

<form:form action="/courses/${currentcourse.id}/edit" method="post" modelAttribute="edit">

		<p>
			<form:label path="name">Name:
				<form:errors path="name"></form:errors>
				<form:input type="text" path="name"></form:input>
			</form:label>
		</p>
		<p>
			<form:label path="instructor">Instructor
				<form:errors path="instructor"></form:errors>
				<form:input type="text" path="instructor"></form:input>
			</form:label>
		</p>
		<p>
			<form:label path="signuplimit">Limit: 
				<form:errors path="signuplimit"></form:errors>
				<form:input type="text" path="signuplimit"></form:input>
			</form:label>
		</p>
		
		<input type="submit" value="Update">



</form:form>