<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<form style="border:1px solid black" action="/result" method="POST">
			<input type="text" name="firstname" placeholder="first name"><br>
			<span>Dojo Location</span>
			<select name="DojoLoc">
				<option value="sanjose">San Jose, California</option>
				<option value="newyork">New York, New York</option>
				<option value="mclean">McLean, Virginia</option>
			</select><br>
			<span>Favorite Language</span>
			<select name="FavoriteLang">
				<option value="python">Python</option>
				<option value="javascript">Javascript</option>
				<option value="java">Java</option>
			</select><br>
			<span>Comment(optional)</span><br>
			<textarea name="comment" rows = "10" cols= "40"></textarea><br><br>
			<input type="submit" name="submit" value="Submit">
		
		</form>
	</body>
</html>