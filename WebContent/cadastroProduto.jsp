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
<h1>Arquitetura de referência</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL}">
			<h1>Olá ${usuario.nome}</h1>
		<a href="logout">Logout</a>
		<a href="exibeFormCadastroFuncionario">Cadastrar novo Funcionario</a>
		<a href="listarTodos">Listar todos</a>
		<a href="listarFuncionarioTodos">Listar Funcionarios </a>
		<a href="cadastrarProduto">Cadastrar Produto</a>
		</c:when>

		<c:otherwise>
			<c:if test="${erro != NULL}">${erro}</c:if>

			<form action="login" method="post">
				Usuario:<input name="usuario"> Senha:<input name="senha">
				<input type="submit" value="ok">
			</form>
		</c:otherwise>
	</c:choose>
	<hr>
	${msg}
	<form action="cadastrarProduto" method="post">
		ID Produto:<input name="id"> Nome Produto:<input name="nome">
		Codigo Produto: <input name="cod_produto"> <input type="submit"
			value="ok">
	</form>
</body>
</html>