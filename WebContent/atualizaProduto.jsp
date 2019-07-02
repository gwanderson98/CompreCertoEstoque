<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar Funcionario</title>
</head>
<body>
	<h1>Arquitetura de refer�ncia</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL}">
			<h1>Ol� ${usuario.nome}</h1>
			<a href="logout">Logout</a>
			<a href="exibeFormCadastroFuncionario">Cadastrar novo Funcionario</a>
			<a href="listarTodos">Listar todos</a>
			<a href="listarFuncionarioTodos">Listar Funcionarios </a>
			<a href="listarProdutos">Listar Produtos</a>
			<a href="exibeFormCadastroProduto">Cadastrar Produto</a>
		</c:when>

		<c:otherwise>
			<c:if test="${erro != NULL}">${erro}</c:if>

			<form action="/comprecertoestoque/frontcontroller/login" method="post">
				Usuario:<input name="usuario"> Senha:<input name="senha">
				<input type="submit" value="ok">
			</form>
		</c:otherwise>
	</c:choose>
	<hr>
	<c:if test="${!empty produto }">
		<form action="/comprecertoestoque/frontcontroller/atualizaProduto" method="POST">
				Id :<input name="Id" value="${entidade.Id_produto}"> 
				Nome:<input name="Nome" value="${entidade.Nome}">
				Codigo Produto: <input name="Cod_produto" value="${entidade.Cod_produto}">
			<input type="submit" value="Atualizar">
		</form>
	</c:if>
</body>
</html>