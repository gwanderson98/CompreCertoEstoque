<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de produtos</title>
</head>
<body>
<h1>Cadastro de produto</h1>
	<hr>
	<a href="/comprecertoestoque/frontcontroller/login">HOME</a>
	<c:if test="${msg != NULL}">${msg}</c:if>
	<form action="/comprecertoestoque/frontcontroller/cadastrarProduto" method="POST">
		Nome Produto:<input name="nome">
		Codigo Produto: <input name="codProduto">
		Quantidade Produto: <input name="quantidade">
		Quantidade Minima: <input name="quantidadeMinima">
		<input type="submit" value="salvar">
	</form>
</body>
</html>