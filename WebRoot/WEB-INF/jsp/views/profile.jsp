<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Profile</title>
</head>
<body>
	<h1>Your Profile</h1>
	<c:out value="${spitter.userName}"/><br/>
	<c:out value="${spitter.firstName}"/><br/>
	<c:out value="${spitter.lastName}"/><br/>
</body>
</html>