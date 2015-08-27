<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Title: ${title}</h1>
<h1>Message: ${msg}</h1>
<c:url var="logout" value="/j_spring_security_logout" />
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
	   <h2>Welcome : ${pageContext.request.userPrincipal.name} 
           | <a href="<c:url value="j_spring_security_logout" />" > Logout</a>  
	</c:if>
	<!--  <a href="http://localhost:8080/hello1/Logout">Logout</a></td>  -->
</body>
</html>