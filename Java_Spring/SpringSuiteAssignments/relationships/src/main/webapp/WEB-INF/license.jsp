<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<h1>New License</h1>
<form:form action="/licenses/new" method="POST" modelAttribute="license">

Person:   <form:select path="person" name="person">
<c:forEach items="${personz }" var="people">
	<option value="${people.id }">${people.firstName }</option>
</c:forEach>
</select></form:select><br>
 <form:label path="state">State: 
 <form:input type="text" path="state"></form:input>
 </form:label><br>
 <form:label path="expiration_date">Date:
 <form:input type="date" path="expiration_date"></form:input>
 </form:label><br>
 <input type="submit" value="Create!">
</form:form>

<%-- <form:form action="" method="POST" modelAttribute="person">
	<form:label path="person">Person: 
		<form:errors path="person"></form:errors>
		<form:input type="s" path="name"></form:input>
	</form:label><br><br>
	<form:label path="state">State: 
		<form:errors path="state"></form:errors>
		<form:input type="text" path="state"></form:input>
	</form:label><br><br>
	<form:label path="expiration">Expiration Date
		<form:errors path="expiration"></form:errors>
		<form:input type="number" path="expiration"></form:input>
	</form:label><br><br>
	
	
	<input type="submit" value="Create Langauge!">

</form:form> --%>