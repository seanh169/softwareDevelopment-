<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<a href="/languages">Dashboard</a>


<p>Name: ${language.name}</p>
<p>Creator : ${language.creator}</p>
<p>Version : ${language.version}</p><br>


<a href="/languages/${language.id}/update">Edit</a>
<a href="/languages/${language.id}/delete">Delete</a>