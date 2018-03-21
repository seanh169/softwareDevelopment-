<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<form:form action="/ninjas/new" method="POST" modelAttribute="ninjaz"> 
Dojo  <form:select path="dojo" name="dojo">
<c:forEach items="${dojozz }" var="dojo">
	<option value="${dojo.id }">${dojo.name }</option>
</c:forEach>
</form:select><br><br>
 <form:label path="firstName">First Name:
 <form:errors path="firstName"></form:errors> 
 <form:input type="text" path="firstName"></form:input>
 </form:label><br><br>
 <form:label path="lastName">Last name:
 <form:errors path="lastName"></form:errors> 
 <form:input type="text" path="lastName"></form:input>
 </form:label><br><br>
 <form:label path="age">Age: 
 <form:errors path="age"></form:errors> 
 <form:input type="number" path="age"></form:input>
 </form:label><br><br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Create Ninja!">
  </form:form> 
  
  <a href="/dojos/new">Create New Dojo!</a>