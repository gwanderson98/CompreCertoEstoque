<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${funcionario != NULL}">
			<h1>Perfil</h1>
		</c:when>
		<c:otherwise>
			<h1>Ocorreu um erro</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>