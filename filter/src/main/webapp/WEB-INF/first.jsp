<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>First page</title>
	</head>
	<body>
		<h2>First page</h2>
		<c:out value="Bonjour ${ sessionScope.nom }"/>
		<div>
			<c:url value="second" var="second" />
			<a href="${ second }"> second </a>
		</div>
		<div>
			<c:url value="third" var="third" />
			<a href="${ third }"> third </a>
		</div>
		<div>
			<c:url value="deconnexion" var="deconnexion" />
			<a href="${ deconnexion }"> déconnexion </a>
		</div>
	</body>
</html>