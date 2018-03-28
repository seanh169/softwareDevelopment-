<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1>Create a new course</h1>

<form:form action="/courses/new" method="post" modelAttribute = "course">

		<p>
			<form:label path="name">Name:
				<form:errors path="name"></form:errors>
				<form:input type="text" path="name"></form:input>
			</form:label>
		</p>
		<p>
			<form:label path="instructor">Instructor:
				<form:errors path="instructor"></form:errors>
				<form:input type="text" path="instructor"></form:input>
			</form:label>
		</p>
		<p>
			<form:label path="signuplimit">Signup Limit:
				<form:errors path="signuplimit"></form:errors>
				<form:input type="int" path="signuplimit"></form:input>
			</form:label>
		</p>

	<input type="submit" value="Create">




</form:form>