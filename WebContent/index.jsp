<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arquitetura de referência</title>
</head>
<body>
	<h1>Compre Certo</h1>
	<hr>
	<form action="/comprecertoestoque/frontcontroller/login" method="post">
		Email:<input name="email"> <br>
		Senha:<input name="senha">
		<input type="submit" value="ok">
	</form>
	<form action="/comprecertoestoque/frontcontroller/esqueciSenha" method="get">
		<input type="submit" value="Esqueci senha">
	</form>
</body>
</html>

