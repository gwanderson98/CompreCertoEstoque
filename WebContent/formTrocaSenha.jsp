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
		<a href="listarFuncionarioTodos">Listar Funcionarios </a>
		<a href="exibeFormCadastroProduto">Cadastrar Produto</a>
		<a href="listarProdutos">Listar Produtos</a>
		<a href="exibeFormCadastroEstoque">Inserir no Estoque</a>
		<a href="mostrarEstoque">Mostrar Estoque</a>
		</c:when>

	</c:choose>
	<hr>
		<form action="/comprecertoestoque/frontcontroller/atualizarSenha" method="POST">
				Email:<input name="email"> 
				Nova Senha:<input name="senha">
				Confirme a Senha: <input name="confSenha">
			<input type="submit" value="Atualizar">
		</form>
</body>
</html>